package go.backend_go.dtos.Plan;

import go.backend_go.entity.Member;
import go.backend_go.entity.Plan;
import go.backend_go.entity.Schedule;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanViewDto {

    private String planName;
    private String member;
    private List<PlanDto> plans;
    private List<Schedule> schedules;

    public PlanViewDto(Plan plan) {

        PlanDto userPlan = new PlanDto();

        this.planName = plan.getPlanName();
        this.member = plan.getMember().getUsername();
        this.plans = userPlan.viewAllPlans(plan.getMember());
        this.schedules = plan.getSchedules();
    }
}
