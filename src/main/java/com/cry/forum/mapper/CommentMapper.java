package com.cry.forum.mapper;

import com.cry.forum.model.Comment;
import com.cry.forum.vo.CommentVO;
import org.apache.ibatis.annotations.Select;
import util.MyMapper;

import java.util.List;

public interface CommentMapper extends MyMapper<Comment> {

    @Select("select * from comment t")
    List<Comment> test();


    List<CommentVO> queryByTargetId(String userId,String targetId);
    List<CommentVO> queryByPid(String pid);
}