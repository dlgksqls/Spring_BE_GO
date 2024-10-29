package go.backend_go.service;

import go.backend_go.dtos.Plan.PlanRegisterDto;
import go.backend_go.dtos.Plan.PlanViewDto;
import go.backend_go.entity.Member;
import go.backend_go.entity.Plan;
import go.backend_go.repository.MemberRepository;
import go.backend_go.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final MemberRepository memberRepository;
    public List<PlanViewDto> findAll() {
        List<Plan> plans = planRepository.findAll();
        List<PlanViewDto> returnDto = new ArrayList<>();

        for (Plan plan : plans) {
            PlanViewDto dto = new PlanViewDto(plan);
            returnDto.add(dto);
        }
        return returnDto;
    }

    public Plan save(PlanRegisterDto newPlan) {
        Plan plan = new Plan();

        plan.createPlan(newPlan);

        Optional<Member> planMember = memberRepository.findById(newPlan.getMember().getId());

        planMember.get().getMember_plan().add(plan);

        planRepository.save(plan);

        return plan;
    }
}
