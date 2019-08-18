package com.cry.forum.mapper;

import com.cry.forum.model.File;
import org.apache.ibatis.annotations.Select;
import util.MyMapper;

import java.util.List;

public interface FileMapper extends MyMapper<File> {

    @Select("select * from file t where t.biz_id=#{bizId}")
    public List<File> queryByBizId(String bizId);
}