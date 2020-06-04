package com.example.demo.dao;

import java.util.Map;

public class FeedbackSqlProvider {

    public String findByMap(Map<String, Object> map) {

        String re = "select * from feedbackinfo where 1=1 ";

        Object feedbackId = map.get("feedback_id");
        if (feedbackId != null && !"".equals(feedbackId)) {
            re += " and feedback_id like #{feedback_id}";
        }

        // 根据文章id
        Object feedbackType = map.get("feedback_type");
        if (feedbackType != null && !"".equals(feedbackType)) {
            re += " and feedback_type like CONCAT(\"%\",#{feedback_type},\"%\")";
        }

        Object Feedback = map.get("feedback");
        if (Feedback != null && !"".equals(Feedback)) {
            re += " and feedback = #{feedback}";
        }

        return re;
    }
}
