package com.hsenid.lms.repository;

import com.hsenid.lms.model.ERole;
import com.hsenid.lms.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
