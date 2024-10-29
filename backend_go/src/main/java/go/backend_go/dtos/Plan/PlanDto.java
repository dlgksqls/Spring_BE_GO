package go.backend_go.dtos.Plan;

import go.backend_go.entity.Member;
import go.backend_go.entity.Plan;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlanDto {

    String planName;

    public PlanDto(String planName) {
        this.planName = planName;
    }

    public PlanDto(){

    }

    public List<PlanDto> viewAllPlans(Member member){

        List<PlanDto> returnDto = new ArrayList<>();
        for (Plan plan : member.getMember_plan()) {
            PlanDto dto = new PlanDto(plan.getPlanName());
            returnDto.add(dto);
        }
        return returnDto;
    }
}
