package com.ifisolution.bussiness_management.mapper;

import com.ifisolution.bussiness_management.dto.InvoiceRequest;
import com.ifisolution.bussiness_management.dto.InvoiceResponse;
import com.ifisolution.bussiness_management.models.Customer;
import com.ifisolution.bussiness_management.models.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class InvoiceMapper {
    @Mapping(target = "id", source = "invoiceRequest.id")
    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "createAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "total", constant = "0")
    public abstract Invoice map(InvoiceRequest invoiceRequest, Customer customer);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "createAt", source = "createAt")
    @Mapping(target = "total", source = "total")
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerName", source = "customer.firstName")
    public abstract InvoiceResponse mapToDto(Invoice invoice);

}
