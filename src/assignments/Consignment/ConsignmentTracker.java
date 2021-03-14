package assignments.Consignment;

import java.time.LocalDateTime;

public class ConsignmentTracker {
	public LocalDateTime currentDateTime, startDateTime, endDateTime;
	int distance, speed, totalTime, breakTime;
	String origin, destination;
	
	public ConsignmentTracker(String origin, String destination, LocalDateTime startDateTime, int distance, int speed, int breakTime) {
		this.startDateTime = startDateTime;
		this.distance = distance;
		this.origin = origin;
		this.destination = destination;
		this.speed = speed;
		this.breakTime = breakTime;
	}
	
	public LocalDateTime calculateArrival(int distance, int speed, int breakTime) {
		int time = distance * speed;
		endDateTime = startDateTime.plusHours(time + breakTime);
		return this.endDateTime;
	}
	
	// TODO: calculate weekend and 24 hour cycle
}

