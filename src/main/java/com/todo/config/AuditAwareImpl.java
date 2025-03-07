package com.todo.config;

import java.util.Objects;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.AuditorAware;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder
            .getContext()
            .getAuthentication();
        if (Objects.nonNull(authentication) && authentication.isAuthenticated()) {
            return Optional.of(authentication.getName());
        }
        return Optional.of("NotAuthEditor");
    }
}
