package pooCbTema1.Scheduler;

import pooCbTema1.InputOutput.ProcessStructure;

public class RoundRobinScheduler implements Scheduler {
	/**
	 * @return a string array with process types obtained using round-robin
	 *         scheduling, of length numberOfNumbers
	 */
	@Override
	public String[] schedule(ProcessStructure processes[], int numbers[]) {
		int i, numberOfNumbers = numbers.length, numberOfEvents = processes.length;
		String processType[] = new String[numberOfNumbers];

		for (i = 0; i < numberOfNumbers; i++)
			processType[i] = processes[i % numberOfEvents].getType();
		// runs processes one by one over and over again

		return processType;
	}
}
