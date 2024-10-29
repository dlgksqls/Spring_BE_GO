package go.backend_go.controller;

import go.backend_go.dtos.schedule.ScheduleViewDto;
import go.backend_go.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ScheduleViewDto save(){
        return null;
    }
}
