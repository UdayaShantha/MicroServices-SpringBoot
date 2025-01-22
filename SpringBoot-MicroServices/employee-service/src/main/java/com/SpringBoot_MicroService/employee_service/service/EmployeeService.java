package com.SpringBoot_MicroService.employee_service.service;

import com.SpringBoot_MicroService.employee_service.dto.ApiResponseDTO;
import com.SpringBoot_MicroService.employee_service.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployee(long employeeId);
}
