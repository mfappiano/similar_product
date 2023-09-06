package com.between.similar_product.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrofitRestClient<T> {
    protected String baseUrl;
    protected long connectTimeout;
    protected long readTimeout;
    protected long writeTimeout;
    protected int maxRequest;

    public T restClient(
            ObjectMapper objectMapper,
            Class<T> retrofitInterface) {

        return new Retrofit.Builder()
                .client(new RestClientConfig()
                        .getHttpClient(maxRequest, connectTimeout,
                                readTimeout, writeTimeout))
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper)).build()
                .create(retrofitInterface);
    }
}
