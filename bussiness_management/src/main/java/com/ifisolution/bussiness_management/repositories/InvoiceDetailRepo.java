package com.ifisolution.bussiness_management.repositories;

import com.ifisolution.bussiness_management.models.Invoice;
import com.ifisolution.bussiness_management.models.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepo extends JpaRepository<InvoiceDetail, Long> {
    List<InvoiceDetail> findByInvoice(Invoice invoice);
}
