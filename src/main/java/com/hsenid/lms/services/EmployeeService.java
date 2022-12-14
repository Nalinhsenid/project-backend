package com.hsenid.lms.services;

import com.hsenid.lms.model.Employee;
import com.hsenid.lms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        Employee employeeData = employeeRepository.save(employee);
        return employeeData;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String id){
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }


    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



}
