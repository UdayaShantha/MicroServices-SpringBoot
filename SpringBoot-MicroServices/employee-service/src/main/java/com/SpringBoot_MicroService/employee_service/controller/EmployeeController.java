package com.SpringBoot_MicroService.employee_service.controller;

import com.SpringBoot_MicroService.employee_service.dto.ApiResponseDTO;
import com.SpringBoot_MicroService.employee_service.dto.EmployeeDTO;
import com.SpringBoot_MicroService.employee_service.entity.Employee;
import com.SpringBoot_MicroService.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save/employee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTO1=employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/get/employee{employeeId}")
    public ResponseEntity<ApiResponseDTO> getEmployee(@PathVariable long employeeId) {
        ApiResponseDTO apiResponseDTO=employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.FOUND);
    }
}
