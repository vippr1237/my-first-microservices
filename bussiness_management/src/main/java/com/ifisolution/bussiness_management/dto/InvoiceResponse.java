package com.ifisolution.bussiness_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceResponse {
    private Long id;
    private Instant createAt;
    private float total;
    private Long customerId;
    private String customerName;
}
