package com.SpringBoot_MicroService.department_service.service;


import com.SpringBoot_MicroService.department_service.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String code);
}
