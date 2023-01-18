package id.web.ilham.dmp.service.job;

import id.web.ilham.dmp.adaptor.dans.DansAdaptor;
import id.web.ilham.dmp.adaptor.dans.model.GetPositionDetailRequest;
import id.web.ilham.dmp.adaptor.dans.model.PositionDto;
import id.web.ilham.dmp.model.job.GetJobDetailRequest;
import id.web.ilham.dmp.model.job.GetJobDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetJobDetailService {
    private final DansAdaptor dansAdaptor;

    public GetJobDetailResponse execute(GetJobDetailRequest getJobDetailRequest) {
        PositionDto job = dansAdaptor.getPositionDetail(GetPositionDetailRequest.builder()
                .id(getJobDetailRequest.getId()).build());

        return GetJobDetailResponse.builder()
                .job(job)
                .build();
    }

}
