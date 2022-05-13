package com.aynu.dao;


import com.aynu.entity.TbDoc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Mapper
@Repository
public interface TbDocDao extends BaseMapper<TbDoc> {

    @Select("select * from tb_doc where pid = #{pid}")
    Vector<TbDoc> selectByPid(Integer pid);

    @Insert("insert into tb_doc(pid,name,type) values(#{tbDoc.pid},#{tbDoc.name},#{tbDoc.type})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer add(@Param("tbDoc") TbDoc tbDoc);

}
