package go.backend_go.service;

import go.backend_go.dtos.Plan.PlanRegisterDto;
import go.backend_go.dtos.Plan.PlanViewDto;
import go.backend_go.entity.Plan;
import go.backend_go.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    public List<PlanViewDto> findAll() {
        List<Plan> plans = planRepository.findAll();
        List<PlanViewDto> returnDto = new ArrayList<>();

        for (Plan plan : plans) {
            PlanViewDto dto = new PlanViewDto(plan);
            returnDto.add(dto);
        }
        return returnDto;
    }

    public PlanViewDto save(PlanRegisterDto newPlan) {
        Plan plan = new Plan();
        plan.createPlan(newPlan);

        planRepository.save(plan);

        PlanViewDto returnDto = new PlanViewDto(plan);
        return returnDto;
    }
}
