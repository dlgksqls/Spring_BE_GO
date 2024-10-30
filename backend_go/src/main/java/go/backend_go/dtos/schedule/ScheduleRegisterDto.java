package go.backend_go.dtos.schedule;

import go.backend_go.entity.Place;
import go.backend_go.entity.Plan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleRegisterDto {
    
    private String name;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Place place;

    private Plan plan;
}
