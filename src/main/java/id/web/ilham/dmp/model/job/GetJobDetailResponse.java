package id.web.ilham.dmp.model.job;

import id.web.ilham.dmp.adaptor.dans.model.PositionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetJobDetailResponse {
    PositionDto job;
}
