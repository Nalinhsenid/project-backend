package com.hsenid.lms.controller;

import com.hsenid.lms.model.Employee;
import com.hsenid.lms.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/home")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return "This is dash board page";
    }


    @GetMapping("/manage")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }


}
