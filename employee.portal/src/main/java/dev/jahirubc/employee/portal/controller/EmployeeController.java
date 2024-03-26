package dev.jahirubc.employee.portal.controller;

import dev.jahirubc.employee.portal.domain.EmployeeDto;
import dev.jahirubc.employee.portal.entity.EmployeeEntity;
import dev.jahirubc.employee.portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Create API
    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }
    //Read API
    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }
    //Update API
    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }
    //Delete API
    @DeleteMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}