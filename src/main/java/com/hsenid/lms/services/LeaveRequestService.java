package com.hsenid.lms.services;

import com.hsenid.lms.model.LeaveRequest;
import com.hsenid.lms.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest) {
        LeaveRequest leaveRequestData = leaveRepository.save(leaveRequest);
        return leaveRequestData;
    }

    public List<LeaveRequest> getLeaves(){
        return leaveRepository.findAll();
    }

    public LeaveRequest getLeaveRequestById(String id){
        return leaveRepository.findById(id).get();
    }

    public void deleteLeaveRequest(String id) {
        leaveRepository.deleteById(id);
    }

}
