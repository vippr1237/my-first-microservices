package com.ifisolution.bussiness_management.controllers;

import com.ifisolution.bussiness_management.dto.InvoiceRequest;
import com.ifisolution.bussiness_management.dto.InvoiceResponse;
import com.ifisolution.bussiness_management.models.Invoice;
import com.ifisolution.bussiness_management.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("")
    public ResponseEntity<List<InvoiceResponse>> getAllInvoices() {
        List<InvoiceResponse> Invoices = invoiceService.getAllInvoice();
        return new ResponseEntity<>(Invoices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getInvoiceById(@PathVariable("id") Long id) {
        InvoiceResponse Invoice = invoiceService.getInvoice(id);
        return new ResponseEntity<>(Invoice, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceRequest Invoice) {
        Invoice newInvoice = invoiceService.addInvoice(Invoice);
        return new ResponseEntity<>(newInvoice, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Invoice> updateInvoice(@RequestBody InvoiceRequest Invoice) {
        Invoice updateInvoice = invoiceService.update(Invoice);
        return new ResponseEntity<>(updateInvoice, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteInvoice(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
