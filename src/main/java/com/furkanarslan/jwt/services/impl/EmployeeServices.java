package com.furkanarslan.jwt.services.impl;

import com.furkanarslan.jwt.dto.DtoDepartment;
import com.furkanarslan.jwt.dto.DtoEmployee;
import com.furkanarslan.jwt.entity.Department;
import com.furkanarslan.jwt.entity.Employee;
import com.furkanarslan.jwt.repository.EmployeeRepository;
import com.furkanarslan.jwt.services.IEmployeeServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServices implements IEmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
         Optional<Employee> optional = employeeRepository.findById(id);

         if (optional.isPresent()) {
             Employee employee = optional.get();
             Department department = employee.getDepartment();
              BeanUtils.copyProperties(employee, dtoEmployee);
              BeanUtils.copyProperties(department, dtoDepartment);
              dtoEmployee.setDepartment(department);
return dtoEmployee;
         }






        return null;
    }
}
