package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.domain.Room;
import ssm.service.Impl.RoomServiceImpl;
import ssm.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roomController")
public class RoomController {
    @Autowired
    @Qualifier("roomService")
    private RoomServiceImpl roomServiceimpl;


    //展示房间列表
    @ResponseBody
    @RequestMapping(value="/proRoom",method= RequestMethod.GET)
    public List<Room> proRoom(HttpServletRequest request){
        List<Room> roomList= roomServiceimpl.getRoomList(0);
        request.getSession().setAttribute("r",roomList);
        return roomList;
    }

    //由展示房间列表跳转到房间内，添加房间人数
    @RequestMapping(value = "/joinInRoom")
    public String joinInRoom(String rId,HttpServletRequest request){
//  public String joinInRoom(@RequestParam("rId") Room r){
        //玩家数量+1
        roomServiceimpl.playerIn(Integer.parseInt(rId));
        //获取当前房间状态，存入session
        Room current_r = roomServiceimpl.getCurrentRoom(Integer.parseInt(rId));
        request.getSession().setAttribute("r", current_r);
//        roomServiceimpl.addPlayer(rId.getPlayerNums());
        return "waiting";
    }

    //获取当前游戏人数
    @RequestMapping(value ="getCurrentPlayerNums",method = RequestMethod.GET)
    @ResponseBody
    public int getCurrentPlayerNums(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Room temp_r = (Room)session.getAttribute("r");
        int currentPlayers = roomServiceimpl.getCurrentPlayerNums(temp_r.getRoomId());
        //房间人已经满了
        return currentPlayers;
    }

    //由游戏房间界面返回到房间列表
    @RequestMapping(value = "/roomBack")
    public String roomBack(String rId){
        roomServiceimpl.playerOut(Integer.parseInt(rId));
        return "index";
    }


    //由游戏等待界面（waiting） 转向到游戏界面（room）      中转站
    @RequestMapping(value = "/gameStarting")
    public String gameStarting(){
        return "room";
    }

}
