package go.backend_go.dtos;

import lombok.Data;

@Data
public class MemberJoinDto {
    private String loginId;
    private String password;
    private String username;
    private String email;
}
