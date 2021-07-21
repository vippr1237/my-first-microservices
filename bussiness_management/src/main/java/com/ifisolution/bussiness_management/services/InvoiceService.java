package com.ifisolution.bussiness_management.services;

import com.ifisolution.bussiness_management.dto.InvoiceRequest;
import com.ifisolution.bussiness_management.dto.InvoiceResponse;
import com.ifisolution.bussiness_management.exceptions.CustomerNotFoundException;
import com.ifisolution.bussiness_management.exceptions.InvoiceNotFoundException;
import com.ifisolution.bussiness_management.mapper.InvoiceMapper;
import com.ifisolution.bussiness_management.models.Customer;
import com.ifisolution.bussiness_management.models.Invoice;
import com.ifisolution.bussiness_management.repositories.CustomerRepo;
import com.ifisolution.bussiness_management.repositories.InvoiceRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j

public class InvoiceService {
    private final InvoiceRepo invoiceRepo;
    private final CustomerRepo customerRepo;
    private final InvoiceMapper invoiceMapper;

    public List<InvoiceResponse> getAllInvoice() {
        return invoiceRepo.findAll()
                .stream().map(invoiceMapper::mapToDto)
                .collect(toList());
    }

    public Invoice addInvoice(InvoiceRequest invoiceRequest) {
        Customer customer = customerRepo.findCustomerById(invoiceRequest.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer by id " + invoiceRequest.getCustomerId() + " was not found"));
        return invoiceRepo.save(invoiceMapper.map(invoiceRequest, customer));
    }

    public InvoiceResponse getInvoice(Long id) {
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice by id " + id + " was not found"));
        return invoiceMapper.mapToDto(invoice);
    }

    public Invoice update(InvoiceRequest invoiceRequest) {
        Customer customer = customerRepo.findCustomerById(invoiceRequest.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer by id " + invoiceRequest.getCustomerId() + " was not found"));
        return invoiceRepo.save(invoiceMapper.map(invoiceRequest, customer));
    }

    public void deleteInvoice(Long id) {
        if (!invoiceRepo.existsById(id)) {
            throw new InvoiceNotFoundException("Invoice by id " + id + " was not found");
        }
        invoiceRepo.deleteById(id);
    }
}
