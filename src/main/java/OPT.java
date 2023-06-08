import java.util.*;

class OPT extends ReplacementAlgorithm {
    private List<Integer> pageList;

    public OPT(int pageFrameCount) {
        super(pageFrameCount);
        this.pageList = new ArrayList<>(pageFrameCount);
    }

    public void insert(int pageNumber) {
        if (!pageList.contains(pageNumber)) {
            pageFaultCount++;
            if (pageList.size() >= pageFrameCount) {
                int index = findOptimalIndex(pageList);
                pageList.set(index, pageNumber);
            } else {
                pageList.add(pageNumber);
            }
        }
    }

    private int findOptimalIndex(List<Integer> pageList) {
        int index = -1;
        int farthestPage = Integer.MIN_VALUE;
        for (int i = 0; i < pageList.size(); i++) {
            int currentPage = pageList.get(i);
            int nextPageIndex = findNextAppearanceIndex(currentPage);
            if (nextPageIndex == -1) {
                return i;
            }
            if (nextPageIndex > farthestPage) {
                farthestPage = nextPageIndex;
                index = i;
            }
        }
        return index;
    }

    private int findNextAppearanceIndex(int pageNumber) {
        for (int i = pageFaultCount; i < pageList.size(); i++) {
            if (pageList.get(i) == pageNumber) {
                return i;
            }
        }
        return -1;
    }
}