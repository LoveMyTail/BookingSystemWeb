package com.example.demo.service.impl;

import com.example.demo.dao.CommentDao;
import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommentList() {
        return commentDao.queryComment();
    }

    @Override
    public List<Comment> getCommentByUserId(String userId) {
        return commentDao.queryCommentByUserId(userId);
    }

    @Override
    public List<Comment> getCommentByShowId(int showId) {
        return commentDao.queryCommentByShowId(showId);
    }

    @Override
    public boolean addComment(Comment comment) {
        if(comment.getComment()!=null && !"".equals(comment.getComment())){
            try{
                int effectedNum = commentDao.insertComment(comment);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入评论失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入评论失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("评论不能为空！");
        }
    }

    @Override
    public boolean deleteComment(int commentId) {
        if(commentId>0){
            try{
                int effectedNum = commentDao.deleteComment(commentId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除评论失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入评论失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("评论不能为空！");
        }
    }
}
