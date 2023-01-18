package id.web.ilham.dmp.model.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PostLoginResponse implements Serializable {
    private final List<String> roles;
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;

    public PostLoginResponse(String accessToken, String id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
