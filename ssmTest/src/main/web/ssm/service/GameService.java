package ssm.service;

public interface GameService {

    //写入新的游戏记录
    void addGameRcord(String gameId, int winnerId,int gameG);
}
