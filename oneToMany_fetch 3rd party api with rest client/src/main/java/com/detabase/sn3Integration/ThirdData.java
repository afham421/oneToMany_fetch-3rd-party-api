package com.detabase.sn3Integration;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class ThirdData {
    public String authToken;
    public String integrationToken;
    public String id;
    public String name;
    public String resourceType;
    public String workerStatus;
    public String posPollingTime;
}
