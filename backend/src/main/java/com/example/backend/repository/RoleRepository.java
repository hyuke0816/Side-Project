package com.example.backend.repository;

import com.example.backend.model.ERole;
import com.example.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName : com.example.backend.repository
 * fileName : RoleRepository
 * author : hyuk
 * date : 2023/01/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/23         hyuk          최초 생성
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
//    TODO: 권한명(ROLE_NAME)으로 검색하는 함수
    Optional<Role> findByRoleName(ERole roleName);
}
