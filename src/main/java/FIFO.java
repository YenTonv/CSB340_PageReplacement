import java.util.*;

class FIFO extends ReplacementAlgorithm {
    private Queue<Integer> pageQueue;
    private Set<Integer> pageSet;

    public FIFO(int pageFrameCount) {
        super(pageFrameCount);
        this.pageQueue = new LinkedList<>();
        this.pageSet = new HashSet<>();
    }

    public void insert(int pageNumber) {
        if (!pageSet.contains(pageNumber)) {
            pageFaultCount++;
            if (pageQueue.size() == pageFrameCount) {
                int removedPage = pageQueue.poll();
                pageSet.remove(removedPage);
            }
            pageQueue.offer(pageNumber);
            pageSet.add(pageNumber);
        }
    }
}