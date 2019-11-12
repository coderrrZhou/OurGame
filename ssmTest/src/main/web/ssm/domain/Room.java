package ssm.domain;

public class Room {
    private int roomId;//分配房间id
    private int times;//记录该房间内的游戏局
    private int winnerId;//记录胜利者id
    private int playerNums; //当前游戏玩家数量
    private int gameOver;//若为1,则房间游戏仍在进行，否则已结束 无法加入

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", times=" + times + ", winnerId=" + winnerId + ", playerNums=" + playerNums + ", gameOver=" + gameOver + '}';
    }

    public int getPlayerNums() {
        return playerNums;
    }

    public void setPlayerNums(int playerNums) {
        this.playerNums = playerNums;
    }

    public int getGameOver() {
        return gameOver;
    }

    public void setGameOver(int gameOver) {
        this.gameOver = gameOver;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }
}
