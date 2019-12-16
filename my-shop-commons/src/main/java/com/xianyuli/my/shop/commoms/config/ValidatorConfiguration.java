package com.xianyuli.my.shop.commoms.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @ClassName: ValidatorConfiguration
 * @Description: java类作用描述
 * @Author: LW
 */
@Configuration
public class ValidatorConfiguration {
    @Bean("validator")
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
