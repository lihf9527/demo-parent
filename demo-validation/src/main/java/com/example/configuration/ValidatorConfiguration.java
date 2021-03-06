package com.example.configuration;

import lombok.val;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {

    @Bean
    public Validator validator() {
        val validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        // hibernate.validator.fail_fast
        return validatorFactory.getValidator();
    }
}
