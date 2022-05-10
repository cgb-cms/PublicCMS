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

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.publiccms.common.database.CmsUpgrader;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsContentTextHistory generated by hbm2java
 */
@Entity
@Table(name = "cms_content_text_history")
@DynamicUpdate
public class CmsContentTextHistory implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratorColumn(title = "ID")
    private Long id;
    @GeneratorColumn(title = "内容", condition = true)
    private long contentId;
    @GeneratorColumn(title = "字段名", condition = true)
    private String fieldName;
    @GeneratorColumn(title = "创建日期", order = true)
    private Date createDate;
    @GeneratorColumn(title = "用户", condition = true)
    private long userId;
    @GeneratorColumn(title = "内容")
    private String text;

    public CmsContentTextHistory() {
    }

    public CmsContentTextHistory(Long id, long contentId, String fieldName, Date createDate, long userId) {
        this.id = id;
        this.contentId = contentId;
        this.fieldName = fieldName;
        this.createDate = createDate;
        this.userId = userId;
    }

    public CmsContentTextHistory(long contentId, String fieldName, Date createDate, long userId, String text) {
        this.contentId = contentId;
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

    @Column(name = "content_id", nullable = false)
    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    @Column(name = "field_name", nullable = false, length = 100)
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