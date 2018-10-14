package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Sqrt implements Process {
	/**
	 * @return the square root of |n|
	 */
	@Override
	public int run(int n) {
		return (int) Math.sqrt(Math.abs(n));
	}
}
