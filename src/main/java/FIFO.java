import java.util.*;

public class FIFO extends ReplacementAlgorithm {
    private Queue<Integer> pageQueue;

    public FIFO(int pageFrameCount) {
        super(pageFrameCount);
        pageQueue = new LinkedList<>();
    }

    @Override
    public void insert(int pageNumber) {
        if (!pageQueue.contains(pageNumber)) {
            pageFaultCount++;
            if (pageQueue.size() >= pageFrameCount) {
                int removedPage = pageQueue.poll();
                System.out.println("Page " + removedPage + " removed from the page frame.");
            }
            pageQueue.offer(pageNumber);
            System.out.println("Page " + pageNumber + " inserted into the page frame.");
        }
    }

}

