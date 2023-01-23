package com.example.backend.repository;

import com.example.backend.dto.response.UserRoleDto;
import com.example.backend.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * packageName : com.example.backend.repository
 * fileName : UserRepository
 * author : hyuk
 * date : 2023/01/22
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/22         hyuk          최초 생성
 */
public interface UserRepository extends JpaRepository<User, Long> {
    //    쿼리메소드
//    username(로그인id) 으로 조회하는 함수
    Optional<User> findByUsername(String username);

    //    username(로그인id) 있는지 검사하는 함수 ( 리턴값 : true/false )
    Boolean existsByUsername(String username);

    //    email 이 있는지 검사하는 함수 ( 리턴값 : true/false )
    Boolean existsByEmail(String email);

    //    @Query,
    @Query(value = "select u.*, r.rid, r.role_name " +
            "from tb_user u, " +
            "     tb_role r, " +
            "     tb_user_role ur " +
            "where u.id = ur.user_id " +
            "and   ur.role_id = r.rid " +
            "and   u.delete_yn = 'N' " +
            "and   r.delete_yn = 'N' " +
            "and   u.username like %:username% " +
            "order by u.id desc",
            countQuery = "select u.*, r.rid, r.role_name " +
                    "from tb_user u, " +
                    "     tb_role r, " +
                    "     tb_user_role ur " +
                    "where u.id = ur.user_id " +
                    "and   ur.role_id = r.rid " +
                    "and   u.delete_yn = 'N' " +
                    "and   r.delete_yn = 'N' " +
                    "and   u.username like %:username%"
            ,nativeQuery = true)
    Page<UserRoleDto> findAllByUsernameContaining(@Param("username") String username, Pageable pageable);

    Page<User> findByEmail(String email, Pageable pageable);
}
