package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Cube implements Process {
	/**
	 * @return n cube
	 */
	@Override
	public int run(int n) {
		return (int) Math.pow(n, 3);
	}
}
