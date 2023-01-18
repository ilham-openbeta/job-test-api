package id.web.ilham.dmp.controller;

import id.web.ilham.dmp.model.job.GetJobDetailRequest;
import id.web.ilham.dmp.model.job.GetJobDetailResponse;
import id.web.ilham.dmp.model.job.GetJobListResponse;
import id.web.ilham.dmp.service.job.GetJobDetailService;
import id.web.ilham.dmp.service.job.GetJobListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
public class JobController {

    private final GetJobListService getJobListService;
    private final GetJobDetailService getJobDetailService;

    @Operation(summary = "List Job Position", description = "List Job Position", tags = {"job"}, security = @SecurityRequirement(name = "bearerAuth"))
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/list")
    public GetJobListResponse getJobs() {
        return getJobListService.execute();
    }

    @Operation(summary = "Job Detail", description = "Job Detail", tags = {"job"}, security = @SecurityRequirement(name = "bearerAuth"))
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/detail/{id}")
    public GetJobDetailResponse getJobDetail(@PathVariable String id) {
        return getJobDetailService.execute(GetJobDetailRequest.builder().id(id).build());
    }
}
