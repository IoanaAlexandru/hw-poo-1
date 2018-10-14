package pooCbTema1.Scheduler;

import java.util.Random;

import pooCbTema1.InputOutput.ProcessStructure;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class RandomScheduler implements Scheduler {
	/**
	 * @return a random string array with process types, of length numberOfNumbers
	 */
	@Override
	public String[] schedule(ProcessStructure processes[], int numbers[]) {
		Random r = new Random();
		int i, numberOfNumbers = numbers.length, numberOfEvents = processes.length;
		String processType[] = new String[numberOfNumbers];

		for (i = 0; i < numberOfNumbers; i++)
			processType[i] = processes[r.nextInt(numberOfEvents)].getType();

		return processType;
	}
}
