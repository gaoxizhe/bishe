package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Goods;
import com.po.GoodsType;
@Repository("adminTypeDao")
@Mapper
public interface AdminTypeDao {
    //1.5.2 类型管理
    //类型管理分为添加类型和删除类型。
    public List<GoodsType> selectGoodsType();
    public int addType(String typename);
    public int deleteType(Integer id);
    public List<Goods> selectGoodsByType(Integer id); }