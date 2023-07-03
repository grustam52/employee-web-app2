package ru.skypro.employee.service.impl;

import ru.skypro.employee.exception.EmployeeAlreadyAddedException;
import ru.skypro.employee.exception.EmployeeNotFoundException;
import ru.skypro.employee.model.Employee;
import ru.skypro.employee.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService  {
    private final List<Employee> employees;

    public EmployeeServiceImpl(List<Employee> employee) {
        this.employees = employee;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee)
        return employee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw  new EmployeeNotFoundException();

        }
        employees.remove(employee);

        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}
