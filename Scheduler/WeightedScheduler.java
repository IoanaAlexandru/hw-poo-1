package pooCbTema1.Scheduler;

import pooCbTema1.InputOutput.ProcessStructure;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class WeightedScheduler implements Scheduler {
	/**
	 * @return the smallest process weight
	 */
	private int minimum(ProcessStructure processes[]) {
		int i, min = processes[0].getWeight(), numberOfEvents = processes.length;

		for (i = 0; i < numberOfEvents; i++)
			if (processes[i].getWeight() < min)
				min = processes[i].getWeight();

		return min;
	}

	/**
	 * @return the greatest common divisor of the process weights
	 */
	private int greatestCommonDivisor(ProcessStructure processes[]) {
		int GCD = minimum(processes) + 1, i, numberOfEvents = processes.length;
		// the maximum possible value of the GCD is the smallest number
		boolean ok; // true if the greatest common divisor was found, false otherwise

		do {
			GCD--;
			ok = true;
			for (i = 0; i < numberOfEvents; i++)
				if (processes[i].getWeight() % GCD != 0) {
					ok = false;
					break;
				}
		} while (!ok);

		return GCD;
	}

	/**
	 * @return a string array with process types obtained using weighted scheduling,
	 *         of length numberOfNumbers
	 */
	@Override
	public String[] schedule(ProcessStructure processes[], int numbers[]) {
		int numberOfNumbers = numbers.length, numberOfEvents = processes.length;
		int i, j, k, weight[] = new int[numberOfEvents], GCD = greatestCommonDivisor(processes);
		String processType[] = new String[numberOfNumbers];

		for (i = 0; i < numberOfEvents; i++)
			weight[i] = processes[i].getWeight() / GCD;
		// the weight array represents how many times in a row a process should be ran
		// so that for every time that is a multiple of t = sum(weights) / gcd(weights),
		// the admin-defined weights are respected

		i = 0;
		while (i < numberOfNumbers)
			for (j = 0; j < numberOfEvents; j++)
				for (k = 0; k < weight[j] && i < numberOfNumbers; k++, i++)
					processType[i] = processes[j].getType();

		return processType;
	}
}
