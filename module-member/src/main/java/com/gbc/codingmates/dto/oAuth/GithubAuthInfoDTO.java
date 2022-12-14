package com.gbc.codingmates.dto.oAuth;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GithubAuthInfoDTO extends AuthInfoDTO {

    private String email;
    private String id;
    private String accessToken;

    @Override
    void checkIdIsNull() {
        if (ObjectUtils.isEmpty(id)) {
            throw new IllegalArgumentException("Github OAuth User Info don't have id value");
        }
    }

    @Override
    void checkAccessTokenIsNull() {
        if (ObjectUtils.isEmpty(accessToken)) {
            throw new IllegalArgumentException(
                "Github OAuth User Info don't have accessToken value");
        }
    }

    @Override
    public String getAuthUserId() {
        checkIdIsNull();
        return String.valueOf(id);
    }

    @Override
    public String getAccessToken() {
        checkAccessTokenIsNull();
        return accessToken;
    }

    public void saveAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void saveEmail(String email) {
        this.email = email;
    }
}
