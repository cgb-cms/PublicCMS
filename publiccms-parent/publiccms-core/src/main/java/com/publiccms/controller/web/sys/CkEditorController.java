package com.publiccms.controller.web.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.publiccms.common.base.AbstractCkEditorController;
import com.publiccms.common.constants.CommonConstants;
import com.publiccms.common.tools.ControllerUtils;
import com.publiccms.entities.sys.SysSite;
import com.publiccms.entities.sys.SysUser;
import com.publiccms.logic.component.site.LockComponent;
import com.publiccms.logic.service.log.LogLoginService;

/**
 *
 * CkEditorController
 * 
 */
@Controller
@RequestMapping("ckeditor")
public class CkEditorController extends AbstractCkEditorController {
    @Resource
    private LockComponent lockComponent;

    /**
     * @param site
     * @param user
     * @param upload
     * @param ckCsrfToken
     * @param csrfToken
     * @param request
     * @return view name
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> upload(@RequestAttribute SysSite site, @SessionAttribute SysUser user, MultipartFile upload,
            String ckCsrfToken, @CookieValue("ckCsrfToken") String csrfToken, HttpServletRequest request) {
        boolean locked = lockComponent.isLocked(site.getId(), LockComponent.ITEM_TYPE_FILEUPLOAD, String.valueOf(user.getId()),
                null);
        lockComponent.lock(site.getId(), LockComponent.ITEM_TYPE_FILEUPLOAD, String.valueOf(user.getId()), null, true);

        Map<String, Object> messageMap = new HashMap<>();
        if (ControllerUtils.errorCustom("locked.user", locked, messageMap)) {
            Map<String, Object> result = new HashMap<>();
            result.put(CommonConstants.ERROR, messageMap);
            return result;
        } else if (ControllerUtils.errorCustom("locked.size",
                lockComponent.isLocked(site.getId(), LockComponent.ITEM_TYPE_FILEUPLOAD_SIZE, String.valueOf(user.getId()), null),
                messageMap)) {
            Map<String, Object> result = new HashMap<>();
            result.put(CommonConstants.ERROR, messageMap);
            return result;
        }
        return upload(site, user, upload, ckCsrfToken, csrfToken, LogLoginService.CHANNEL_WEB, request);
    }
}
