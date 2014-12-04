package ch.cyberduck.ui;

/*
 * Copyright (c) 2002-2010 David Kocher. All rights reserved.
 *
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import ch.cyberduck.core.DisabledHostKeyCallback;
import ch.cyberduck.core.Factory;
import ch.cyberduck.core.FactoryException;
import ch.cyberduck.core.HostKeyCallback;
import ch.cyberduck.core.Protocol;
import ch.cyberduck.core.Scheme;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version $Id$
 */
public class HostKeyCallbackFactory extends Factory<HostKeyCallback> {
    private static final Logger log = Logger.getLogger(HostKeyCallbackFactory.class);

    private static final Preferences preferences
            = PreferencesFactory.get();

    public HostKeyCallback create(final Controller c, final Protocol protocol) {
        if(Scheme.sftp.equals(protocol.getScheme())) {
            final String clazz = preferences.getProperty("factory.hostkeycallback.class");
            if(null == clazz) {
                throw new FactoryException();
            }
            try {
                final Class<HostKeyCallback> name = (Class<HostKeyCallback>) Class.forName(clazz);
                final Constructor<HostKeyCallback> constructor = ConstructorUtils.getMatchingAccessibleConstructor(name, c.getClass());
                if(null == constructor) {
                    log.warn(String.format("No matching constructor for %s", c.getClass()));
                    // Call default constructor for disabled implementations
                    return name.newInstance();
                }
                return constructor.newInstance(c);
            }
            catch(InstantiationException e) {
                throw new FactoryException(e.getMessage(), e);
            }
            catch(IllegalAccessException e) {
                throw new FactoryException(e.getMessage(), e);
            }
            catch(ClassNotFoundException e) {
                throw new FactoryException(e.getMessage(), e);
            }
            catch(InvocationTargetException e) {
                throw new FactoryException(e.getMessage(), e);
            }
        }
        return new DisabledHostKeyCallback();
    }

    /**
     * @param c Window controller
     * @return Login controller instance for the current platform.
     */
    public static HostKeyCallback get(final Controller c, final Protocol protocol) {
        return new HostKeyCallbackFactory().create(c, protocol);
    }
}
