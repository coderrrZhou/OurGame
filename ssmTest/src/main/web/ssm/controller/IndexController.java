package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/register")
    public String home(){
        return "register";
    }


    //进入游戏  ---登录
    @RequestMapping("/games")
    public String games(){
        return "login";
    }

    @RequestMapping("/test")
    public String test(){return "gameResult";}
}
