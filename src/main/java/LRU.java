import java.util.*;

public class LRU extends ReplacementAlgorithm {
    private LinkedHashMap<Integer, Integer> pageMap;

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        pageMap = new LinkedHashMap<>(pageFrameCount, 0.75f, true);
    }

    @Override
    public void insert(int pageNumber) {
        if (!pageMap.containsKey(pageNumber)) {
            pageFaultCount++;
            if (pageMap.size() >= pageFrameCount) {
                Iterator<Integer> iterator = pageMap.keySet().iterator();
                iterator.next();
                iterator.remove();
            }
        } else {
            pageMap.remove(pageNumber);
        }
        pageMap.put(pageNumber, pageNumber);
    }

}
