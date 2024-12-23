package go.backend_go.dtos.member;

import go.backend_go.entity.Member;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDetailDto {

    public MemberDetailDto(Member member) {
        this.loginId = member.getLoginId();
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.joinDate = member.getJoinDate();
    }

    public MemberDetailDto(String loginId, String username, String email, LocalDateTime joinDate) {
        this.loginId = loginId;
        this.username = username;
        this.email = email;
        this.joinDate = joinDate;
    }

    private String loginId;
    private String username;
    private String email;
    private LocalDateTime joinDate;
}
