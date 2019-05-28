package com.sleep.owl.web.webcore.module.museum.model;

import com.sleep.owl.web.webcore.base.model.MarkDeleteableModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class MuseumGroup extends MarkDeleteableModel<String> {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
}
