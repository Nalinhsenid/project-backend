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

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest) {
        leaveRequest.setId(sequenceGeneratorService.generateSequence(LeaveRequest.SEQUENCE_NAME));
        LeaveRequest leaveRequestData = leaveRepository.save(leaveRequest);
        return leaveRequestData;
    }

    public List<LeaveRequest> getLeaves(){
        return leaveRepository.findAll();
    }

    public List<LeaveRequest> getLeaveRequestById(String id){
        return leaveRepository.findByEmployeeId(id);
    }
    public List<LeaveRequest> getApprovedLeaveRequestById(String id){
        return leaveRepository.findByEmployeeIdAndIsApprovedIsTrue(id);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRepository.deleteById(id);
    }
//    public void acceptLeaveRequest(Long id) {
//        leaveRepository.p(id);
//    }

}
