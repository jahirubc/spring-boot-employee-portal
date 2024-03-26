package dev.jahirubc.employee.portal.service;

import dev.jahirubc.employee.portal.domain.EmployeeDto;
import dev.jahirubc.employee.portal.entity.EmployeeEntity;
import dev.jahirubc.employee.portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //Create Employee API
    public EmployeeEntity createEmployee(EmployeeDto employeeDto) {
        //Mapping Dto to Entity
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setDesignation(employeeDto.getDesignation());
        employeeEntity.setPhoneNumber(employeeDto.getPhoneNumber());
        employeeRepository.save(employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

    //Read Employee API
    public EmployeeDto getEmployee(Long id) {
        //Fetching Employee Entity
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findById(id);
        EmployeeEntity employeeEntity = employeeEntityOptional.get();

        //Error Handling
        if (employeeEntity == null) {
            throw new RuntimeException("Employee not found");
        }

        //Mapping Entity to Dto
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employeeEntity.getName());
        employeeDto.setDesignation(employeeEntity.getDesignation());
        employeeDto.setPhoneNumber(employeeEntity.getPhoneNumber());

        return employeeDto;
    }

    //Update Employee API
//    public String updateEmployee(String id){
//        return "Employee Updated";
//    }
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity existingEmployee = optionalEmployee.get();
            existingEmployee.setName(employeeDto.getName());
            existingEmployee.setDesignation(employeeDto.getDesignation());
            existingEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
            employeeRepository.save(existingEmployee);
            return employeeDto;
        } else {
            throw new RuntimeException("Employee not found");
        }
    }


    //Delete Employee API
//    public String deleteEmployee(String id){
//        return "Employee deleted";
//    }
    public String deleteEmployee(Long id) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}