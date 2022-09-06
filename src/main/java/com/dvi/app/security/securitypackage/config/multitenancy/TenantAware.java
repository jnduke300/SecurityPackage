package com.dvi.app.security.securitypackage.config.multitenancy;

public interface TenantAware {

    String getTenantId();

    void setTenantId(String tenantId);
}
