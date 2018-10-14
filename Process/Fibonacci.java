package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Fibonacci implements Process {
	/**
	 * @return the nth Fibonacci number modulo 9973
	 */
	@Override
	public int run(int n) {
		if (n < 0)
			return -1;

		if (n == 0 || n == 1)
			return n;

		int f1 = 0, f2 = 1, f3 = 1, i;
		
		for (i = 2; i <= n; i++) {
			f3 = (f1 + f2) % 9973;
			f1 = f2;
			f2 = f3;
		}

		return f3;
	}
}
