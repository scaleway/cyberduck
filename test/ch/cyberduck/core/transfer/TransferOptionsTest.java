package ch.cyberduck.core.transfer;

import ch.cyberduck.core.AbstractTestCase;
import ch.cyberduck.core.preferences.PreferencesFactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @version $Id$
 */
public class TransferOptionsTest extends AbstractTestCase {

    @Test
    public void testQuarantine() {
        assertEquals(PreferencesFactory.get().getBoolean("queue.download.quarantine"), new TransferOptions().quarantine);
    }
}
