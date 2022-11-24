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

    @GetMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")

    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Added Employee with id : " +employee.getId();
    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")

    public Employee getStudent(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employees/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStudent(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return "Delete student with id :" +id;

    }
}
