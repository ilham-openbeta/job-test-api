package id.web.ilham.dmp.config;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.hc.client5.http.HttpRoute;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.HttpHost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final HttpHostsConfig httpHostsConfig;

    @Bean
    public PoolingHttpClientConnectionManager defaultPoolingHttpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(httpHostsConfig.getMaxTotal());
        connectionManager.setDefaultMaxPerRoute(httpHostsConfig.getDefaultMaxPerRoute());

        if (CollectionUtils.isNotEmpty(httpHostsConfig.getMaxPerRoutes())) {
            for (HttpHostsConfig.HttpHostConfiguration httpHostConfig : httpHostsConfig.getMaxPerRoutes()) {
                HttpHost host = new HttpHost(httpHostConfig.getScheme(), httpHostConfig.getHost(), httpHostConfig.getPort());
                connectionManager.setMaxPerRoute(new HttpRoute(host), httpHostConfig.getMaxPerRoute());
            }
        }

        return connectionManager;
    }
}
