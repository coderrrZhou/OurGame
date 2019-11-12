package ssm.domain;

public class Game {
    private String gameId;
    private int winnerId;
    private int gameG;

    @Override
    public String toString() {
        return "Game{" + "gameId='" + gameId + '\'' + ", winnerId=" + winnerId + ", gameG=" + gameG + '}';
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getGameG() {
        return gameG;
    }

    public void setGameG(int gameG) {
        this.gameG = gameG;
    }
}
