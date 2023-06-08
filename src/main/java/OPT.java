import java.util.ArrayList;
import java.util.List;

public class OPT extends ReplacementAlgorithm{
    private List<Integer> pageList;
    private int pageFaultCount;

    public OPT(int pageFrameCount) {
        super(pageFrameCount);
        pageList = new ArrayList<>(pageFrameCount);
        this.pageFaultCount = 0;
    }

    public void insert(int[] pageReferenceString) {
        for (int pageNumber : pageReferenceString) {
            if (!pageList.contains(pageNumber)) {
                pageFaultCount++;
                if (pageList.size() >= pageList.size()) {
                    int index = findOptimalIndex(pageNumber, pageReferenceString);
                    pageList.set(index, pageNumber);
                } else {
                    pageList.add(pageNumber);
                }
            }
        }
    }

    public int getPageFaultCount() {
        return pageFaultCount;
    }

    @Override
    public void insert(int pageNumber) {

    }

    private int findOptimalIndex(int pageNumber, int[] pageReferenceString) {
        int index = -1;
        int farthestPage = Integer.MIN_VALUE;
        for (int i = 0; i < pageList.size(); i++) {
            int currentPage = pageList.get(i);
            if (!isPageExist(pageNumber, i, pageReferenceString)) {
                return i;
            }
            int nextPageIndex = findNextAppearanceIndex(pageNumber, i, pageReferenceString);
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

    private boolean isPageExist(int pageNumber, int currentIndex, int[] pageReferenceString) {
        for (int i = currentIndex + 1; i < pageReferenceString.length; i++) {
            if (pageReferenceString[i] == pageNumber) {
                return true;
            }
        }
        return false;
    }

    private int findNextAppearanceIndex(int pageNumber, int currentIndex, int[] pageReferenceString) {
        for (int i = currentIndex + 1; i < pageReferenceString.length; i++) {
            if (pageReferenceString[i] == pageNumber) {
                return i;
            }
        }
        return -1;
    }
}
