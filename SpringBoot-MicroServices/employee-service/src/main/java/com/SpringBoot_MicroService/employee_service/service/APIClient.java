package com.SpringBoot_MicroService.employee_service.service;

import com.SpringBoot_MicroService.department_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081",value="department-service")
public interface APIClient {

//    @GetMapping("api/departments/get/department_by_code/{departmentCode}")
//    DepartmentDTO getDepartment(@PathVariable(value = "departmentCode") String departmentCode);

//    @GetMapping("/get/department_by_code/{departmentCode}")
//    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("departmentCode") String departmentCode) {
//        DepartmentDTO departmentDto = departmentService.getDepartmentByCode(departmentCode);
//        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
//    }
}
