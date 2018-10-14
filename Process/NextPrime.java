package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class NextPrime implements Process {
	/**
	 * @return the smallest prime number greater than n
	 */
	@Override
	public int run(int n) {
		Process p = new CheckPrime();

		if (n < 2)
			return 2;

		while (true) {
			n++;
			if (p.run(n) == 1)
				return n;
		}
	}
}
