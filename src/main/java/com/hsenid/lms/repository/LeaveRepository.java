package com.hsenid.lms.repository;

import com.hsenid.lms.model.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LeaveRepository extends MongoRepository<LeaveRequest,String> {
//    @Query()
//    List<LeaveRequest> findByEmployeeId(String employeeId);
}
