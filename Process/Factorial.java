package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Factorial implements Process {
	/**
	 * @return n! modulo 9973
	 */
	@Override
	public int run(int n) {
		if (n < 0)
			return 0;

		if (n == 0)
			return 1;

		int f = 1, i;
		
		for (i = 2; i <= n; i++)
			f = (f * i) % 9973;

		return f;
	}
}
