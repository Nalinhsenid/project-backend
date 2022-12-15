package com.hsenid.lms.controller;

import com.hsenid.lms.model.LeaveRequest;
import com.hsenid.lms.services.LeaveRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/leaves")
public class LeaveRequestController {
    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequests(){
        try {
            List<LeaveRequest> leaves = new ArrayList<>();
            leaveRequestService.getLeaves().forEach(leaves::add);

            if (leaves.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(leaves, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LeaveRequest> addLeaveRequest(@RequestBody LeaveRequest leaveRequest){
        log.info("Entered creation of leave request");
        try {
            LeaveRequest leaveRequestD = leaveRequestService.addLeaveRequest(leaveRequest);
            return new ResponseEntity<>(leaveRequestD, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestById(@PathVariable String id){
        Optional<List<LeaveRequest>> leaveRequest = Optional.ofNullable(leaveRequestService.getLeaveRequestById(id));

        if (leaveRequest.isPresent()) {
            return new ResponseEntity<>(leaveRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/approved/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<LeaveRequest>> getApprovedLeaveRequestById(@PathVariable String id){
        Optional<List<LeaveRequest>> leaveRequest = Optional.ofNullable(leaveRequestService.getApprovedLeaveRequestById(id));

        if (leaveRequest.isPresent()) {
            return new ResponseEntity<>(leaveRequest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteLeaveRequest(@PathVariable Long id) {
        try {
            leaveRequestService.deleteLeaveRequest(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("{id}/{leaveId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> acceptLeaveRequest(@PathVariable Long leaveId, @RequestBody Map<Object,Object> fields) {
        log.info("Accept leave request");
        try {
            log.info("In the try loop");
            leaveRequestService.acceptLeaveRequest(leaveId,fields);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
