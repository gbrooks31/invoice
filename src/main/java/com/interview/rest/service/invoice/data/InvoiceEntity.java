package com.interview.rest.service.invoice.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;




@Entity
@Table(name = "invoice")
public class InvoiceEntity {


    private Long customerId;
    @Id
    private Long invoiceId;

    @Column(columnDefinition = "jsonb")
    //depending on db implementation this definition could change
    private String invoiceData;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(String invoiceData) {
        this.invoiceData = invoiceData;
    }
}
