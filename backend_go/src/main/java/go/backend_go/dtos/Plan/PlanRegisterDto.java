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

    public PlanRegisterDto(Plan plan) {
        this.planName = plan.getPlanName();
        this.member = plan.getMember();
        this.schedules = plan.getSchedules();
    }
}
