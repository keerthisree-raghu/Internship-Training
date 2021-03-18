package assignments.Consignment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsignmentDetails implements Serializable {
	private String origin;
	private String destination;
	private LocalDate shipmentDate;
	private LocalTime startTime;
	private double distance;
	private double speed;
	private int breaks;
	private int breakDuration;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getBreaks() {
		return breaks;
	}

	public void setBreaks(int breaks) {
		this.breaks = breaks;
	}

	public int getBreakDuration() {
		return breakDuration;
	}

	public void setBreakDuration(int breakDuration) {
		this.breakDuration = breakDuration;
	}

	@Override
	public String toString() {
		return "ConsignmentDetails [origin=" + origin + ", destination=" + destination + ", shipmentDate="
				+ shipmentDate + ", startTime=" + startTime + ", distance=" + distance + ", speed=" + speed
				+ ", breaks=" + breaks + ", breakDuration=" + breakDuration + "]";
	}
}
