package ssm.dao;

import org.apache.ibatis.annotations.Param;

public interface GameDao {
    //写入game游戏记录 游戏局号，游戏赢家，游戏G值
    void addGameRcord(@Param("gId")String gameId, @Param("gWinnerId")int winnerId,@Param("gG")int gameG);

}
