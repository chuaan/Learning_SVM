package com.chuaan.springMVC.helloworld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * 测试用controller
 * author:chuaan
 * created:2018.12.28
 */

@Controller
@RequestMapping("/hi")
public class hiController {

    @RequestMapping("/say")
    public String say(Model model){
        //查找绝对目录/LSMVC/WEB-INF/jsp/say.jsp
        //return "/WEB-INF/jsp/say.jsp";

        //用model来传递数据
        model.addAttribute("name","chuaan");
        model.addAttribute("url","abc");
        //查找相对目录say 需配合修改dispatcher-servlet.xml
        return "say";
    }
}

