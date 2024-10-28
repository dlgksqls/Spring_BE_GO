package go.backend_go.entity;

import go.backend_go.dtos.Plan.PlanRegisterDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "plan")
    private List<Schedule> schedules = new ArrayList<>();

    public void createPlan(PlanRegisterDto dto){
        this.planName = dto.getPlanName();
        this.member = dto.getMember();

        updateSchedules(dto.getSchedules());
    }

    private void updateSchedules(List<Schedule> schedules) {
        this.schedules.addAll(schedules);
    }
}
