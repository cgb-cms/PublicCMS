package com.publiccms.entities.sys;
// Generated 2022-2-9 10:19:58 by Hibernate Tools 5.4.32.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.publiccms.common.generator.annotation.GeneratorColumn;

/**
 * SysLockId generated by hbm2java
 */
@Embeddable
public class SysLockId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratorColumn(title = "站点", condition = true)
    @JsonIgnore
    private short siteId;
    /**
     * item type<p>
     * 项目类型
     */
    @GeneratorColumn(title = "项目类型", condition = true)
    @NotNull
    @Length(max = 50)
    private String itemType;
    /**
     * item id<p>
     * 项目id
     */
    @GeneratorColumn(title = "项目")
    @NotNull
    @Length(max = 130)
    private String itemId;

    public SysLockId() {
    }

    public SysLockId(short siteId, String itemType, String itemId) {
       this.siteId = siteId;
       this.itemType = itemType;
       this.itemId = itemId;
    }

    @Column(name="site_id", nullable=false)
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

    @Column(name = "item_id", nullable = false, length = 130)
    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof SysLockId) ) return false;
        SysLockId castOther = ( SysLockId ) other; 
        
        return (this.getSiteId()==castOther.getSiteId())
&& ( (this.getItemType()==castOther.getItemType()) || ( this.getItemType()!=null && castOther.getItemType()!=null && this.getItemType().equals(castOther.getItemType()) ) )
&& ( (this.getItemId()==castOther.getItemId()) || ( this.getItemId()!=null && castOther.getItemId()!=null && this.getItemId().equals(castOther.getItemId()) ) );
  }
  
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + this.getSiteId();
        result = 37 * result + ( getItemType() == null ? 0 : this.getItemType().hashCode() );
        result = 37 * result + ( getItemId() == null ? 0 : this.getItemId().hashCode() );
        return result;
  }   

}
