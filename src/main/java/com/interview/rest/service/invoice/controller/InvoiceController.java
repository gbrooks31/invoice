package com.interview.rest.service.invoice.controller;

import com.interview.rest.service.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InvoiceController {
    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }
    @GetMapping("/invoice/{customerId}")
    public Map<Long, String> getInvoiceData(@PathVariable Long customerId){
        return invoiceService.getInvoiceData(customerId);
    }

}
