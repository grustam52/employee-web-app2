package ru.skypro.employee.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skypro.employee.exception.InvalidEmployeeDataException;
import ru.skypro.employee.service.EmployeeValidationService;
@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);

    }
    private void validateName(String name){
        if (StringUtils.isAlpha(name)){
            throw new InvalidEmployeeDataException("Некоректное значение имени: " + name);
        }
    }


}
