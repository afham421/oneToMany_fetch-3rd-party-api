package com.detabase.sn3Integration.SecondThirdParty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class closedJobs {

    private clientDetails clientDetails;
    private jobDetails jobDetails;

    private String jobBrief;
    private String time;
    private String status;
    private String description;

}
