package com.ifisolution.bussiness_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDetailDto {
    private Long id;
    private Long invoiceId;
    private String product;
    private int quantity;
}
