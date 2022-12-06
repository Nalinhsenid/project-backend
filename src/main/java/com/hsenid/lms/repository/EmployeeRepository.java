package com.hsenid.lms.repository;

import com.hsenid.lms.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeeRepository extends MongoRepository<Employee,String> {

}
