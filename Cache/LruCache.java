package pooCbTema1.Cache;

public class LruCache extends Cache {
	int time[];
	int currentTime;

	public LruCache(int maxSize) {
		super(maxSize);
		time = new int[maxSize];
		currentTime = 0;
	}

	/**
	 * @return index of least recently used cache entry.
	 */
	@Override
	public int leastUsed() {
		return super.min(time);
	}

	@Override
	public void add(int number, String process, int result) {
		if (currentSize < maxSize) {
			setCache(currentSize, number, process, result);
			time[currentSize] = ++currentTime;
			currentSize++;
		} else {
			int leastUsed = leastUsed();
			currentTime++;
			setCache(leastUsed, number, process, result);
			time[leastUsed] = currentTime;
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
			currentTime++;
			time[i] = currentTime;
			return results[i];
		}
	}
}
