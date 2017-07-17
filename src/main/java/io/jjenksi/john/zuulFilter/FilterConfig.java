package io.jjenksi.john.zuulFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by johnjenkins on 7/17/17.
 * This config class is for configuring the filter methods
 */
@Configuration
public class FilterConfig {

    @Bean
    public AddRequestHeaderFilter addRequestHeaderFilter(){
        return new AddRequestHeaderFilter();
    }
}
