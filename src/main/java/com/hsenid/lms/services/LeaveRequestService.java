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

    public LeaveRequest getLeaveRequestById(Long id){
        return leaveRepository.findById(id).get();
    }

    public void deleteLeaveRequest(Long id) {
        leaveRepository.deleteById(id);
    }

}
