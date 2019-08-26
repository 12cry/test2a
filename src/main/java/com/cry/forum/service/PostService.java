package com.cry.forum.service;

import com.cry.forum.mapper.*;
import com.cry.forum.model.File;
import com.cry.forum.model.Post;
import com.cry.forum.model.User;
import com.cry.forum.model.UserPost;
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
    @Autowired
    UserPostMapper userPostMapper;

    public void appreciate(UserPost userPost) {

        String userId = Request.getCurrentUserId();
        userPostMapper.saveOrUpdate(userId, userPost.getPostId(), userPost.getAppreciate());

    }

    public List<PostVO> query(Post post) {
        if (post.getPage() != null && post.getRows() != null) {
            PageHelper.startPage(post.getPage(), post.getRows()).setOrderBy("create_time desc");
        }

        String userId = Request.getCurrentUserId();
        List<PostVO> list = postMapper.query(userId);
        for (PostVO o : list) {
            List<CommentVO> commentVOList = commentMapper.queryByTargetId(userId,o.getId());
            o.setCommentVOList(commentVOList);
            List<File> fileList = fileMapper.queryByBizId(o.getId());
            o.setFileList(fileList);

        }
        return list;
    }

    public PostVO save(Post post) {
        Date now = new Date();

        String userId = Request.getCurrentUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        post.setCreateTime(now);
        post.setUserId(userId);
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
        BeanUtils.copyProperties(user, postVO);
        BeanUtils.copyProperties(post, postVO);
        return postVO;


    }
}
