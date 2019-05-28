package com.sleep.owl.web.webcore.module.museum.model;

import com.sleep.owl.web.webcore.base.model.MarkDeleteableModel;
import com.sleep.owl.web.webcore.module.museum.model.enums.Type;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Museum extends MarkDeleteableModel<String> {
    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    @Column(name = "id", nullable = false)
    private String id;
    /**
     * 菜单需要展示的名称
     */
    private String name;
    /**
     * 类型
     */
    @Enumerated(EnumType.STRING)
    private Type type;
    /**
     * 序号,指在当前兄弟中的排序
     */
    private Integer orderIndex;
    /**
     * 父目录
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Museum parent;
    /**
     * 子目录 , 便于遍历和递归使用LinkedList
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private List<Museum> children = new LinkedList<>();
    /**
     * 是否是跟目录,根据是否是根目录,做一些判断 , 跟目录无法删除,无法调换顺序
     */
    private boolean rootNode;
    /**
     * 图标
     */
    private String icon;
    /**
     * 标题
     */
    private String title;
    /**
     * 组信息
     */
    private String groupTitle;
    /**
     * 组标题
     */
    private String groupIcon;

}
