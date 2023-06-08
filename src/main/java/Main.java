import java.util.*;

public class Main {
    public static void main(String[] args) {
        int pageFrameCount = 3;
        FIFO fifoAlgorithm = new FIFO(pageFrameCount);
        LRU lruAlgorithm = new LRU(pageFrameCount);
        OPT optAlgorithm = new OPT(pageFrameCount);

        PageGenerator pageGenerator = new PageGenerator();
        int[] referenceString = pageGenerator.getReferenceString();

        for (int pageNumber : referenceString) {
            fifoAlgorithm.insert(pageNumber);
            lruAlgorithm.insert(pageNumber);
            optAlgorithm.insert(pageNumber);
        }


        System.out.println("FIFO: Total page faults: " + fifoAlgorithm.getPageFaultCount());
        System.out.println("Total page faults: " + lruAlgorithm.getPageFaultCount());
        System.out.println("Total page faults: " + optAlgorithm.getPageFaultCount());

    }
}