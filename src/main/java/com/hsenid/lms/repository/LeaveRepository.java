package com.hsenid.lms.repository;

import com.hsenid.lms.model.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface LeaveRepository extends MongoRepository<LeaveRequest,Long> {
    List<LeaveRequest> findByEmployeeId(String employeeId);
    List<LeaveRequest> findByEmployeeIdAndIsApprovedIsTrue(String employeeId);
}
