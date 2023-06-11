# Page Replacement Algorithms

## All generated configurations:

The configurations are as follows:

Configuration: [rss: 10, npf: 3]
Configuration: [rss: 15, npf: 3]
Configuration: [rss: 20, npf: 3]
Configuration: [rss: 10, npf: 5]
Configuration: [rss: 15, npf: 5]
Configuration: [rss: 20, npf: 5]
Configuration: [rss: 10, npf: 7]
Configuration: [rss: 15, npf: 7]
Configuration: [rss: 20, npf: 7]

To evaluate the performance of each configuration, the number of page faults for each algorithm will be recorded and analyzed. The configuration that results in the lowest total page faults across all reference strings will be considered the best-performing configuration.

## Results:
Page Fault Counts:
FIFO: 16
LRU: 16
OPT: 13
OPT performed the best.

Configuration: [rss: 10, npf: 3]
Reference String: [2, 5, 1, 5, 7, 3, 2, 1, 4, 7]
FIFO Page Faults: 9
LRU Page Faults: 9
OPT Page Faults: 7
OPT performed the best.

Configuration: [rss: 10, npf: 5]
Reference String: [9, 8, 4, 7, 6, 0, 8, 2, 2, 6]
FIFO Page Faults: 7
LRU Page Faults: 7
OPT Page Faults: 7
FIFO, LRU, OPT performed the best.

Configuration: [rss: 10, npf: 7]
Reference String: [5, 7, 1, 5, 4, 8, 0, 5, 4, 9]
FIFO Page Faults: 7
LRU Page Faults: 7
OPT Page Faults: 7
FIFO, LRU, OPT performed the best.

Configuration: [rss: 15, npf: 3]
Reference String: [7, 9, 0, 1, 0, 9, 4, 9, 6, 8, 0, 8, 7, 3, 4]
FIFO Page Faults: 12
LRU Page Faults: 11
OPT Page Faults: 10
OPT performed the best.

Configuration: [rss: 15, npf: 5]
Reference String: [4, 0, 1, 9, 6, 5, 7, 4, 6, 2, 7, 8, 0, 4, 2]
FIFO Page Faults: 11
LRU Page Faults: 12
OPT Page Faults: 10
OPT performed the best.

Configuration: [rss: 15, npf: 7]
Reference String: [1, 1, 1, 7, 2, 5, 0, 1, 0, 1, 3, 1, 7, 7, 6]
FIFO Page Faults: 7
LRU Page Faults: 7
OPT Page Faults: 7
FIFO, LRU, OPT performed the best.

Configuration: [rss: 20, npf: 3]
Reference String: [5, 5, 0, 2, 6, 9, 3, 7, 5, 5, 1, 6, 7, 3, 1, 3, 3, 9, 3, 8]
FIFO Page Faults: 15
LRU Page Faults: 15
OPT Page Faults: 11
OPT performed the best.

Configuration: [rss: 20, npf: 5]
Reference String: [9, 3, 5, 9, 5, 9, 3, 9, 8, 3, 7, 2, 9, 8, 8, 5, 6, 1, 0, 8]
FIFO Page Faults: 11
LRU Page Faults: 10
OPT Page Faults: 9
OPT performed the best.

Configuration: [rss: 20, npf: 7]
Reference String: [0, 4, 2, 1, 5, 5, 2, 9, 2, 4, 6, 6, 3, 0, 0, 4, 5, 7, 3, 5]
FIFO Page Faults: 11
LRU Page Faults: 10
OPT Page Faults: 9
OPT performed the best.

## Evaluation:

Based on the results, it is clear that configurations with larger page frame counts (npf) have a lower number of page faults since they provide more space for pages in memory. Additionally, larger reference string sizes (rss) increase the chances of page faults due to a larger pool of references. If we consider those configurations that have the same rss, the following configurations performed the best (with the least amount of page faults) using the OPT algorithm:

Configuration: [rss: 10, npf: 7]
Configuration: [rss: 15, npf: 7]
Configuration: [rss: 20, npf: 7]

Discussion of Big O runtime for each configuration:

To analyze the Big O runtime for the configurations, we need to consider the impact of the reference string size (rss) and the number of physical page frames (npf) on the page replacement algorithms.

In the FIFO algorithm, the npf value determines the size of the queue or buffer that holds the page frames. When a page fault occurs, the algorithm removes the oldest page from the queue and replaces it with the new page. The time complexity of the FIFO algorithm is O(rss * npf), as it may need to iterate through the queue to find the oldest page to replace.

Similarly, in the LRU algorithm, the npf value determines the size of the data structure used to keep track of the least recently used pages. When a page fault occurs, the algorithm finds the least recently used page in the data structure and replaces it with the new page. The time complexity of the LRU algorithm is also O(rss * npf), as it may need to traverse the data structure to find the least recently used page.

The OPT algorithm requires knowledge of the future page references to make optimal decisions. Since it is not practical to have such knowledge in real-world scenarios, the OPT algorithm is used for comparison purposes to evaluate the performance of other algorithms. The OPT algorithm's runtime is determined by the size of the reference string and the number of physical page frames. In the worst case, where the entire reference string needs to be scanned to make a replacement decision, the time complexity of OPT is O(rss^2).

Configuration: [rss: 10, npf: 3]
FIFO & LRU runtime = O(30)
OPT run time = O(100)

Configuration: [rss: 10, npf: 5]
FIFO & LRU runtime = O(50)
OPT run time = O(100)

Configuration: [rss: 10, npf: 7]
FIFO & LRU runtime = O(70)
OPT run time = O(100)

Configuration: [rss: 15, npf: 3]
FIFO & LRU runtime = O(45)
OPT run time = O(225)

Configuration: [rss: 15, npf: 5]
FIFO & LRU runtime = O(75)
OPT run time = O(225)

Configuration: [rss: 15, npf: 7]
FIFO & LRU runtime = O(105)
OPT run time = O(225)

Configuration: [rss: 20, npf: 3]
FIFO & LRU runtime = O(60)
OPT run time = O(400)

Configuration: [rss: 20, npf: 5]
FIFO & LRU runtime = O(100)
OPT run time = O(400)

Configuration: [rss: 20, npf: 7]
FIFO & LRU runtime = O(140)
OPT run time = O(400)

We can see that although the OPT runtime is larger than the other two, its algorithm considers the whole reference string each time a page is processed, effectively reducing the number of page faults. The best-performing configurations are the ones with the largest npf because, as mentioned above, they create more space for pages in memory, thus reducing the number of page faults.
