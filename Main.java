package pooCbTema1;

import pooCbTema1.InputOutput.*;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class Main {

	public static void main(String[] args) {
		HomeworkReader reader = new HomeworkReader(args[0]);
		HomeworkWriter writer = new HomeworkWriter(args[1]);
		ProblemData data = reader.readData();
		String result[] = OS.compute(data);

		int numberOfNumbers = result.length, i;
		for (i = 0; i < numberOfNumbers; i++)
			writer.println(result[i]);

		reader.close();
		writer.close();
	}

}
