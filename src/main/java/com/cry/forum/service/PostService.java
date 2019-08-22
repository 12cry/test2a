package com.cry.forum.service;

import com.cry.forum.mapper.CommentMapper;
import com.cry.forum.mapper.FileMapper;
import com.cry.forum.mapper.PostMapper;
import com.cry.forum.mapper.UserMapper;
import com.cry.forum.model.File;
import com.cry.forum.model.Post;
import com.cry.forum.model.User;
import com.cry.forum.vo.CommentVO;
import com.cry.forum.vo.PostVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Request;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    FileMapper fileMapper;

    public List<PostVO> query(Post post) {
        if (post.getPage() != null && post.getRows() != null) {
            PageHelper.startPage(post.getPage(), post.getRows()).setOrderBy("create_time desc");
        }
        List<PostVO> list = postMapper.query();
        for (PostVO o : list) {
            List<CommentVO> commentVOList = commentMapper.queryByTargetId(o.getId());
            o.setCommentVOList(commentVOList);
            List<File> fileList = fileMapper.queryByBizId(o.getId());
            o.setFileList(fileList);

        }
        return list;
    }

    public PostVO save(Post post) {
        Date now = new Date();

        String openid = Request.getCurrentOpenid();
        User user = userMapper.queryByOpenid(openid);
        post.setCreateTime(now);
        post.setUserId(user.getId());
        postMapper.insert(post);

        List<File> fileList = post.getFileList();
        if (fileList != null && !fileList.isEmpty()) {
            for (File file : fileList) {
                file.setCreateTime(now);
                file.setBizId(post.getId());
                fileMapper.insert(file);
            }
//            fileMapper.insertList(post.getFileList());
        }

        PostVO postVO = new PostVO();
        postVO.setFileList(fileList);
        BeanUtils.copyProperties(post, postVO);
        BeanUtils.copyProperties(user, postVO);
        return postVO;


    }
}
