import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BlockTest {
    @Test
    public void testCalculateHash() {
        Block b = new Block("0", "0", true);
        String expected = "44b833e20aaa0e9d16b466a56d74765722d243adcb577a78f0395d2a5483d743";

        String actual = b.calculateHash();

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testGetHash() {
        Block b = new Block("0", "0", true);
        String expected = "e90424a4c79eb29c422a094e22751cdf6dfddb92968db67706b46ecb15336cc3";
        String actual = b.getHash();

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testGetPreviousHash() {
        Block b = new Block("0", "0", true);
        String expected = "0";
        String actual = b.getPreviousHash();

        assertTrue(actual.equals(expected));
    }

    @Test
    public void testMine() {
        Block b = new Block("0", "0", true);
        String expected = "0ee07757db65a053158eb7d94850dacd53d7bbcdd2461277c0d7d2db3667bb71";
        String actual = b.mine(1);

        assertTrue(actual.equals(expected));
    }
    @Test
    public void testMine2() {
        Block b = new Block("0", "0", true);
        String expected = "00f95b0490e6ad7af11ddafdeb929f1385243b127e6ac1ba41968678d2a67044";
        String actual = b.mine(2);

        assertTrue(actual.equals(expected));
    }

    // this test takes a long time.
    @Test
    public void testMine3() {
        Block b = new Block("0", "0", true);
        String expected = "0004e51db759d33a73da27eba4fa3d182eb8053ed1cbe027ad3ae77f5a6df7df";
        String actual = b.mine(3);

        assertTrue(actual.equals(expected));
    }

}
