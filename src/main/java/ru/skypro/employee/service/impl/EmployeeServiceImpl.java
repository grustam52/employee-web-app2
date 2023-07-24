package ru.skypro.employee.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.employee.exception.EmployeeAlreadyAddedException;
import ru.skypro.employee.exception.EmployeeNotFoundException;
import ru.skypro.employee.model.Employee;
import ru.skypro.employee.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        add("Ivan", "Ivanov");
        add("Semen", "Semenov");
        add("Petr", "Petrov");
        add("Grigory", "Grigorev");
        add("Alexey", "Alexeev");
        add("Andrey", "Andreev");

    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);

        return employee;

    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName,lastName, salary, departmentId);
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
