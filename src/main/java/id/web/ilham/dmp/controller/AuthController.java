package id.web.ilham.dmp.controller;

import id.web.ilham.dmp.model.auth.PostLoginRequest;
import id.web.ilham.dmp.model.auth.PostLoginResponse;
import id.web.ilham.dmp.model.auth.PostRegisterRequest;
import id.web.ilham.dmp.service.auth.PostLoginService;
import id.web.ilham.dmp.service.auth.PostRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

    private final PostRegisterService postRegisterService;

    private final PostLoginService postLoginService;

    @Operation(summary = "Request token", description = "Request token with username and password", tags = {"authentication"})
    @PostMapping(value = "/login", produces = "application/json")
    public PostLoginResponse postLogin(@Valid @RequestBody PostLoginRequest postLoginRequest) {
        return postLoginService.execute(postLoginRequest);
    }

    @Operation(
            summary = "Create a new user account",
            description = "Create a new user account to give data editing access from API.",
            tags = {"authentication"})
    @PostMapping(value = "/register", produces = "application/json")
    public void postRegister(@Valid @RequestBody PostRegisterRequest signUpRequest) {
        postRegisterService.execute(signUpRequest);
    }

}
