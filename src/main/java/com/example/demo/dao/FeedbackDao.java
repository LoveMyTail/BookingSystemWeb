package com.example.demo.dao;

import com.example.demo.entity.Feedback;
import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.jdbc.core.SqlProvider;

import java.util.List;
import java.util.Map;

public interface FeedbackDao {
    List<Feedback> queryFeedback();
    List<Feedback> queryFeedbackByUserId(String userId);
    int insertFeedback(Feedback feedback);
    int deleteFeedback(int feedbackId);

    @Mapper
    @SelectProvider(type = FeedbackSqlProvider.class, method = "findByMap")
    List<Feedback> findByMap(Map<String, Object> map);

    @Mapper
    @Select("select * from feedbackinfo where  feedback_id=#{feedbackId}")
    public Feedback findById(Integer feedbackId);
}
