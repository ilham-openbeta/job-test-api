package id.web.ilham.dmp.adaptor.dans;

import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.util.Timeout;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class DansRestConfig {

    private final DansConfig dansConfig;
    private final PoolingHttpClientConnectionManager defaultPoolingHttpClientConnectionManager;

    @Bean
    public RestTemplate dansRestTemplate() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(dansConfig.getConnectionRequestTimeout()))
                .setConnectTimeout(Timeout.ofMilliseconds(dansConfig.getConnectTimeout()))
                .setResponseTimeout(Timeout.ofMilliseconds(dansConfig.getReadTimeout()))
                .build();

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(defaultPoolingHttpClientConnectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplateBuilder()
                .requestFactory(() -> factory)
                .build();
    }
}
