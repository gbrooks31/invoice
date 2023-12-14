package com.interview.rest.service.invoice.data;

public class InvoiceData {
    private String time;
    private TenderDetailsData tenderDetails;
    private String storeNumber;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TenderDetailsData getTenderDetails() {
        return tenderDetails;
    }

    public void setTenderDetails(TenderDetailsData tenderDetails) {
        this.tenderDetails = tenderDetails;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }
}
