/**
 * The ReplacementAlgorithm class is an abstract class that provides a base implementation for page replacement algorithms.
 */
public abstract class ReplacementAlgorithm {

	/**
	 * The number of page faults that occurred.
	 */
	protected int pageFaultCount;

	/**
	 * The number of physical page frames.
	 */
	protected int pageFrameCount;

	/**
	 * Constructs a ReplacementAlgorithm object with the specified number of physical page frames.
	 *
	 * @param pageFrameCount the number of physical page frames
	 * @throws IllegalArgumentException if the pageFrameCount is less than 0
	 */
	public ReplacementAlgorithm(int pageFrameCount) {
		if (pageFrameCount < 0)
			throw new IllegalArgumentException("Page frame count cannot be negative.");

		this.pageFrameCount = pageFrameCount;
		pageFaultCount = 0;
	}

	/**
	 * Returns the number of page faults that occurred.
	 *
	 * @return the number of page faults
	 */
	public int getPageFaultCount() {
		return pageFaultCount;
	}

	/**
	 * Inserts a page with the specified page number into the page replacement algorithm.
	 *
	 * @param pageNumber the page number to be inserted
	 */
	public abstract void insert(int pageNumber);
}
