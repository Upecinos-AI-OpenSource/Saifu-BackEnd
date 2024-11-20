package com.upecinosai.saifu.platform.userTransaction.domain.services;

public class TransactionDomainService {
    public boolean validateTransaction(double amount) {
        return amount > 0;
    }
}
