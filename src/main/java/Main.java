import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**
     * The main method of the program.
     */
    public static void main(String[] args) {
        int pageFrameCount = 3;

        PageGenerator pageGenerator = new PageGenerator();
        int[] referenceString = pageGenerator.getReferenceString();

        FIFO fifo = new FIFO(pageFrameCount);
        LRU lru = new LRU(pageFrameCount);
        OPT opt = new OPT(pageFrameCount, referenceString);

        processReferenceString(referenceString, fifo, lru, opt);

        int fifoPageFaultCount = fifo.getPageFaultCount();
        int lruPageFaultCount = lru.getPageFaultCount();
        int optPageFaultCount = opt.getPageFaultCount();

        System.out.println("Page Fault Counts:");
        System.out.println("FIFO: " + fifoPageFaultCount);
        System.out.println("LRU: " + lruPageFaultCount);
        System.out.println("OPT: " + optPageFaultCount);

        String bestAlgorithm = determineBestAlgorithm(fifoPageFaultCount, lruPageFaultCount, optPageFaultCount);
        System.out.println(bestAlgorithm + " performed the best.");
        System.out.println();

        // Generate random reference strings
        int[] rssSizes = {10, 15, 20};
        int[] npfs = {3, 5, 7};

        List<int[]> configurations = generateConfigurations(rssSizes, npfs);

        for (int[] configuration : configurations) {
            int rssSize = configuration[0];
            int npf = configuration[1];

            PageGenerator randomPageGenerator = new PageGenerator();
            int[] randomReferenceString = randomPageGenerator.generateRandomReferenceString(rssSize);

            FIFO randomFifo = new FIFO(npf);
            LRU randomLru = new LRU(npf);
            OPT randomOpt = new OPT(npf, randomReferenceString);

            processReferenceString(randomReferenceString, randomFifo, randomLru, randomOpt);

            int randomFifoPageFaultCount = randomFifo.getPageFaultCount();
            int randomLruPageFaultCount = randomLru.getPageFaultCount();
            int randomOptPageFaultCount = randomOpt.getPageFaultCount();

            System.out.println("Configuration: [rss: " + rssSize + ", npf: " + npf + "]");
            System.out.println("Reference String: " + Arrays.toString(randomReferenceString));
            System.out.println("FIFO Page Faults: " + randomFifoPageFaultCount);
            System.out.println("LRU Page Faults: " + randomLruPageFaultCount);
            System.out.println("OPT Page Faults: " + randomOptPageFaultCount);

            String randomBestAlgorithm = determineBestAlgorithm(randomFifoPageFaultCount, randomLruPageFaultCount, randomOptPageFaultCount);
            System.out.println(randomBestAlgorithm + " performed the best.");
            System.out.println();
        }
    }

    /**
     * Processes the reference string using the specified replacement algorithms.
     *
     * @param referenceString The reference string to be processed.
     * @param algorithms      The replacement algorithms to be used.
     */
    private static void processReferenceString(int[] referenceString, ReplacementAlgorithm... algorithms) {
        for (int pageNumber : referenceString) {
            for (ReplacementAlgorithm algorithm : algorithms) {
                algorithm.insert(pageNumber);
            }
        }
    }

    /**
     * Determines the best algorithm based on the page fault counts.
     * If two or more algorithms have the same minimum page fault count, they are listed together.
     *
     * @param fifoPageFaultCount The page fault count for the FIFO algorithm.
     * @param lruPageFaultCount  The page fault count for the LRU algorithm.
     * @param optPageFaultCount  The page fault count for the OPT algorithm.
     * @return The best algorithm(s) as a string.
     */
    private static String determineBestAlgorithm(int fifoPageFaultCount, int lruPageFaultCount, int optPageFaultCount) {
        int minPageFaultCount = Math.min(fifoPageFaultCount, Math.min(lruPageFaultCount, optPageFaultCount));
        StringBuilder resultBuilder = new StringBuilder();

        if (minPageFaultCount == fifoPageFaultCount) {
            resultBuilder.append("FIFO");
        }
        if (minPageFaultCount == lruPageFaultCount) {
            if (resultBuilder.length() > 0) {
                resultBuilder.append(", ");
            }
            resultBuilder.append("LRU");
        }
        if (minPageFaultCount == optPageFaultCount) {
            if (resultBuilder.length() > 0) {
                resultBuilder.append(", ");
            }
            resultBuilder.append("OPT");
        }

        return resultBuilder.toString();
    }

    /**
     * Generates configurations based on the given RSS sizes and NPF values.
     *
     * @param rssSizes The array of RSS sizes.
     * @param npfs     The array of NPF values.
     * @return A list of configurations.
     */
    private static List<int[]> generateConfigurations(int[] rssSizes, int[] npfs) {
        List<int[]> configurations = new ArrayList<>();
        for (int rssSize : rssSizes) {
            for (int npf : npfs) {
                int[] configuration = {rssSize, npf};
                configurations.add(configuration);
            }
        }
        return configurations;
    }
}
