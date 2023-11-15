package com.detabase.sn3Integration.SecondThirdParty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class data {
    private scheduled scheduled;
    private List<closedJobs> closedJobs;
}
