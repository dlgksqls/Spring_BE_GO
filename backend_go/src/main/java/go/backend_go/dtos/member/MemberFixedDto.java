package go.backend_go.dtos.member;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberFixedDto {
    private String loginId;
    private String password;
    private String email;
}
