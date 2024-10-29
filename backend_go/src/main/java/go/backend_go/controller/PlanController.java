package go.backend_go.controller;

import go.backend_go.dtos.Plan.PlanRegisterDto;
import go.backend_go.dtos.Plan.PlanViewDto;
import go.backend_go.entity.Plan;
import go.backend_go.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final PlanService planService;

    @GetMapping("")
    public List<PlanViewDto> viewAll(){
        return planService.findAll();
    }

    @PostMapping("/save")
    public PlanViewDto savePlan(PlanRegisterDto dto){
        Plan createPlan = planService.save(dto);

        PlanViewDto returnDto = new PlanViewDto(createPlan);

        return returnDto;
    }
}
