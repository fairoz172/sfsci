package com.fairoz.sfsci.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerReportDto {

    private Double averageTimeToBecomeProspect;
    private Double averageTimeToBecomeCustomer;

}
