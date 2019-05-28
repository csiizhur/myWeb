package com.sleep.owl.web.webcore.base.model;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseModel<ID extends Serializable> implements BaseModel<ID> {
    private static final long serialVersionUID = 1195969732659409799L;
    /**
     * 主键使用uuid ...需要确认和更改,公共字段的生成属性信息
     */
 /*   @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false)
    protected String id;*/
    //创建时间
    @CreatedDate
    private Date createTime;
    // 创建人
    protected String createUser;
    // 创建人id
    private String createUserId;
    //更新人
    private String modifier;
    //更新时间
    @LastModifiedDate
    private Date modifyTime;
    //更新人id
    private String modifierId;

}
