package com.interview.rest.service.invoice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.rest.service.invoice.data.InvoiceData;
import com.interview.rest.service.invoice.data.InvoiceEntity;
import com.interview.rest.service.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
        objectMapper.enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature());
    }

    public Map<Long, String> getInvoiceData(Long customerId) {
        Map<Long,String> invoiceMap = new HashMap<>();

        List<InvoiceEntity> invoices = invoiceRepository.getByCustomerId(customerId);

        return invoices.stream()
                .collect(Collectors.toMap(InvoiceEntity::getInvoiceId, invoice-> {
                    try {
                        return objectMapper.readValue(invoice.getInvoiceData(), InvoiceData.class).getTenderDetails().getType();
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }));


    }
}
