package com.example.backend.service;

import com.example.backend.dto.response.UserRoleDto;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.backend.service
 * fileName : UserService
 * author : hyuk
 * date : 2023/01/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/23         hyuk          최초 생성
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//    TODO: 전체 조회 함수
    public Page<User> findAll(Pageable pageable) {
        Page<User> page = userRepository.findAll(pageable);

        return page;
    }

//    TODO: id(pk)로 조회 함수
    public Optional<User> findById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        return optionalUser;
    }

//    TODO: 전체 삭제 함수
    public void removeAll() {
        userRepository.deleteAll();
    }

//    TODO: 유저 저장 함수
    public User save(User user) {
        User user2 = userRepository.save(user);

        return user2;
    }

//    TODO: id(pk)로 삭제 함수
    public boolean removeById(long id) {
        if (userRepository.existsById(id) == true) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    TODO: username 존재하는지 여부 확인 함수
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

//    TODO: email 존재하는지 여부 확인 함수
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

//    TODO: username like 검색 함수
    public Page<UserRoleDto> findAllByUsernameContaining(String username, Pageable pageable) {
        Page<UserRoleDto> page = userRepository.findAllByUsernameContaining(username, pageable);

        return page;
    }

//    TODO: email로 like 검색 함수
//    FIXME: username like 검색함수처럼 join해서 사용해야할지 말지는 아직 모르겠음.
    public Page<User> findByEmail(String email, Pageable pageable) {
        Page<User> page = userRepository.findByEmail(email, pageable);

        return page;
    }
}
