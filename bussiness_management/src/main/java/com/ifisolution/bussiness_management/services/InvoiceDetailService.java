package com.ifisolution.bussiness_management.services;

import com.ifisolution.bussiness_management.dto.InvoiceDetailDto;
import com.ifisolution.bussiness_management.exceptions.InvoiceDetailNotFoundException;
import com.ifisolution.bussiness_management.exceptions.InvoiceNotFoundException;
import com.ifisolution.bussiness_management.exceptions.OutOfProductException;
import com.ifisolution.bussiness_management.exceptions.ProductNotFoundException;
import com.ifisolution.bussiness_management.mapper.InvoiceDetailMapper;
import com.ifisolution.bussiness_management.models.Invoice;
import com.ifisolution.bussiness_management.models.InvoiceDetail;
import com.ifisolution.bussiness_management.models.Product;
import com.ifisolution.bussiness_management.repositories.InvoiceDetailRepo;
import com.ifisolution.bussiness_management.repositories.InvoiceRepo;
import com.ifisolution.bussiness_management.repositories.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceDetailService {
    private final ProductRepo productRepo;
    private final InvoiceRepo invoiceRepo;
    private final InvoiceDetailRepo invoiceDetailRepo;
    private final InvoiceDetailMapper invoiceDetailMapper;

    public List<InvoiceDetailDto> getInvoiceDetailForInvoice(Long invoiceId) {
        Invoice invoice = invoiceRepo.findById(invoiceId).orElseThrow(() -> new InvoiceNotFoundException("Invoice by id " + invoiceId + " was not found"));
        return invoiceDetailRepo.findByInvoice(invoice)
                .stream()
                .map(invoiceDetailMapper::maptoDto)
                .collect(toList());
    }

    public InvoiceDetail addInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
        Invoice invoice = invoiceRepo.findById(invoiceDetailDto.getInvoiceId()).orElseThrow(() -> new InvoiceNotFoundException("Invoice by id " + invoiceDetailDto.getInvoiceId() + " was not found"));
        //DTO để string nên phải parse sang Long mới tìm đc
        Product product = productRepo.findById(Long.parseLong(invoiceDetailDto.getProduct())).orElseThrow(() -> new ProductNotFoundException("Product by id " + invoiceDetailDto.getProduct() + " was not found"));

        if (product.getQuantity() - invoiceDetailDto.getQuantity() < 0) {
            throw new OutOfProductException("Product by id " + product.getId() + "is out of order");
        } else {
            product.setQuantity(product.getQuantity() - invoiceDetailDto.getQuantity());
            productRepo.save(product);
        }
        invoice.setTotal(invoice.getTotal() + product.getPrice() * invoiceDetailDto.getQuantity());
        invoiceRepo.save(invoice);
        return invoiceDetailRepo.save(invoiceDetailMapper.mapInvoiceDetail(invoiceDetailDto, product, invoice));
    }

    public void deleteInvoiceDetail(Long id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepo.findById(id).orElseThrow(() -> new InvoiceDetailNotFoundException("Invoice Detail by id " + id + " was not found"));
        Product product = productRepo.findById(invoiceDetail.getProduct().getId()).orElseThrow(() -> new ProductNotFoundException("Product by id " + invoiceDetail.getProduct().getId() + "was not found"));
        Invoice invoice = invoiceRepo.findById(invoiceDetail.getInvoice().getId()).orElseThrow(() -> new InvoiceNotFoundException("Invoice by id " + invoiceDetail.getInvoice().getId() + "was not found"));
        invoice.setTotal(invoice.getTotal() - product.getPrice() * invoiceDetail.getQuantity());
        product.setQuantity(product.getQuantity() + invoiceDetail.getQuantity());
        invoiceDetailRepo.deleteById(id);
    }
}
