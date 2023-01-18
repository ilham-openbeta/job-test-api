package id.web.ilham.dmp.service.job;

import id.web.ilham.dmp.adaptor.dans.DansAdaptor;
import id.web.ilham.dmp.adaptor.dans.model.PositionDto;
import id.web.ilham.dmp.model.job.GetJobListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetJobListService {
    private final DansAdaptor dansAdaptor;

    public GetJobListResponse execute() {
        List<PositionDto> jobs = dansAdaptor.getPositions().getJobs();

        return GetJobListResponse.builder()
                .jobs(jobs)
                .build();
    }

}
