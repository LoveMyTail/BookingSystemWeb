package com.example.demo.web;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmincomment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/listcomment",method = RequestMethod.GET)
    private Map<String ,Object> listComment(){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        List<Comment> list = commentService.getCommentList();
        modelMap.put("commentList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getcommentbyshowid",method = RequestMethod.GET)
    private Map<String,Object> getCommentByUserId(String userId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Comment> list = commentService.getCommentByUserId(userId);
        modelMap.put("commentList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getcommentbyuserid",method = RequestMethod.GET)
    private Map<String,Object> getCommentByShowId(int showId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Comment> list = commentService.getCommentByShowId(showId);
        modelMap.put("commentList",list);
        return modelMap;
    }

    @RequestMapping(value = "/addcomment",method = RequestMethod.POST)
    private Map<String,Object> addComment(@RequestBody Comment comment){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",commentService.addComment(comment));
        return modelMap;
    }

    @RequestMapping(value = "/removecomment",method = RequestMethod.GET)
    private Map<String,Object> removeComment(Integer commentId){
        Map<String ,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",commentService.deleteComment(commentId));
        return modelMap;
    }


}
