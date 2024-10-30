package go.backend_go.controller;

import go.backend_go.dtos.schedule.ScheduleRegisterDto;
import go.backend_go.dtos.schedule.ScheduleViewDto;
import go.backend_go.entity.Schedule;
import go.backend_go.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("")
    public List<ScheduleViewDto> viewAll(){
        return scheduleService.viewAll();
    }

    @PostMapping("/save")
    public ScheduleViewDto save(ScheduleRegisterDto dto){

        Schedule schedule = new Schedule();

        return scheduleService.save(schedule, dto);
    }

    @DeleteMapping("/delete")
    public String delete(Long scheduleId){

        scheduleService.delete(scheduleId);
        return "성공";
    }
}
