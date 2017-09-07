package sort;

/**
 * Job class implements Comparable interface. The job ADT has two variables, jobID and time with their respective setters and getters. Compares jobs based on time.
 * @author Bishoy Sefin
 * @version 1.0
 */
public class Job implements Comparable<Job>{
	private String jobID;
	private int processingTime;
	private int arrivalTime;
	

	/**
	 * Constructor for a job object, a string,  and 2 integers are expected as parameters, which are assigned as the job's ID, execution time and arrival time , respectively.
	 * @param id - Job's ID
	 * @param pTime - Job's execution time
	 * @param aTime - Job's arrival time
	 */
	public Job(String id, int pTime, int aTime)
	{
		//TODO
		this.jobID = id;
		this.processingTime = pTime;
		this.arrivalTime = aTime;
	}
	
	/**
	 * Getter; gets execution time of job.
	 * @return Execution time is an integer.
	 */
	public int getProcessingTime()
	{
		//TODO
		return this.processingTime;
	}
	
	/**
	 * Setter: sets execution time of job
	 * @param t Execution time is an integer.
	 */
	public void setProcessingTime(int t)
	{
		//TODO
		this.processingTime = t;
	}
	
	/**
	 * Getter; gets arrival time of job.
	 * @return Arrival time is an integer.
	 */
	public int getArrivalTime()
	{
		//TODO
		return this.arrivalTime;
	}
	
	/**
	 * Setter: sets arrival time of job
	 * @param t arrival time is an integer.
	 */
	public void setArrivalTime(int t)
	{
		//TODO
		this.arrivalTime = t;
	}
	
	/**
	 * Getter; gets the ID of job.
	 * @return ID is a string.
	 */
	public String getJobID()
	{
		//TODO
		return this.jobID;
	}
	
	/**
	 * Setter; sets the ID of job.
	 * @param id is a string.
	 */
	public void setJobID(String id)
	{
		//TODO
		this.jobID = id;
	}
	
	@Override
	public int compareTo(Job other)
	{
		//TODO
		if (this.getArrivalTime() == other.getArrivalTime()){
			if (this.getProcessingTime() > other.getProcessingTime())
				return -1;
			else if (this.getProcessingTime() < other.getProcessingTime())
				return 1;
			else
				return 0;
		}
		else if(this.getArrivalTime() > other.getArrivalTime()){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	
	public String toString()
	{
		//TODO
		String x = "{" + this.getJobID() +","+this.getProcessingTime()+","+this.getArrivalTime()+"}";
		return x;
	}

}
