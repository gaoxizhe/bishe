package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Notice;
@Repository("adminNoticeDao")
@Mapper
public interface AdminNoticeDao {
    //1.5.9 公告管理
    public int addNotice(Notice notice);
    public List<Notice> deleteNoticeSelect();
    public int deleteNotice(Integer id);
    public Notice selectANotice(Integer id);
}