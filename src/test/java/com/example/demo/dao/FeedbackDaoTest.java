package com.example.demo.dao;

import com.example.demo.entity.Feedback;
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
public class FeedbackDaoTest {
    @Autowired
    private FeedbackDao feedbackDao;

    @Test
    @Ignore
    public void queryFeedback(){
        List<Feedback> feedbackList = feedbackDao.queryFeedback();
        assertEquals(1 ,feedbackList.size());
    }

    @Test
    @Ignore
    public void queryFeedbackByUserId(){
        List<Feedback> feedbackList = feedbackDao.queryFeedbackByUserId("oFe8-5ZI2e5s1yJZdp0GkBDFkXFY");
        assertEquals(1 ,feedbackList.size());
    }

    @Test

    public void insertFeedback(){
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(2);
        feedback.setUserId("oFe8-5ZI2e5s1yJZdp0GkBDFkXFY");
        feedback.setFeedbackType("建议");
        feedback.setFeedback("希望页面可以做的更好看一些");
        int effectedNum = feedbackDao.insertFeedback(feedback);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void deleteFeedback(){
        int effectedNum = feedbackDao.deleteFeedback(1);
        assertEquals(1,effectedNum);
    }
}
