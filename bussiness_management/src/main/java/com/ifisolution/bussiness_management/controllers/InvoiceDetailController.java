package com.ifisolution.bussiness_management.controllers;

import com.ifisolution.bussiness_management.dto.InvoiceDetailDto;
import com.ifisolution.bussiness_management.models.InvoiceDetail;
import com.ifisolution.bussiness_management.services.InvoiceDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoicedetail")
@AllArgsConstructor
@Slf4j
public class InvoiceDetailController {
    private final InvoiceDetailService invoiceDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<InvoiceDetailDto>> getInvoiceDetailForInvoice(@PathVariable Long id) {
        List<InvoiceDetailDto> invoiceDetails = invoiceDetailService.getInvoiceDetailForInvoice(id);
        return new ResponseEntity<>(invoiceDetails, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<InvoiceDetail> addInvoiceDetail(@RequestBody InvoiceDetailDto invoiceDetailDto) {
        return new ResponseEntity<>(invoiceDetailService.addInvoiceDetail(invoiceDetailDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvoiceDetail(@PathVariable Long id) {
        invoiceDetailService.deleteInvoiceDetail(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
