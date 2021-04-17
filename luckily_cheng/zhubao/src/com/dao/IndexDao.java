package com.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.po.Goods;

@Repository("indexDao")
@Mapper
public interface IndexDao {
    //1.6 前台电子商务子系统的实现
    public List<Map<String, Object>> getSaleOrder();
    public List<Map<String, Object>> getFocusOrder();
    public List<Map<String, Object>> selectNotice();
    public List<Map<String, Object>> getLastedGoods(Goods goods);
    //1.6.8  商品详情
    public Goods selectGoodsById(Integer id);
    public List<Goods> search(String mykey);
}