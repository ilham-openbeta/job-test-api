package id.web.ilham.dmp.adaptor.dans;

import id.web.ilham.dmp.adaptor.dans.model.GetPositionDetailRequest;
import id.web.ilham.dmp.adaptor.dans.model.GetPositionDetailResponse;
import id.web.ilham.dmp.adaptor.dans.model.GetPositionsResponse;
import id.web.ilham.dmp.adaptor.dans.model.PositionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DansAdaptor {

    private final RestTemplate dansRestTemplate;

    private final DansConfig dansConfig;

    public GetPositionsResponse getPositions() {
        ResponseEntity<List<PositionDto>> responseEntity =  dansRestTemplate.exchange(
                dansConfig.getApi().getList(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return GetPositionsResponse.builder()
                .jobs(responseEntity.getBody())
                .build();
    }

    public GetPositionDetailResponse getPositionDetail(GetPositionDetailRequest getPositionDetailRequest) {
        Map<String, String> params = new HashMap<>();
        params.put("ID", getPositionDetailRequest.getId());

        return dansRestTemplate.exchange(
                dansConfig.getApi().getDetail(),
                HttpMethod.GET,
                null,
                GetPositionDetailResponse.class,
                params
        ).getBody();
    }
}
