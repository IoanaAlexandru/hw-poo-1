package pooCbTema1.Process;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public interface Process {
	public int run(int n);

	/**
	 * @param n
	 * @param type
	 * @return an instance of a process of type "type"
	 */
	public static Process initialise(String type) {
		if (type.equals("CheckPrime"))
			return new CheckPrime();
		if (type.equals("NextPrime"))
			return new NextPrime();
		if (type.equals("Fibonacci"))
			return new Fibonacci();
		if (type.equals("Sqrt"))
			return new Sqrt();
		if (type.equals("Square"))
			return new Square();
		if (type.equals("Cube"))
			return new Cube();
		if (type.equals("Factorial"))
			return new Factorial();
		return null;
	}
}
