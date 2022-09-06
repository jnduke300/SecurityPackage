package com.dvi.app.security.securitypackage.models;

import com.dvi.app.security.securitypackage.config.multitenancy.TenantAware;
import com.dvi.app.security.securitypackage.config.multitenancy.TenantListener;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
@EntityListeners(TenantListener.class)
public abstract class BaseEntity implements TenantAware, Serializable {

    @Column(name = "tenant_id", columnDefinition = "default 0", nullable = false)
    private String tenantId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;
}
