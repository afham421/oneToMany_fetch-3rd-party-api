package com.detabase.sn3Integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBussiness {

    public String statusCode;
    public String reporting;
    public String exception;
    public String displayMessage;

    public ThirdData data;

}
