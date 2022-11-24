package com.hsenid.lms.repository;

import com.hsenid.lms.model.Employee;
import com.hsenid.lms.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
