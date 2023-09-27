package com.example.bookingserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConfigListener implements ApplicationListener<EnvironmentChangeEvent> {
    @Autowired
    private TransactionConfiguration transactionConfiguration;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {

    }
}
