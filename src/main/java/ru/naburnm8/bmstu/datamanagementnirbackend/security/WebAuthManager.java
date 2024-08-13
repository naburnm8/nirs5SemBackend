package ru.naburnm8.bmstu.datamanagementnirbackend.security;


import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.server.authorization.AuthorizationContext;

import java.util.Map;
import java.util.function.Supplier;

public class WebAuthManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        String authorities = authentication.get().getAuthorities().toString();
        if (authorities.contains("ADMINISTRATOR")) {
            return new AuthorizationDecision(true);
        }
        return new AuthorizationDecision(false);
    }
}
