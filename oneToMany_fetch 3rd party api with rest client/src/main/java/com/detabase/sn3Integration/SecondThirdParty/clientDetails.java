package com.detabase.sn3Integration.SecondThirdParty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class clientDetails {

    private String clientName;
    private String clientId;
    private String clientPhone;
    private String clientLat;
    private String clientLong;
}
