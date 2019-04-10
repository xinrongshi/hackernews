package com.cskaoyan.controller;

import com.cskaoyan.bean.News;
import com.cskaoyan.service.NewsService;
import com.cskaoyan.service.UserService;
import com.cskaoyan.vo.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    NewsService newsService;

    @Autowired
    UserService userService;

    @RequestMapping("/news")
    public String homePage (Model model){
        List<News> allNews = newsService.findAllNews();
        List<ViewObject> list = new ArrayList<>();
        for (News news:allNews) {
            ViewObject vo = new ViewObject();
           vo.set("news", news);
           vo.set("user", userService.findByUserId(news.getUserId()));
           vo.set("like",news.getLikeCount());
           list.add(vo);
        }
        model.addAttribute("vos",list);
        return "home";
    }

    @RequestMapping("/login")
    public String loginPage (Model model){


        return "home";
    }
}
