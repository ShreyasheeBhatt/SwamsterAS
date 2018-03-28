import java.util.*; 

public class Race 
{
	private String event;
	private int heat;
	private int lane;
	private double time;
	
	public Race(String eventName, int heatNum, int laneNum, double timeSwam)
	{
		event = eventName;
		heat = heatNum;
		lane = laneNum; 
		time = timeSwam;
	}
	
	/**
	 * Gets the event of the race. 
	 * @return event name
	 */
	public String getEvent() 
	{
		return event;
	}
	
	/**
	 * Gets the heat number of the race. 
	 * @return heat number
	 */
	public int getHeat()
	{
		return heat; 
	}
	
	/**
	 * Gets the lane number of the race. 
	 * @return lane number
	 */
	public int getLane()
	{
		return lane;
	}
	
	/**
	 * Gets the time it took to swim the race. 
	 * @return time 
	 */
	public double getTime()
	{
		return time;
	}
	
	/**
	 * Changes the final swim time. 
	 * @param timeSwam the time it took to swim the race
	 * @return time 
	 */
	public double changeTime(double timeSwam)
	{
		time = timeSwam;
		return time;
	}
	
	/**
	 * Converts Race object to a string.
	 */
	@Override
	public String toString() {
		return ("\nEvent: " + event + "\n\tHeat: " + heat + "\n\tLane: " + lane + "\n\tTime: " + time);
	}
}
