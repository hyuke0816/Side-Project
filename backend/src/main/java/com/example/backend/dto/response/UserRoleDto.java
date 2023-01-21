package com.example.backend.dto.response;

/**
 * packageName : com.example.backend.dto.response
 * fileName : UserRoleDto
 * author : hyuk
 * date : 2023/01/21
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/21         hyuk          최초 생성
 */
public interface UserRoleDto {
//    User 테이블에서 getter

    Long getId();
    String getUsername();
    String getEmail();

//    Role 테이블에서 getter
    Long getRid();
    String getName();
    String getBirthday();
    String getGender();
    String getPhone();
    String getAddress();
    String getRname();
}
