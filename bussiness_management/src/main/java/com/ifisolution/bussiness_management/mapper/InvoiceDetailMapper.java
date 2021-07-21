package com.ifisolution.bussiness_management.mapper;

import com.ifisolution.bussiness_management.dto.InvoiceDetailDto;
import com.ifisolution.bussiness_management.models.Invoice;
import com.ifisolution.bussiness_management.models.InvoiceDetail;
import com.ifisolution.bussiness_management.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceDetailMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "invoiceId", source = "invoice.id")
    @Mapping(target = "product", source = "product.productName")
    @Mapping(target = "quantity", source = "quantity")
    InvoiceDetailDto maptoDto(InvoiceDetail invoiceDetail);

    @Mapping(target = "id", source = "invoiceDetailDto.id")
    @Mapping(target = "product", source = "product")
    @Mapping(target = "invoice", source = "invoice")
    @Mapping(target = "quantity", source = "invoiceDetailDto.quantity")
    InvoiceDetail mapInvoiceDetail(InvoiceDetailDto invoiceDetailDto, Product product, Invoice invoice);
}
