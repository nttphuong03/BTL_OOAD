package com.FundManager.validation;


import com.FundManager.domain.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class TransactionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Transaction.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Transaction transaction = (Transaction) o;
        ValidationUtils.rejectIfEmpty(errors,"transactionName","notNull.Transaction.transactionName");
        ValidationUtils.rejectIfEmpty(errors,"money","notNull.Transaction.money");

    }
}
