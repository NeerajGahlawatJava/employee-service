package com.app.neeraj.user.vo;

import com.app.neeraj.user.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private Employee user;
    private DepartmentVO department;
}
