package com.zl.fileconfig;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class FeignSupportConfig {

        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }


}
