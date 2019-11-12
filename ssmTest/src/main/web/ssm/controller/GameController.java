package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ssm.domain.Room;
import ssm.service.Impl.GameServiceImpl;
import ssm.service.Impl.UserServiceImpl;
import ssm.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gameController")
public class GameController {

    @Autowired
    @Qualifier("gameService")
    private GameServiceImpl gameServiceimpl;

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userServiceimpl;

    //需要的变量
    private int totalNums=0;//提交的总数值
    private Map<String,Integer> numsMap = new HashMap<String, Integer>();//提交分数的集合
    private int nums_HasSubmit=0;//已经提交的人数
    private int totalPlayers = 3;
    private int Gnums =0 ;




    //得到G值，写入数据库，重新开始下一局游戏
    @RequestMapping("/submitNums")
    public String submitNums(String myNums,HttpServletRequest request){
        /**将存储所有玩家提交的数字集合置空**/
        if(nums_HasSubmit==0)
            numsMap.clear();
        //获取到提交的数字
        int num = Integer.parseInt(myNums);

        HttpSession session = request.getSession(true);
        User u = (User)session.getAttribute("u");

        //加入到 <数字,用户名> 集合中并计算当前数值总和
        numsMap.put(u.getUserName(),num);
//        //存入session <myNums, userName>
//        request.getSession().setAttribute(myNums,userName);
        nums_HasSubmit++;
        totalNums+=num;

        return "gameResult";

        /****
        //需要做的工作：
        //一、实现多参数返回，就是当前的getG方法  返回值包括 G值 还有 WinnerId
        //二、依照游戏房间来为游戏局命名 gameId,并将以上三个字段通过GameDao插入到数据库中
        //三、积分制，胜者应该得到一定的积分，并插入数据库。

        //存入session
//        request.getSession().setAttribute("G",GNums);
        //开始下一局新游戏,每一局游戏用room.jsp来进行，不用waiting.
//        return "room";
         **/
    }




    //处理用户提交的数字--------------------不需要，暂留
    @RequestMapping("/gameOver")
    public @ResponseBody Object gameOver(){
        //所有玩家已经提交完成
        if(nums_HasSubmit==3){
            //算出G值
            Gnums = totalNums/totalPlayers;

            //胜利者信息
            String winnerName ="";
            int winnerScore = 0;
            int dvalue= 100;//初始差值

            //遍历所有分数，得到与G值差值最小的username 即胜利玩家
            for(String temp:numsMap.keySet()){
                if(Math.abs(numsMap.get(temp))<dvalue){
                    winnerScore = numsMap.get(temp);
                    winnerName = temp;
                    dvalue = Math.abs(numsMap.get(temp)-Gnums);
                }
            }

            //分别为所有玩家设置积分
            for(String temp:numsMap.keySet()){
                if(temp.equals(winnerName)){
                    //胜利玩家一次获得+50积分
                    userServiceimpl.setScore(50,temp);
                    //为胜利玩家添加 胜利次数
                    userServiceimpl.setWinner(temp);
                    //
                }
                else {
                    //写入积分，就按照差值的 负整十数
                    userServiceimpl.setScore(Math.abs(numsMap.get(temp) - Gnums) / 10 * (-10), temp);
                }
            }

            /**numsMap最后一行数据，将胜利玩家的 分数，userName 写入**/
            numsMap.put(winnerName,winnerScore);

            /**将全部数据置空**/
            totalNums=0;//提交的总数值
            nums_HasSubmit=0;//已经提交的人数
            totalPlayers = 3;
            Gnums =0 ;
        }
        //将numsMap返回给前台ajax
        return numsMap;
    }

    //返回到主页
    @RequestMapping("backToIndex")
    public String backtoIndex(){
        return "index";
    }
}
