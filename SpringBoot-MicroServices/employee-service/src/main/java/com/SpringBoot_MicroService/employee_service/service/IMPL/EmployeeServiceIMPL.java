package com.SpringBoot_MicroService.employee_service.service.IMPL;

import com.SpringBoot_MicroService.department_service.dto.DepartmentDTO;
import com.SpringBoot_MicroService.employee_service.dto.ApiResponseDTO;
import com.SpringBoot_MicroService.employee_service.dto.EmployeeDTO;
import com.SpringBoot_MicroService.employee_service.entity.Employee;
import com.SpringBoot_MicroService.employee_service.repository.EmployeeRepository;
import com.SpringBoot_MicroService.employee_service.service.APIClient;
import com.SpringBoot_MicroService.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
////  private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

//    private APIClient apiClient;
//
//    public EmployeeServiceIMPL(APIClient apiClient) {
//        this.apiClient = apiClient;
//    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFname(),
                employeeDTO.getLname(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDTO savedEmployeeDTO = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFname(),
                savedEmployee.getLname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDTO;
    }

    @Override
    public ApiResponseDTO getEmployee(long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();

//        From Using RestTemplate

//        ResponseEntity<DepartmentDTO> responseEntity=restTemplate.getForEntity("http://localhost:8081/api/departments/get/department_by_code/"+employee.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO=responseEntity.getBody();


//        From using WebClient

    DepartmentDTO departmentDTO=webClient.get()
            .uri("http://localhost:8081/api/departments/get/department_by_code/"+employee.getDepartmentCode())
            .retrieve()
            .bodyToMono(DepartmentDTO.class)
            .block();

//    From FeignClient
//        DepartmentDTO departmentDTO=apiClient.getDepartment(employee.getDepartmentCode());



        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFname(),
                employee.getLname(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDTO apiResponseDTO=new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO) ;
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }
}
