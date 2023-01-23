package com.example.backend.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * packageName : com.example.backend.dto.request
 * fileName : SignupRequest
 * author : hyuk
 * date : 2023/01/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/23         hyuk          최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private String birth;

    private String gender;

    private String phone;

    private String address;

    private Set<String> role;

    private boolean changePwd;

}
