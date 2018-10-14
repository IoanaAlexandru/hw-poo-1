package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Square implements Process {
	/**
	 * @return n square
	 */
	@Override
	public int run(int n) {
		return (int) Math.pow(n, 2);
	}
}
