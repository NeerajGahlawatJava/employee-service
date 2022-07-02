package com.app.neeraj.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {

    private int departId;
    private String departName;
    private String departAddress;
    private String departCode;
}
