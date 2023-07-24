package ru.skypro.employee.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employee.exception.EmployeeAlreadyAddedException;
import ru.skypro.employee.exception.EmployeeNotFoundException;
import ru.skypro.employee.model.Employee;
import ru.skypro.employee.service.EmployeeService;
import ru.skypro.employee.service.EmployeeValidationService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
    private final Map<String, Employee> employees;
    private final EmployeeValidationService validationService;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;
        this.employees = new HashMap<>();


    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        validationService.validate(firstName, lastName);
        return employee;

    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName,lastName, salary, departmentId);
        validationService.validate(firstName, lastName);
       return add(employee);

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())){
            throw  new EmployeeNotFoundException();

        }
        employees.remove(employee.getFullName());

        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.containsKey(employee.getFullName())){
            throw  new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
    private Employee add(Employee employee){
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
}
