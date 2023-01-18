package id.web.ilham.dmp.adaptor.dans;

import id.web.ilham.dmp.adaptor.dans.model.DansApi;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "dansmultipro")
public class DansConfig {

    private Integer connectionRequestTimeout;

    private Integer connectTimeout;

    private Integer readTimeout;

    private String userId;

    private String apiKey;

    private DansApi api;
}
