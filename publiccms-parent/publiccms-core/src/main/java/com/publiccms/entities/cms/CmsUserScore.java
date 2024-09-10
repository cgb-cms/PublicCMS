package com.publiccms.entities.cms;
// Generated 2020-3-26 11:25:55 by Hibernate Tools 6.0.0-SNAPSHOT

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * CmsUserStar generated by hbm2java
 */
@Entity
@Table(name = "cms_user_score")
@DynamicUpdate
public class CmsUserScore implements java.io.Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @GeneratorColumn(title = "ID")
    private CmsUserScoreId id;
    /**
     * score

     * 分数
     */
    @GeneratorColumn(title = "分数", order = true)
    private int score;
    /**
     * ip
     */
    @GeneratorColumn(title = "IP")
    private String ip;
    /**
     * create date

     * 创建日期
     */
    @GeneratorColumn(title = "创建日期")
    private Date createDate;

    public CmsUserScore() {
    }

    public CmsUserScore(CmsUserScoreId id, int score, String ip, Date createDate) {
        this.id = id;
        this.score = score;
        this.ip = ip;
        this.createDate = createDate;
    }

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
            @AttributeOverride(name = "itemType", column = @Column(name = "item_type", nullable = false, length = 50)),
            @AttributeOverride(name = "itemId", column = @Column(name = "item_id", nullable = false)) })
    public CmsUserScoreId getId() {
        return this.id;
    }

    public void setId(CmsUserScoreId id) {
        this.id = id;
    }

    @Column(name = "score", nullable = false)
    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Column(name = "ip", nullable = false, length = 130)
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
