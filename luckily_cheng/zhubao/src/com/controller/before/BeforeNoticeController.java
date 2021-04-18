package com.controller.before;

import com.controller.before.BaseBeforeController;
import com.po.Notice;
import com.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeforeNoticeController {
    ////1.5.9 公告管理
    @Autowired
    private AdminNoticeService adminNoticeService;

    @RequestMapping(value = "/selectANotice" ,produces="text/json;charset=utf-8")
    @ResponseBody
    public String selectANotice(Integer id) {
        return adminNoticeService.selectANotice(id);
    }
}