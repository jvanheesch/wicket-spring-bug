package com.mycompany;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public WicketApplication wicketApplication() {
        return new WicketApplication();
    }

    @Bean
    public SomeService securityEnvelopeFetcher() {
        return new SomeService("abc");
    }
}
