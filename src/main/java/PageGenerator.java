import java.util.*;

/**
 * The PageGenerator class provides methods for generating reference strings.
 */
public class PageGenerator {

	/**
	 * Returns a pre-defined reference string.
	 *
	 * @return the pre-defined reference string
	 */
	public int[] getReferenceString() {
		int[] rStr1 = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		int[] fStr2 = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
		int[] rStr3 = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};
		return rStr3;
	}

	/**
	 * Generates a random reference string of the specified size.
	 *
	 * @param rssSize the size of the reference string
	 * @return the randomly generated reference string
	 */
	public int[] generateRandomReferenceString(int rssSize) {
		Random random = new Random();
		int[] referenceString = new int[rssSize];
		for (int i = 0; i < rssSize; i++) {
			referenceString[i] = random.nextInt(10);
		}
		return referenceString;
	}
}
