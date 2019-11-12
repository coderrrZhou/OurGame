package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.domain.Room;

import java.util.List;

public interface RoomDao {

    //根据房间id，获取该房间状态
    Room getCurrentRoom(int rId);

    //获取当前房间人数
    int getCurrentPlayerNums(int rId);

    //根据房间状态，获取房间信息
    List<Room> getRoomList(int gameOver);

    //根据房间id（roomId）查询，增加房间游戏玩家
    void playerIn(int roomId);

    //用户退出房间，返回主页
    void playerOut(int roomId);

}
