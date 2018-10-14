package pooCbTema1;

import pooCbTema1.Cache.*;
import pooCbTema1.Process.Process;
import pooCbTema1.Scheduler.*;
import pooCbTema1.InputOutput.ProblemData;

/**
 * 
 * @author Ioana Alexandru 324CB
 *
 */
public class OS {
	/**
	 * @return result to be written in the output file, according to the
	 *         SchedulerType and CacheType in ProblemData
	 */
	public static String[] compute(ProblemData data) {
		Scheduler s = Scheduler.initialise(data.getSchedulerType());
		String[] processType = s.schedule(data.getProcesses(), data.getNumbersToBeProcessed());
		Process p;
		int i, numberOfNumbers = data.getNumbersToBeProcessed().length;
		String result[] = new String[numberOfNumbers], obtained;
		
		// creates cache (will be NULL if NoCache)
		Cache cache = Cache.initialise(data.getCacheType(), data.getCacheCapacity());

		for (i = 0; i < numberOfNumbers; i++) {
			obtained = "Computed";

			if (!data.getCacheType().equals("NoCache")) {
				// searches in cache
				result[i] = Integer.toString(cache.search(data.getNumbersToBeProcessed()[i], processType[i]));

				if (!result[i].equals("-2")) { // found in cache
					obtained = "FromCache";
				} else { // not found in cache
					p = Process.initialise(processType[i]);
					result[i] = Integer.toString(p.run(data.getNumbersToBeProcessed()[i]));
					// adds computed result in cache
					cache.add(data.getNumbersToBeProcessed()[i], processType[i], Integer.parseInt(result[i]));
				}
			} else {
				p = Process.initialise(processType[i]);
				result[i] = Integer.toString(p.run(data.getNumbersToBeProcessed()[i]));
			}

			result[i] = Integer.toString(data.getNumbersToBeProcessed()[i]) + " " + processType[i] + " " + result[i]
					+ " " + obtained;
		}

		return result;
	}
}
