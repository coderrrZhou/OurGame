package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.dao.RoomDao;
import ssm.domain.Room;
import ssm.service.RoomService;

import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService{

    @Autowired(required = false)
    private RoomDao roomDao;

    @Override
    //默认找正在进行游戏的房间
    public List<Room> getRoomList(int gameOver) {
        return roomDao.getRoomList(gameOver);
    }

    @Override
    public void playerIn(int roomId) {
        roomDao.playerIn(roomId);
    }

    //用户退出房间，返回主页
    @Override
    public void playerOut(int roomId) {
        roomDao.playerOut(roomId);
    }

    @Override
    public Room getCurrentRoom(int rId) {
        return roomDao.getCurrentRoom(rId);
    }

    @Override
    public int getCurrentPlayerNums(int rId) {
        return roomDao.getCurrentPlayerNums(rId);
    }
}
