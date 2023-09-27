package com.example.bookingserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("booking-app")
public class TransactionConfiguration {

    private Boolean enableTransaction;

    public Boolean getEnableTransaction() {
        return enableTransaction;
    }

    public void setEnableTransaction(Boolean enableTransaction) {
        this.enableTransaction = enableTransaction;
    }
}
