package com.hsenid.lms.repository;

import com.hsenid.lms.model.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LeaveRepository extends MongoRepository<LeaveRequest,Long> {
//    @Query()
//    List<LeaveRequest> findByEmployeeId(String employeeId);
}
