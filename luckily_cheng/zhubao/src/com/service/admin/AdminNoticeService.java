package com.service.admin;
import org.springframework.ui.Model;
import com.po.Notice;
public interface AdminNoticeService {
    //1.5.9 公告管理
    public String addNotice(Notice notice);
    public String deleteNoticeSelect(Model model);
    public String selectANotice(Model model, Integer id);
    public String deleteNotice(Integer id);

    public String selectANotice(Integer id);
}