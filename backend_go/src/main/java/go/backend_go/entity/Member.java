package go.backend_go.entity;

import go.backend_go.controller.MemberController;
import go.backend_go.dtos.member.MemberFixedDto;
import go.backend_go.dtos.member.MemberJoinDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Entity @Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "아이디는 필수 입력 값입니다.", groups = {})
    private String loginId;
    @NotNull(message = "비밀번호는 필수 입력 값니다.")
    private String password;
    @NotNull(message = "당신의 이름은 필수 입력 값입니다.")
    private String username;
//    @Email
    private String email;
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "member")
    private List<Review> member_reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Plan> member_plan= new ArrayList<>();

    public void join(MemberJoinDto dto){
        this.loginId = dto.getLoginId();
        this.password = dto.getPassword();
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.joinDate = LocalDateTime.now();
    }

    public void update(MemberFixedDto dto){
        if (dto == null){
            throw new IllegalArgumentException("변경하려는 값을 입력해주세요.");
        }
        else if (!dto.validatedEmail()){
            throw new IllegalArgumentException("이메일 형식에 맞게 작성해주세요.");
        }

        if (dto.getLoginId() != null) this.loginId = dto.getLoginId();

        if (dto.getPassword() != null) this.password = dto.getPassword();

        if (dto.getEmail() != null) this.email = dto.getEmail();
    }
}
