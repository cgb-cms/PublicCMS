package com.publiccms.entities.cms;
// Generated 2022-5-10 13:57:30 by Hibernate Tools 5.6.2.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsEditorHistory generated by hbm2java
 */
@Entity
@Table(name = "cms_editor_history")
@DynamicUpdate
public class CmsEditorHistory implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private Long id;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    /**
     * item type
     * <p>
     * 项目类型
     */
    @GeneratorColumn(title = "项目类型", condition = true)
    @NotNull
    @Length(max = 100)
    private String itemType;
    /**
     * item id
     * <p>
     * 项目id
     */
    @GeneratorColumn(title = "项目id", condition = true)
    @NotNull
    @Length(max = 100)
    private String itemId;
    /**
     * field name
     * <p>
     * 字段名
     */
    @GeneratorColumn(title = "字段名", condition = true)
    private String fieldName;
    /**
     * create date
     * <p>
     * 创建日期
     */
    @GeneratorColumn(title = "创建日期", order = true)
    private Date createDate;
    /**
     * user id
     * <p>
     * 用户
     */
    @GeneratorColumn(title = "用户", condition = true)
    private long userId;
    /**
     * content text
     * <p>
     * 正文内容
     */
    @GeneratorColumn(title = "内容")
    private String text;

    public CmsEditorHistory() {
    }

    public CmsEditorHistory(Long id, short siteId, String itemType, String itemId, String fieldName, Date createDate,
            long userId) {
        this.id = id;
        this.siteId = siteId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.fieldName = fieldName;
        this.createDate = createDate;
        this.userId = userId;
    }

    public CmsEditorHistory(short siteId, String itemType, String itemId, String fieldName, Date createDate, long userId,
            String text) {
        this.siteId = siteId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.fieldName = fieldName;
        this.createDate = createDate;
        this.userId = userId;
        this.text = text;
    }

    @Id
    @GeneratedValue(generator = "cmsGenerator")
    @GenericGenerator(name = "cmsGenerator", strategy = CmsUpgrader.IDENTIFIER_GENERATOR)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "item_type", nullable = false, length = 50)
    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Column(name = "item_id", nullable = false, length = 100)
    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "field_name", nullable = false, length = 50)
    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "text", nullable = false)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
