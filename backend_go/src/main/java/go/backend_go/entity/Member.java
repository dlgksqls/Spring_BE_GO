package go.backend_go.entity;

import go.backend_go.dtos.MemberJoinDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String loginId;
    @NotNull
    private String password;
    @NotNull
    private String username;
    private String email;
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "member")
    private List<Review> member_reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Schedule> member_schedules = new ArrayList<>();

    public void joinMember(MemberJoinDto dto){
        this.loginId = dto.getLoginId();
        this.password = dto.getPassword();
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.joinDate = LocalDateTime.now();
    }
}
