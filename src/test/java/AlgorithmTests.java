import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlgorithmTests {
    int pageFrameCount = 3;
    int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};

    @Test
    void testFIFOAlgorithm() {
        FIFO fifo = new FIFO(pageFrameCount);

        for (int pageNumber : referenceString) {
            fifo.insert(pageNumber);
        }

        int expectedPageFaults = 15;
        int actualPageFaults = fifo.getPageFaultCount();
        Assertions.assertEquals(expectedPageFaults, actualPageFaults);
    }

    @Test
    void testLRUAlgorithm() {
        LRU lru = new LRU(pageFrameCount);

        for (int pageNumber : referenceString) {
            lru.insert(pageNumber);
        }

        int expectedPageFaults = 12;
        int actualPageFaults = lru.getPageFaultCount();
        Assertions.assertEquals(expectedPageFaults, actualPageFaults);
    }

    @Test
    void testOPTAlgorithm() {
        OPT opt = new OPT(pageFrameCount, referenceString);

        for (int pageNumber : referenceString) {
            opt.insert(pageNumber);
        }

        int expectedPageFaults = 9;
        int actualPageFaults = opt.getPageFaultCount();
        Assertions.assertEquals(expectedPageFaults, actualPageFaults);
    }
}
