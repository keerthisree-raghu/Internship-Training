package assignments.Consignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface TrackParcel {
	
	public boolean checkWeekend(LocalDate date);

	public String calculateArrivalDate(ConsignmentDetails details);
}
