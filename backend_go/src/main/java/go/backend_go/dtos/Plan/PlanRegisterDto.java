package go.backend_go.dtos.Plan;

import go.backend_go.entity.Member;
import go.backend_go.entity.Plan;
import go.backend_go.entity.Schedule;
import lombok.Data;
import java.util.List;

@Data
public class PlanRegisterDto {

    private String planName;
    private Member member;
    private List<Schedule> schedules;

    public PlanRegisterDto(String planName, Member member, List<Schedule> schedules) {
        this.planName = planName;
        this.member = member;
        this.schedules = schedules;
    }
}
