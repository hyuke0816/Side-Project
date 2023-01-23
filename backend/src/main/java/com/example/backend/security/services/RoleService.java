package com.example.backend.security.services;

import com.example.backend.model.ERole;
import com.example.backend.model.Role;
import com.example.backend.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName : com.example.backend.security.services
 * fileName : RoleService
 * author : hyuk
 * date : 2023/01/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/23         hyuk          최초 생성
 */
@Service
@Slf4j
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByRoleName(ERole roleName) {
        return  roleRepository.findByRoleName(roleName);
    }
}
