package com.prashant.banking.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Ownership checks used from @PreAuthorize, e.g.
 * {@code @PreAuthorize("hasAuthority('ACCOUNT_READ') and @accountSecurity.isOwner(authentication, #accountId)")}.
 */
@Component("accountSecurity")
public class AccountSecurity {

    /** TODO(write by hand): look up the account and compare its customer's user id with the JWT subject. */
    public boolean isOwner(Authentication authentication, Object accountPublicId) {
        return false; // deny by default until implemented
    }
}
