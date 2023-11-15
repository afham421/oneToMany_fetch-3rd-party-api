package com.detabase.sn3Integration;

import com.detabase.oneToMany.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThirdParty {

    private String name;
    private String phoneNo;
    private String email;
    private Department department;

    private String authToken;
    private String displayMessage;

    private String tpName;
    private String workerStatus;


}
