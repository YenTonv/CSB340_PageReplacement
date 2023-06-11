import java.util.*;

class OPT extends ReplacementAlgorithm {
    private List<Integer> pageList;
    private int[] referenceString;
    private int currentIndex;

    public OPT(int pageFrameCount, int[] referenceString) {
        super(pageFrameCount);
        this.pageList = new ArrayList<>();
        this.referenceString = referenceString;
        this.currentIndex = 0;
    }

    public void insert(int pageNumber) {
        if (!pageList.contains(pageNumber)) {
            pageFaultCount++;
            if (pageList.size() < pageFrameCount) {
                pageList.add(pageNumber);
            } else {
                int pageToRemove = getOptimalPage(pageNumber);
                int index = pageList.indexOf(pageToRemove);
                pageList.set(index, pageNumber);
            }
        }
        currentIndex++;
    }

    private int getOptimalPage(int pageNumber) {
        int indexToRemove = -1;
        int farthestDistance = -1;

        for (int i = 0; i < pageList.size(); i++) {
            int currentPage = pageList.get(i);
            if (!isPageInFuture(pageNumber, currentIndex, currentPage)) {
                return currentPage;
            }
            int distance = getDistanceToNextOccurrence(pageNumber, currentIndex);
            if (distance > farthestDistance) {
                farthestDistance = distance;
                indexToRemove = i;
            }
        }

        return pageList.get(indexToRemove);
    }

    private boolean isPageInFuture(int pageNumber, int currentIndex, int currentPage) {
        for (int i = currentIndex + 1; i < referenceString.length; i++) {
            if (referenceString[i] == currentPage) {
                return true;
            }
            if (referenceString[i] == pageNumber) {
                return false;
            }
        }
        return false;
    }

    private int getDistanceToNextOccurrence(int pageNumber, int currentIndex) {
        int distance = 0;
        for (int i = currentIndex + 1; i < referenceString.length; i++) {
            distance++;
            if (referenceString[i] == pageNumber) {
                return distance;
            }
        }
        return Integer.MAX_VALUE;
    }
}
