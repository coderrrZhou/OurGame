package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.service.UserService;
import ssm.domain.*;
/**
 * Created by infodba on 2018/5/23.
 */

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired(required = false)
    private UserDao userDao;

    @Override
    //查询是否有该用户
    public User selectUser(String userName) {
        return userDao.selectUser(userName);
    }


    //修改分数
    @Override
    public void setScore(int score, String userName) {
        userDao.setScore(score,userName);
    }

    //设置赢家
    @Override
    public void setWinner(String userName) {
        userDao.setWinner(userName);
    }

    @Override
    public void newUser(String userName, String pwd) {
        userDao.newUser(userName,pwd);
    }
}