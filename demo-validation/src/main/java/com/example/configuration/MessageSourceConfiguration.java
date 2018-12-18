package com.example.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

public class MessageSourceConfiguration {

    @Bean
    public MessageSource messageSource() {
        new ResourceBundleMessageSource();
        new ReloadableResourceBundleMessageSource();
        return null;
    }
}
