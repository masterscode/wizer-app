package com.library.configurations.security;

public class SecurityAuthConstants {
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000;
    public static final String[] PUBLIC_URIS = new String[]{
            "/v1/login",
            "/v1/register"
    };
}
