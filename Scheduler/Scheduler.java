package pooCbTema1.Scheduler;

import pooCbTema1.InputOutput.ProcessStructure;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public interface Scheduler {
	public String[] schedule(ProcessStructure processes[], int numbers[]);

	/**
	 * @param type
	 * @return an instance of a scheduler of type "type"
	 */
	public static Scheduler initialise(String type) {
		if (type.equals("RandomScheduler"))
			return new RandomScheduler();
		else if (type.equals("RoundRobinScheduler"))
			return new RoundRobinScheduler();
		else if (type.equals("WeightedScheduler"))
			return new WeightedScheduler();
		else
			return null;
	}
}
