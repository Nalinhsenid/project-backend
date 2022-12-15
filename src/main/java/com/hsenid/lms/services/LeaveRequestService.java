package com.hsenid.lms.services;

import com.hsenid.lms.model.LeaveRequest;
import com.hsenid.lms.repository.LeaveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
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
    public LeaveRequest acceptLeaveRequest(Long id , Map<Object,Object> fields) {

        Optional<LeaveRequest> leaveRequest = leaveRepository.findById(id);
        if(leaveRequest.isPresent()){
            fields.forEach((key,value) -> {

                Field field = ReflectionUtils.findField(LeaveRequest.class, (String)key);
                field.setAccessible(true);
                System.out.println(field);
                ReflectionUtils.setField(field,leaveRequest.get(),value);
            });
            return leaveRepository.save(leaveRequest.get());
        }
        return null;
    }

}
