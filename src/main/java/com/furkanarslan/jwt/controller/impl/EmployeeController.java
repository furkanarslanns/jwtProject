package com.furkanarslan.jwt.controller.impl;

import com.furkanarslan.jwt.controller.IEmployeeController;
import com.furkanarslan.jwt.dto.DtoEmployee;
import com.furkanarslan.jwt.services.impl.EmployeeServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements IEmployeeController {
    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/{id}")
    @Override
    public DtoEmployee findEmployeeById( @PathVariable(value = "id") long id) {
        return employeeServices.findEmployeeById(id);
    }
}
