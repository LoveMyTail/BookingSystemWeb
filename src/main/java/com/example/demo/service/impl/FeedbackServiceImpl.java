package com.example.demo.service.impl;

import com.example.demo.dao.FeedbackDao;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Show;
import com.example.demo.service.FeedbackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public List<Feedback> getFeedbackList() {
        return feedbackDao.queryFeedback();
    }

    @Override
    public List<Feedback> getFeedbackByUserId(String userId) {
        return feedbackDao.queryFeedbackByUserId(userId);
    }

    @Override
    public boolean addFeedback(Feedback feedback) {
        if(feedback.getFeedback()!=null && !"".equals(feedback.getFeedback())){
            try{
                int effectedNum = feedbackDao.insertFeedback(feedback);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入意见反馈失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入意见反馈失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("意见反馈不能为空！");
        }
    }

    @Override
    public boolean deleteFeedback(int feedbackId) {
        if(feedbackId>0){
            try{
                int effectedNum = feedbackDao.deleteFeedback(feedbackId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除意见反馈失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入意见反馈失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("意见反馈不能为空！");
        }
    }

    @Override
    public PageInfo<Feedback> pageQuery(Integer feedbackId, String feedbackType, String feedback, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("feedback_id",feedbackId);
        map.put("feedback_type",feedbackType);
        map.put("feedback",feedback);
        List<Feedback> all = feedbackDao.findByMap(map);
        return new PageInfo<>(all);
    }
}
