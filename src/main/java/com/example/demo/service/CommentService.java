package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentList();
    List<Comment> getCommentByUserId(String userId);
    List<Comment> getCommentByShowId(int showId);
    boolean addComment(Comment comment);
    boolean deleteComment(int commentId);

}
