package com.publiccms.logic.dao.sys;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

// Generated 2023-8-4 9:33:28 by com.publiccms.common.generator.SourceGenerator

import org.springframework.stereotype.Repository;

import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.QueryHandler;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.entities.sys.SysUserAttribute;

/**
 *
 * SysUserAttributeDao
 * 
 */
@Repository
public class SysUserAttributeDao extends BaseDao<SysUserAttribute> {

    /**
     * @param ids
     * @return results list
     */
    public List<SysUserAttribute> getEntitysWithoutText(Serializable[] ids) {
        if (CommonUtils.notEmpty(ids)) {
            QueryHandler queryHandler = getQueryHandler(
                    "select new SysUserAttribute(userId, certificationIds, data) from SysUserAttribute bean");
            queryHandler.condition("bean.userId in (:ids)").setParameter("ids", ids);
            return getEntityList(queryHandler);
        }
        return Collections.emptyList();
    }

    @Override
    protected SysUserAttribute init(SysUserAttribute entity) {
        if (CommonUtils.empty(entity.getCertificationIds())) {
            entity.setCertificationIds(null);
        }
        if (CommonUtils.empty(entity.getFollowUserIds())) {
            entity.setFollowUserIds(null);
        }
        return entity;
    }

}