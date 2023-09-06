package com.between.similar_product.data.api.helper;

import com.between.similar_product.domain.constant.GenericConstants;
import com.between.similar_product.domain.exception.NotFoundException;
import com.google.gson.JsonSyntaxException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Optional;

import static com.between.similar_product.domain.constant.RestExceptionMessages.GENERAL_ERROR_LOGGING_MESSAGE;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestHandlerHelper {

    public static <T> T executeCallWithBody(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (!response.isSuccessful() || response.body() == null) {
                log.error(GENERAL_ERROR_LOGGING_MESSAGE, "application", Optional.ofNullable(response.errorBody()).map(responseBody -> {
                    try {
                        return responseBody.string();
                    } catch (IOException e) {
                        return null;
                    }
                }).orElse(null));
                throw new NotFoundException(GenericConstants.UNABLE_TO_PARSE_DATA);
            }
            return response.body();
        } catch (JsonSyntaxException ex) {
            throw new RestClientException(GenericConstants.UNABLE_TO_PARSE_JSON);
        } catch (UnknownHostException | SocketTimeoutException | ConnectException ex) {
            throw new RestClientException(GenericConstants.UNABLE_TO_CONNECT_TO_HOST);
        } catch (IOException ex) {
            throw new RestClientException(GenericConstants.GENERAL_EXCEPTION);
        }
    }

}
