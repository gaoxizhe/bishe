package com.example.dao;/**
 * @author : Mr.Gao
 * @date :   2021/3/23 下午10:16
 */

import com.example.model.Profession;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProFessionDao
 * @Author Mr.Gao
 * @Date 2021/3/23 下午10:16
 * @Description TODO | 
 */
@Repository
public interface ProFessionDao {
    List<Profession> getProfessionPageList();

    Profession getProfessionById(@Param("id") Integer id);

    void insertProfession(@Param( "name") String name);

    void updateProfessionById(@Param("id") Integer id,@Param("name") String name);

    void deleteProfessionById(@Param("id") Integer id);
}
