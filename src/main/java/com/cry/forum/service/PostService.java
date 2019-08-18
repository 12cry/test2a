package com.cry.forum.service;

import com.cry.forum.mapper.FileMapper;
import com.cry.forum.mapper.PostMapper;
import com.cry.forum.model.Comment;
import com.cry.forum.model.File;
import com.cry.forum.model.Post;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    @Autowired
    FileMapper fileMapper;

    public List<Post> query(Post post) {
        if (post.getPage() != null && post.getRows() != null) {
            PageHelper.startPage(post.getPage(), post.getRows()).setOrderBy("create_time desc");
        }
        List<Post> list = postMapper.query();
        for (Post o : list) {
            List<Comment> commentList = postMapper.queryCommentList(o.getId());
            o.setCommentList(commentList);
            List<File> fileList = fileMapper.queryByBizId(o.getId());
            o.setFileList(fileList);

        }
        return list;
    }

    public List<Post> test(Post post) {
        if (post.getPage() != null && post.getRows() != null) {
            PageHelper.startPage(post.getPage(), post.getRows()).setOrderBy("create_time desc");
        }

        List list = postMapper.query();
        return list;
    }

    public List<Post> getAll(Post post) {
        if (post.getPage() != null && post.getRows() != null) {
            PageHelper.startPage(post.getPage(), post.getRows()).setOrderBy("create_time desc");
        }
        return postMapper.selectAll();
    }

    public Post getById(Integer id) {
        return postMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        postMapper.deleteByPrimaryKey(id);
    }

    public void save(Post post) {

        post.setCreateTime(new Date());
        int insert = postMapper.insert(post);


        List<File> fileList = post.getFileList();

        Date now = new Date();
        if (fileList!=null&&!fileList.isEmpty()) {

            for (File file:fileList){
                file.setCreateTime(now);
                file.setBizId(post.getId());
            }
            fileMapper.insertList(post.getFileList());
        }
    }
}
