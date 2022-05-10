package com.publiccms.views.directive.tools;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.handler.RenderHandler;
import com.publiccms.common.tools.CommonUtils;
import com.publiccms.entities.sys.SysSite;
import com.publiccms.logic.component.template.DiyComponent;

/**
 *
 * DiyMetadataListDirective diy元数据列表获取
 * 参数列表：
 * itemType 元数据类型 可选值 region,layout,module 结果项 list 为diy元数据列表
 * 
 */
@Component
public class DiyMetadataListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        SysSite site = getSite(handler);
        String itemType = handler.getString("itemType");
        if (CommonUtils.notEmpty(itemType)) {
            if ("region".equalsIgnoreCase(itemType)) {
                handler.put("list", diyComponent.getRegionList(site)).render();
            } else if ("layout".equalsIgnoreCase(itemType)) {
                handler.put("list", diyComponent.getLayoutList(site)).render();
            } else if ("module".equalsIgnoreCase(itemType)) {
                handler.put("list", diyComponent.getModuleList(site)).render();
            }
        }
    }

    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private DiyComponent diyComponent;
}