package com.furkanarslan.jwt.dto;

import com.furkanarslan.jwt.entity.Department;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoEmployee {

    private String lastName ;

    private String firstName;

    private Department department;
}
