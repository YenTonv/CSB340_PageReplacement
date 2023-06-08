import java.util.*;

class LRU extends ReplacementAlgorithm {
    private LinkedHashMap<Integer, Integer> pageMap;

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        this.pageMap = new LinkedHashMap<>();
    }

    public void insert(int pageNumber) {
        if (pageMap.containsKey(pageNumber)) {
            int count = pageMap.remove(pageNumber);
            pageMap.put(pageNumber, count);
        } else {
            pageFaultCount++;
            if (pageMap.size() == pageFrameCount) {
                int removedPage = pageMap.keySet().iterator().next();
                pageMap.remove(removedPage);
            }
            pageMap.put(pageNumber, pageFaultCount);
        }
    }
}