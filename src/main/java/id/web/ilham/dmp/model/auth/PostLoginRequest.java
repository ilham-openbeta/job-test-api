package id.web.ilham.dmp.model.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PostLoginRequest implements Serializable {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
