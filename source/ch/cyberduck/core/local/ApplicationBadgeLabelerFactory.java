package ch.cyberduck.core.local;

/*
 * Copyright (c) 2012 David Kocher. All rights reserved.
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

import ch.cyberduck.core.Factory;
import ch.cyberduck.core.preferences.PreferencesFactory;

/**
 * @version $Id$
 */
public class ApplicationBadgeLabelerFactory extends Factory<ApplicationBadgeLabeler> {

    public ApplicationBadgeLabelerFactory() {
        super("factory.badgelabeler.class");
    }

    public static ApplicationBadgeLabeler get() {
        if(PreferencesFactory.get().getBoolean("queue.dock.badge")) {
            return new ApplicationBadgeLabelerFactory().create();
        }
        return new DisabledApplicationBadgeLabeler();
    }
}