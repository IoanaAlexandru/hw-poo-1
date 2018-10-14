package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class CheckPrime implements Process {
	/**
	 * @return 1 if n is prime, 0 otherwise
	 */
	@Override
	public int run(int n) {
		if (n < 2)
			return 0;

		int i;
		
		for (i = 2; i <= n / 2; i++)
			if (n % i == 0)
				return 0;
		return 1;
	}
}
