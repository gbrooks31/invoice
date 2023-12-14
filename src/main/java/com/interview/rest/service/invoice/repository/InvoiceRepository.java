package com.interview.rest.service.invoice.repository;

import com.interview.rest.service.invoice.data.InvoiceEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//this would be interface InvoiceRepository extends CrudRepository<InvoicEntity, Long>
@Repository
public class InvoiceRepository {
    //This is for mocking data
    private  List<InvoiceEntity> invoices;
    public InvoiceRepository(){
        invoices = new ArrayList<>();
        //Fake data return
        InvoiceEntity i = new InvoiceEntity();
        i.setInvoiceId(56L);
        i.setCustomerId(2L);
        i.setInvoiceData("{\"time\": \"08:49\", \"tenderDetails\": {\"amount\": 100.12, \"type\": \"credit\"}, \"storeNumber\":\"999\"}");
        InvoiceEntity i2 = new InvoiceEntity();
        i2.setInvoiceId(55L);
        i2.setCustomerId(2L);
        i2.setInvoiceData("{\"time\": \"12:00\", \"tenderDetails\": {\"amount\": 4.95, \"type\": \"cash\"}, \"storeNumber\":\"999\"}");
        invoices.add(i);
        invoices.add(i2);
        InvoiceEntity i3 = new InvoiceEntity();
        i3.setCustomerId(1L);
        i3.setInvoiceId(54L);
        i3.setInvoiceData("{\"time\": \"19:53\", \"tenderDetails\": {\"amount\": 23.43, \"type\": \"cash\"}, \"storeNumber\":\"999\"}");
        invoices.add(i3);
    }
    //unless some customization was required
    //this method would be empty when attached to real DB
    public List<InvoiceEntity> getByCustomerId(Long id){
        return invoices.stream()
        .filter(invoice -> id.equals(invoice.getCustomerId()))
        .collect(Collectors.toList());
    }
}
