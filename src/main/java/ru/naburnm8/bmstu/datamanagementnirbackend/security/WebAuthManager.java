package ru.naburnm8.bmstu.datamanagementnirbackend.security;


import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;

import java.util.function.Supplier;

public class WebAuthManager implements AuthorizationManager<AuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, AuthorizationContext context) {
        context.getVariables();
        return null;
    }
}
