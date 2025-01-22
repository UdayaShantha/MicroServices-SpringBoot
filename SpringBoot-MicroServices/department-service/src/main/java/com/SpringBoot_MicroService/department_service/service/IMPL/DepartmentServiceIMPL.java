package com.SpringBoot_MicroService.department_service.service.IMPL;

import com.SpringBoot_MicroService.department_service.dto.DepartmentDTO;
import com.SpringBoot_MicroService.department_service.entity.Department;
import com.SpringBoot_MicroService.department_service.repository.DepartmentRepository;
import com.SpringBoot_MicroService.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceIMPL implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(
                departmentDTO.getDepartmentId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );

        Department department1= departmentRepository.save(department);
        DepartmentDTO departmentDTO1 = new DepartmentDTO(
                department1.getDepartmentId(),
                department1.getDepartmentName(),
                department1.getDepartmentDescription(),
                department1.getDepartmentCode()
        );
        return departmentDTO1;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department=departmentRepository.findByDepartmentCode(code);
        DepartmentDTO departmentDTO=new DepartmentDTO(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDTO;
    }
}
