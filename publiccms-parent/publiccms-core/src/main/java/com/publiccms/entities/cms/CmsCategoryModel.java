package com.publiccms.entities.cms;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;

// Generated 2016-1-19 11:28:06 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsCategoryModel generated by hbm2java
 */
@Entity
@Table(name = "cms_category_model")
@DynamicUpdate
public class CmsCategoryModel implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private CmsCategoryModelId id;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    /**
     * custom content path

     * 自定义内容访问路径
     */
    private boolean customContentPath;
    /**
     * template path

     * 模板路径
     */
    @GeneratorColumn(title = "模板路径")
    private String templatePath;
    /**
     * content path

     * 内容路径
     */
    @GeneratorColumn(title = "内容路径")
    private String contentPath;

    public CmsCategoryModel() {
    }

    public CmsCategoryModel(CmsCategoryModelId id, short siteId, boolean customContentPath) {
        this.id = id;
        this.siteId = siteId;
        this.customContentPath = customContentPath;
    }

    public CmsCategoryModel(CmsCategoryModelId id, short siteId, boolean customContentPath, String templatePath, String contentPath) {
        this.id = id;
        this.siteId = siteId;
        this.customContentPath = customContentPath;
        this.templatePath = templatePath;
        this.contentPath = contentPath;
    }

    @EmbeddedId

    @AttributeOverrides({ @AttributeOverride(name = "categoryId", column = @Column(name = "category_id", nullable = false)),
            @AttributeOverride(name = "modelId", column = @Column(name = "model_id", nullable = false, length = 20)) })
    public CmsCategoryModelId getId() {
        return this.id;
    }

    public void setId(CmsCategoryModelId id) {
        this.id = id;
    }

    @Column(name = "site_id", nullable = false)
    public short getSiteId() {
        return this.siteId;
    }

    public void setSiteId(short siteId) {
        this.siteId = siteId;
    }

    @Column(name = "custom_content_path", nullable = false)
    public boolean isCustomContentPath() {
        return this.customContentPath;
    }

    public void setCustomContentPath(boolean customContentPath) {
        this.customContentPath = customContentPath;
    }

    @Column(name = "template_path", length = 200)
    public String getTemplatePath() {
        return this.templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    @Column(name = "content_path", length = 1000)
    public String getContentPath() {
        return this.contentPath;
    }

    public void setContentPath(String contentPath) {
        this.contentPath = contentPath;
    }
}
