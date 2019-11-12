package ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.domain.Room;
import ssm.domain.User;
import ssm.service.Impl.PageServiceImpl;
import ssm.service.Impl.RoomServiceImpl;
import ssm.service.Impl.UserServiceImpl;
import ssm.service.PageService;
import ssm.service.RoomService;
import ssm.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zg
 *
 */

@Controller
@RequestMapping("/userController")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userServiceimpl;
    @Autowired
    @Qualifier("pageService")
    private PageServiceImpl pageServiceimpl;

    //用户登录
    @RequestMapping("/proLogin")
    public String proLogin(String userName,String pwd,HttpServletRequest request){
        User user = userServiceimpl.selectUser(userName);
        if(null != user){
            //比较密码
            if(pwd.equals(user.getUserPwd())){
                //写入session
                request.getSession().setAttribute("u",user);
                return "index";
            } else {
                //密码不正确
                request.setAttribute("msg","密码不正确");
                return "index";
            }
        } else {
            //该用户不存在
            request.setAttribute("msg","该用户不存在");
            return "forward:register";
        }
    }

    //proRegister
    @RequestMapping("proRegister")
    public String proRegister(String userName,String pwd){
        return "index";
    }

}