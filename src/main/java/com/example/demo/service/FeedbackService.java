package com.example.demo.service;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Show;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getFeedbackList();
    List<Feedback> getFeedbackByUserId(String userId);
    boolean addFeedback(Feedback feedback);
    boolean deleteFeedback(int feedbackId);
    PageInfo<Feedback> pageQuery(Integer feedbackId, String feedbackType, String feedback, int pageNum, int pageSize);


}
