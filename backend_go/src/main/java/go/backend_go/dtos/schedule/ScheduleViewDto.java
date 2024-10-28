package go.backend_go.dtos.schedule;

import go.backend_go.entity.Plan;
import go.backend_go.entity.Schedule;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleViewDto {

    private String placeName;
    private String planName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ScheduleViewDto(Schedule schedule) {
        this.placeName = schedule.getPlace().getPlaceName();
        this.planName = schedule.getName();
        this.startDate = schedule.getStartDate();
        this.endDate = schedule.getEndDate();
    }
}
