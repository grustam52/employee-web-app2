package ru.skypro.employee.service;

import ru.skypro.employee.model.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}
