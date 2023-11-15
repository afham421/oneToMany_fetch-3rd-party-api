package com.detabase.sn3Integration;

import com.detabase.oneToMany.Response.Response;
import com.detabase.oneToMany.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOfBothDBand3rdParty {


    private Employee dbDetail;
    private String thirdPartyDetail;


}
