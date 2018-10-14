package pooCbTema1.Cache;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public abstract class Cache {
	int maxSize;
	int currentSize;
	int numbersProcessed[];
	String processes[];
	int results[];

	public Cache(int maxSize) {
		this.maxSize = maxSize;
		numbersProcessed = new int[maxSize];
		processes = new String[maxSize];
		results = new int[maxSize];
		currentSize = 0;
	}

	/**
	 * Sets the data on line [index] of the cache.
	 * 
	 * @param index
	 * @param number
	 * @param process
	 * @param result
	 */
	public void setCache(int index, int number, String process, int result) {
		numbersProcessed[index] = number;
		processes[index] = process;
		results[index] = result;
	}

	public int leastUsed() {
		return 0;
	}

	/**
	 * Adds a new entry in the cache.
	 * 
	 * @param number
	 * @param process
	 * @param result
	 */
	public void add(int number, String process, int result) {
	}

	/**
	 * Searches for an entry in the cache.
	 * 
	 * @param number
	 * @param process
	 * @return index of cache entry, or -1 if it is not in the cache
	 */
	public int search(int number, String process) {
		int i;
		for (i = 0; i < currentSize; i++) {
			if (number == numbersProcessed[i] && process.equals(processes[i]))
				return i;
		}

		return -1;
	}

	/**
	 * @param array
	 * @return index of smallest element in the array
	 */
	protected int min(int array[]) {
		int i, iMin = 0;

		for (i = 0; i < currentSize; i++)
			if (array[i] < array[iMin])
				iMin = i;

		return iMin;
	}

	/**
	 * @param type
	 * @param capacity
	 * @return a cache instance of type "type"
	 */
	public static Cache initialise(String type, int capacity) {
		if (type.equals("LruCache"))
			return new LruCache(capacity);
		else if (type.equals("LfuCache"))
			return new LfuCache(capacity);
		else
			return null;
	}
}
