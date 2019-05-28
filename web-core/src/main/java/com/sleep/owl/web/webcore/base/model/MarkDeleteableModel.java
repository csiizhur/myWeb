package com.sleep.owl.web.webcore.base.model;

import com.sleep.owl.web.webcore.config.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class MarkDeleteableModel<ID extends Serializable> extends AbstractBaseModel<ID> {
    @Column(name = "del", columnDefinition = "tinyint default 0")
    private int del = Constants.DEL_NO;
}
