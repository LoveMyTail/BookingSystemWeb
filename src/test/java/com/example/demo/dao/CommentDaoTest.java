package com.example.demo.dao;

import com.example.demo.entity.Comment;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Test
    @Ignore
    public void queryComment(){
        List<Comment> commentList = commentDao.queryComment();
        assertEquals(1 ,commentList.size());
    }

    @Test
    @Ignore
    public void queryCommentByShowId(){
        List<Comment> commentList = commentDao.queryCommentByShowId(1);
        assertEquals(1 ,commentList.size());
    }

    @Test
    @Ignore
    public void queryCommentByUserId(){
        List<Comment> commentList = commentDao.queryCommentByUserId("oFe8-5ZI2e5s1yJZdp0GkBDFkXFY");
        assertEquals(1 ,commentList.size());
    }

    @Test
    @Ignore
    public void insertComment(){
        Comment comment = new Comment();
        comment.setShowId(2);
        comment.setUserId("oFe8-5ZI2e5s1yJZdp0GkBDFkXFY");
        comment.setComment("一般般");
        int effectedNum = commentDao.insertComment(comment);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteComment(){
        int effectedNum = commentDao.deleteComment(2);
        assertEquals(1,effectedNum);
    }
}
