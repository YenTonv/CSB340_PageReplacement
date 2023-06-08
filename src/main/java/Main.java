import java.util.*;

public class Main {
    public static void main(String[] args) {
        int pageFrameCount = 3;

        PageGenerator pageGenerator = new PageGenerator();
        int[] referenceString = pageGenerator.getReferenceString();

        FIFO fifo = new FIFO(pageFrameCount);
        LRU lru = new LRU(pageFrameCount);
        OPT opt = new OPT(pageFrameCount);

        for (int pageNumber : referenceString) {
            fifo.insert(pageNumber);
            lru.insert(pageNumber);
            opt.insert(pageNumber);
        }

        int fifoPageFaultCount = fifo.getPageFaultCount();
        int lruPageFaultCount = lru.getPageFaultCount();
        int optPageFaultCount = opt.getPageFaultCount();

        System.out.println("Page Fault Counts:");
        System.out.println("FIFO: " + fifoPageFaultCount);
        System.out.println("LRU: " + lruPageFaultCount);
        System.out.println("OPT: " + optPageFaultCount);

        if (fifoPageFaultCount <= lruPageFaultCount && fifoPageFaultCount <= optPageFaultCount) {
            System.out.println("FIFO performed the best.");
        } else if (lruPageFaultCount <= fifoPageFaultCount && lruPageFaultCount <= optPageFaultCount) {
            System.out.println("LRU performed the best.");
        } else {
            System.out.println("OPT performed the best.");
        }
    }
}