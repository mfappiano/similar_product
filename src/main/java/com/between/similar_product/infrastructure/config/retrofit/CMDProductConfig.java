package com.between.similar_product.infrastructure.config.retrofit;

import com.between.similar_product.data.api.CMDProductRestClient;
import com.between.similar_product.infrastructure.config.RetrofitRestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "services-api.cmd.product")
@Slf4j
@AllArgsConstructor
public class CMDProductConfig extends RetrofitRestClient<CMDProductRestClient> {

    @Bean
    public CMDProductRestClient commandShoppingCartRestClient(
            ObjectMapper objectMapper
    ) {
        log.info(String.format("Create cmd product endpoint URL: %s",
                this.baseUrl));
        return this.restClient(
                objectMapper,
                CMDProductRestClient.class
        );
    }
}
