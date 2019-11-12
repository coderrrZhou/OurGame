package ssm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.GameDao;
import ssm.service.GameService;

@Service("gameService")
public class GameServiceImpl implements GameService{

    @Autowired(required = false)
    private GameDao gameDao;

    @Override
    public void addGameRcord(String gameId, int winnerId, int gameG) {
        gameDao.addGameRcord(gameId,winnerId,gameG);
    }
}
