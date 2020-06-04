package com.example.demo.web;

import com.example.demo.dao.ShowDao;
import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;


@Controller
//@RequestMapping
public class WebShowController {


    @Autowired
    private ShowService showService;

    @Autowired
    private ShowDao showDao;

    @RequestMapping("/showList")
    public String list(@RequestParam(name = "show_id", defaultValue = "") Integer showId,
                       @RequestParam(name = "show_name", defaultValue = "") String showName,
                       @RequestParam(defaultValue = "", name = "show_type") String showType,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "4") Integer pageSize,
                       Model model) {
        model.addAttribute("show_id", showId);// 将演出编号放到model
        model.addAttribute("show_name", showName);// 将演出名称放到model
        model.addAttribute("show_type", showType);
        PageInfo<Show> pageData = showService.pageQuery(showId, showName, showType, pageNum, pageSize);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------显示演出信息---------");
        return "show/showList";// 转到演出信息页面展示
    }


    // 删除
    @RequestMapping("/deleteShow")
    public String delete(Integer showId, String showName,String showType,Integer pageNum,Integer pageSize,Model model) {
        //System.out.println("--------成功删除数据-111--------");
        showDao.deleteShow(showId);
        model.addAttribute("msg", "成功删除数据");
        System.out.println("--------成功删除数据-222--------");

        PageInfo<Show> pageData = showService.pageQuery(null, null, null, 1, 4);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------重新显示演出信息---------");
        return "show/showList";// 转到演出信息页面展示

        //return "show/showList";// 返回列表页面
    }

    @RequestMapping("/viewShow")
    public String view(Integer showId, Model model) {
        // 根据编号去查询文章信息
        Show show = showDao.findById(showId);
        // 将查询的博主文章数据放入model中
        model.addAttribute("obj", show);
        return "show/view";// 跳转显示页面
    }

    @RequestMapping("/addShow")
    public String add(Show show,Model model){
        showDao.insert(show);

        PageInfo<Show> pageData = showService.pageQuery(null, null, null, 1, 4);
        // 将数据放到model
        model.addAttribute("pageInfo", pageData);
        System.out.println("--------重新显示演出信息---------");
        return "show/showList";// 转到演出信息页面展示

        //return "forward:/show/showList";// 返回列表页面
    }



    @RequestMapping("/isExist")
    @ResponseBody
    public String isExist(String showName){
        int count = showDao.countByShowName(showName);
        if(count>0){
            System.out.println("-------------yes----------");
            return "yes";
        }else{
            System.out.println("-------------no----------");
            return "no";
        }
    }


}
