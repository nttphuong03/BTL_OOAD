package com.FundManager.validation;

import com.FundManager.domain.Fund;
import com.FundManager.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class FundValidator implements Validator {

    @Autowired
    FundService fundService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Fund.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Fund newfund  = (Fund) target;
        ValidationUtils.rejectIfEmpty(errors,"fundName","notEmpty.Fund.fundName");
        ValidationUtils.rejectIfEmpty(errors,"moneyOfFund","notEmpty.Fund.moneyOfFund");
        ValidationUtils.rejectIfEmpty(errors,"description","notEmpty.Fund.description");

        if( fundService.isExist(newfund.getFundName())) {
            errors.rejectValue("fundName","exists.Fund.fundName");
        }

    }
}
