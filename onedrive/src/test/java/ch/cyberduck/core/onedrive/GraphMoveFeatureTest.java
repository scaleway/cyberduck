package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.AttributesFinder;
import ch.cyberduck.core.features.Delete;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.features.Find;
import ch.cyberduck.core.features.Move;
import ch.cyberduck.core.features.Touch;
import ch.cyberduck.core.onedrive.features.GraphAttributesFinderFeature;
import ch.cyberduck.core.onedrive.features.GraphDeleteFeature;
import ch.cyberduck.core.onedrive.features.GraphDirectoryFeature;
import ch.cyberduck.core.onedrive.features.GraphFileIdProvider;
import ch.cyberduck.core.onedrive.features.GraphMoveFeature;
import ch.cyberduck.core.onedrive.features.GraphTouchFeature;
import ch.cyberduck.core.shared.DefaultFindFeature;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Collections;
import java.util.EnumSet;

import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class GraphMoveFeatureTest extends AbstractOneDriveTest {

    @Test
    public void testRename() throws BackgroundException {
        final GraphFileIdProvider fileid = new GraphFileIdProvider(session);
        final Touch touch = new GraphTouchFeature(session, fileid);
        final Move move = new GraphMoveFeature(session, fileid);
        final Delete delete = new GraphDeleteFeature(session, fileid);
        final AttributesFinder attributesFinder = new GraphAttributesFinderFeature(session);
        final Path drive = new OneDriveHomeFinderService().find();
        final Path file = touch.touch(new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), new TransferStatus().withMime("x-application/cyberduck"));
        final PathAttributes attributes = attributesFinder.find(file);
        assertNotNull(attributes);
        assertEquals(file.attributes().getFileId(), attributes.getFileId());
        Path rename = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        assertTrue(move.isSupported(file, rename));
        final TransferStatus status = new TransferStatus().exists(true);
        final Path target = move.move(file, rename, status, new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertEquals(file.attributes().getFileId(), target.attributes().getFileId());
        assertEquals(attributes, attributesFinder.find(rename));
        delete.delete(Collections.singletonList(rename), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testMove() throws BackgroundException {
        final GraphFileIdProvider fileid = new GraphFileIdProvider(session);
        final Directory directory = new GraphDirectoryFeature(session, fileid);
        final Touch touch = new GraphTouchFeature(session, fileid);
        final Move move = new GraphMoveFeature(session, fileid);
        final Delete delete = new GraphDeleteFeature(session, fileid);
        final AttributesFinder attributesFinder = new GraphAttributesFinderFeature(session);
        final Path drive = new OneDriveHomeFinderService().find();
        Path targetDirectory = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        directory.mkdir(targetDirectory, null, new TransferStatus());
        assertNotNull(attributesFinder.find(targetDirectory));

        Path touchedFile = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        touch.touch(touchedFile, new TransferStatus().withMime("x-application/cyberduck"));
        assertNotNull(attributesFinder.find(touchedFile));

        Path rename = new Path(targetDirectory, touchedFile.getName(), EnumSet.of(Path.Type.file));
        assertTrue(move.isSupported(touchedFile, rename));
        move.move(touchedFile, rename, new TransferStatus(), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertNotNull(attributesFinder.find(rename));

        delete.delete(Collections.singletonList(targetDirectory), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testMoveToRoot() throws BackgroundException {
        final GraphFileIdProvider fileid = new GraphFileIdProvider(session);
        final Directory directory = new GraphDirectoryFeature(session, fileid);
        final Touch touch = new GraphTouchFeature(session, fileid);
        final Move move = new GraphMoveFeature(session, fileid);
        final Delete delete = new GraphDeleteFeature(session, fileid);
        final AttributesFinder attributesFinder = new GraphAttributesFinderFeature(session);
        final Path drive = new OneDriveHomeFinderService().find();
        Path targetDirectory = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        directory.mkdir(targetDirectory, null, new TransferStatus());
        assertNotNull(attributesFinder.find(targetDirectory));

        Path touchedFile = new Path(targetDirectory, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        touch.touch(touchedFile, new TransferStatus().withMime("x-application/cyberduck"));
        assertNotNull(attributesFinder.find(touchedFile));

        Path rename = new Path(drive, touchedFile.getName(), EnumSet.of(Path.Type.file));
        assertTrue(move.isSupported(touchedFile, rename));
        move.move(touchedFile, rename, new TransferStatus(), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertNotNull(attributesFinder.find(rename));

        delete.delete(Collections.singletonList(targetDirectory), new DisabledLoginCallback(), new Delete.DisabledCallback());
        delete.delete(Collections.singletonList(rename), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testMoveRename() throws BackgroundException {
        final GraphFileIdProvider fileid = new GraphFileIdProvider(session);
        final Directory directory = new GraphDirectoryFeature(session, fileid);
        final Touch touch = new GraphTouchFeature(session, fileid);
        final Move move = new GraphMoveFeature(session, fileid);
        final Delete delete = new GraphDeleteFeature(session, fileid);
        final AttributesFinder attributesFinder = new GraphAttributesFinderFeature(session);
        final Path drive = new OneDriveHomeFinderService().find();
        Path targetDirectory = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory));
        directory.mkdir(targetDirectory, null, new TransferStatus());
        assertNotNull(attributesFinder.find(targetDirectory));

        Path touchedFile = new Path(drive, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        touch.touch(touchedFile, new TransferStatus().withMime("x-application/cyberduck"));
        assertNotNull(attributesFinder.find(touchedFile));

        Path rename = new Path(targetDirectory, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file));
        assertTrue(move.isSupported(touchedFile, rename));
        move.move(touchedFile, rename, new TransferStatus(), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        assertNotNull(attributesFinder.find(rename));

        delete.delete(Collections.singletonList(targetDirectory), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }

    @Test
    public void testMoveToExistingFile() throws Exception {
        final GraphFileIdProvider fileid = new GraphFileIdProvider(session);
        final Path folder = new GraphDirectoryFeature(session, fileid).mkdir(new Path(new OneDriveHomeFinderService().find(), new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.directory)), null, new TransferStatus());
        final String name = new AlphanumericRandomStringService().random();
        final Path test = new GraphTouchFeature(session, fileid).touch(new Path(folder, name, EnumSet.of(Path.Type.file)), new TransferStatus());
        final Path temp = new GraphTouchFeature(session, fileid).touch(new Path(folder, new AlphanumericRandomStringService().random(), EnumSet.of(Path.Type.file)), new TransferStatus());
        new GraphMoveFeature(session, fileid).move(temp, new Path(folder, name, EnumSet.of(Path.Type.file)), new TransferStatus().exists(true), new Delete.DisabledCallback(), new DisabledConnectionCallback());
        final Find find = new DefaultFindFeature(session);
        final AttributedList<Path> files = new GraphItemListService(session).list(folder, new DisabledListProgressListener());
        assertEquals(1, files.size());
        assertFalse(find.find(temp));
        assertTrue(find.find(test));
        new GraphDeleteFeature(session, fileid).delete(Collections.singletonList(folder), new DisabledLoginCallback(), new Delete.DisabledCallback());
    }
}
