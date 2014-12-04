package ch.cyberduck.core;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.cdn.DistributionConfiguration;
import ch.cyberduck.core.cloudfront.CustomOriginCloudFrontDistributionConfiguration;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Download;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Home;
import ch.cyberduck.core.features.Upload;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.shared.DefaultAttributesFeature;
import ch.cyberduck.core.shared.DefaultDownloadFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.shared.DefaultHomeFinderService;
import ch.cyberduck.core.shared.DefaultUploadFeature;
import ch.cyberduck.core.shared.DefaultUrlProvider;
import ch.cyberduck.core.threading.CancelCallback;

import org.apache.log4j.Logger;

import java.util.EnumSet;

/**
 * @version $Id$
 */
public abstract class Session<C> implements TranscriptListener {
    private static final Logger log = Logger.getLogger(Session.class);

    /**
     * Encapsulating all the information of the remote host
     */
    protected Host host;

    protected C client;

    private TranscriptListener listener;

    /**
     * Connection attempt being made.
     */
    private State state = State.closed;

    private DistributionConfiguration cloudfront;

    private Preferences preferences
            = PreferencesFactory.get();

    public boolean alert() throws BackgroundException {
        if(host.getProtocol().isSecure()) {
            return false;
        }
        if(host.getCredentials().isAnonymousLogin()) {
            return false;
        }
        if(preferences.getBoolean(String.format("connection.unsecure.%s", host.getHostname()))) {
            return false;
        }
        return preferences.getBoolean(
                String.format("connection.unsecure.warning.%s", host.getProtocol().getScheme()));
    }

    public enum State {
        opening,
        open,
        closing,
        closed
    }

    protected Session(final Host h) {
        this.host = h;
    }

    /**
     * @return The client implementation.
     */
    public C getClient() {
        return client;
    }

    /**
     * Connect to host
     *
     * @param key        Host identity verification callback
     * @param transcript Transcript
     * @return Client
     * @throws BackgroundException
     */
    public C open(final HostKeyCallback key, final TranscriptListener transcript) throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Connection will open to %s", host));
        }
        // Update status flag
        state = State.opening;
        listener = transcript;
        client = this.connect(key);
        if(log.isDebugEnabled()) {
            log.debug(String.format("Connection did open to %s", host));
        }
        // Update status flag
        state = State.open;
        return client;
    }

    protected abstract C connect(HostKeyCallback key) throws BackgroundException;

    public void login(final PasswordStore keychain,
                      final LoginCallback prompt, final CancelCallback cancel)
            throws BackgroundException {
        this.login(keychain, prompt, cancel, Cache.<Path>empty());
    }

    /**
     * Send the authentication credentials to the server. The connection must be opened first.
     *
     * @param keychain Password store
     * @param prompt   Prompt
     * @param cancel   Cancel callback
     * @param cache    Directory listing cache
     */
    public abstract void login(PasswordStore keychain,
                               LoginCallback prompt, CancelCallback cancel,
                               Cache<Path> cache)
            throws BackgroundException;

    /**
     * Logout and close client connection
     *
     * @throws BackgroundException
     */
    public void close() throws BackgroundException {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Connection will close to %s", host));
        }
        state = State.closing;
        try {
            this.logout();
            if(client != null) {
                this.disconnect();
            }
        }
        finally {
            state = State.closed;
            if(log.isDebugEnabled()) {
                log.debug(String.format("Connection did close to %s", host));
            }
        }
    }

    public void interrupt() throws BackgroundException {
        state = State.closing;
        try {
            if(client != null) {
                this.disconnect();
            }
        }
        finally {
            state = State.closed;
            if(log.isDebugEnabled()) {
                log.debug(String.format("Connection did close to %s", host));
            }
            listener = null;
        }
    }

    /**
     * Close the connection to the remote host. Subsequent calls to #getClient() must return null.
     */
    protected abstract void logout() throws BackgroundException;

    protected void disconnect() {
        state = State.closed;
    }

    /**
     * @return The timeout in milliseconds
     */
    protected int timeout() {
        return preferences.getInteger("connection.timeout.seconds") * 1000;
    }

    /**
     * @return True if the control channel is either tunneled using TLS or SSH
     */
    public boolean isSecured() {
        if(this.isConnected()) {
            return host.getProtocol().isSecure();
        }
        return false;
    }

    /**
     * @return The current working directory
     */
    public Path workdir() throws BackgroundException {
        return new Path(String.valueOf(Path.DELIMITER), EnumSet.of(Path.Type.volume, Path.Type.directory));
    }

    /**
     * @return the host this session connects to
     */
    public Host getHost() {
        return host;
    }

    /**
     * @return The custom character encoding specified by the host
     * of this session or the default encoding if not specified
     * @see Preferences
     * @see Host
     */
    public String getEncoding() {
        if(null == host.getEncoding()) {
            return preferences.getProperty("browser.charset.encoding");
        }
        return host.getEncoding();
    }

    /**
     * @return The maximum number of concurrent connections allowed or -1 if no limit is set
     */
    public int getMaxConnections() {
        return host.getTransfer().getMaxConnections();
    }

    /**
     * @return boolean True if the session has not yet been closed.
     */
    public boolean isConnected() {
        return state == State.open;
    }

    /**
     * @return True if a connection attempt is currently being made. False if the connection
     * has already been established or is closed.
     */
    public State getState() {
        return state;
    }

    /**
     * Log the message to all subscribed transcript listeners
     *
     * @param message Log line
     * @see TranscriptListener
     */
    @Override
    public void log(final boolean request, final String message) {
        if(log.isInfoEnabled()) {
            log.info(message);
        }
        listener.log(request, message);
    }

    /**
     * @param directory     Directory
     * @param listener Callback
     */
    public abstract AttributedList<Path> list(Path directory, ListProgressListener listener) throws BackgroundException;

    public <T> T getFeature(final Class<T> type) {
        if(type == Upload.class) {
            return (T) new DefaultUploadFeature(this);
        }
        if(type == Download.class) {
            return (T) new DefaultDownloadFeature(this);
        }
        if(type == DistributionConfiguration.class) {
            if(null == cloudfront) {
                // Use login context of current session
                cloudfront = new CustomOriginCloudFrontDistributionConfiguration(host, this);
            }
            return (T) cloudfront;
        }
        if(type == UrlProvider.class) {
            return (T) new DefaultUrlProvider(host);
        }
        if(type == Find.class) {
            return (T) new DefaultFindFeature(this);
        }
        if(type == ch.cyberduck.core.features.Attributes.class) {
            return (T) new DefaultAttributesFeature(this);
        }
        if(type == Home.class) {
            return (T) new DefaultHomeFinderService(this);
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Session{");
        sb.append("host=").append(host);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }
}