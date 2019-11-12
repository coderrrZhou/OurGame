package ssm.service;

import ssm.domain.Room;

import java.util.List;

public interface RoomService {

    //根据房间id，获取该房间状态
    Room getCurrentRoom(int rId);

    //找到正在进行游戏的房间
    List<Room> getRoomList(int gameOver);

    //游戏房间加入新的玩家（已经开始游戏后）
    void playerIn(int roomId);

    //用户退出房间，返回主页
    void playerOut(int roomId);

    //获取当前房间人数
    int getCurrentPlayerNums(int rId);
}