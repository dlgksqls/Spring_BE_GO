package go.backend_go.service;

import go.backend_go.dtos.schedule.ScheduleViewDto;
import go.backend_go.entity.Schedule;
import go.backend_go.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleViewDto> viewAll() {
        List<Schedule> allSchedule = scheduleRepository.findAll();
        List<ScheduleViewDto> returnDto = new ArrayList<>();

        for (Schedule schedule : allSchedule) {
            ScheduleViewDto dto = new ScheduleViewDto(schedule);
            returnDto.add(dto);
        }
        return returnDto;
    }
}