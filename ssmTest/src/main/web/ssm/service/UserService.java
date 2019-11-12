package ssm.service;

import org.springframework.stereotype.Service;
import ssm.domain.*;
/**
 * Created by infodba on 2018/5/23.
 */
public interface UserService {
    User selectUser(String userName);

    //插入用户积分
    void setScore(int score,String userName);

    //设置赢家
    void setWinner(String userName);

    //注册
    void newUser(String userName,String pwd);
}