package com.furkanarslan.jwt.controller;

import com.furkanarslan.jwt.dto.DtoEmployee;

public interface IEmployeeController {

    public DtoEmployee findEmployeeById(long id);

}
