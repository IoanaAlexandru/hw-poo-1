package pooCbTema1.Cache;

public class LfuCache extends Cache {
	int timesUsed[];

	public LfuCache(int maxSize) {
		super(maxSize);
		timesUsed = new int[maxSize];
	}

	/**
	 * @return index of least frequently used cache entry.
	 */
	@Override
	public int leastUsed() {
		return super.min(timesUsed);
	}

	@Override
	public void add(int number, String process, int result) {
		if (currentSize < maxSize) {
			setCache(currentSize, number, process, result);
			currentSize++;
		} else {
			setCache(leastUsed(), number, process, result);
		}
	}

	/**
	 * @return previously computed result, or -2 if it is not in cache
	 */
	@Override
	public int search(int number, String process) {
		int i = super.search(number, process);
		if (i < 0)
			return -2;
		else {
			timesUsed[i]++;
			return results[i];
		}
	}
}
