package id.web.ilham.dmp.model.job;

import id.web.ilham.dmp.adaptor.dans.model.PositionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetJobListResponse implements Serializable {
    List<PositionDto> jobs;
}
