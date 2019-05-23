package io.fronky.homework3.zorkart.map;

import io.fronky.homework3.zorkart.Location;
import io.fronky.homework3.zorkart.entity.character.Player;

public abstract class GameMap {

    private int rows;
    private int cols;
    private Player player;
    private Room[][] map;
    private Location startLoc;
    private Location currentLoc;
    private int numOfMonster;

    protected GameMap(int rows, int cols, Location startLoc, Player player){
        map = new Room[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.player = player;
        this.startLoc = startLoc;
        this.currentLoc = startLoc;
    }

    public Player getPlayer() { return player; }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getNumOfMonster() {
        return numOfMonster;
    }

    public void setNumOfMonster(int numOfMonster) {
        this.numOfMonster = numOfMonster;
    }

    public Room getRoom(Location loc){
        return getRoom(loc.getRow(), loc.getCol());
    }

    public Room getRoom(int row, int col){
        return map[row][col];
    }

    public void fillRoom(){
        for(int i=0; i<rows; i++){
            for (int j = 0; j < cols; j++) {
                placeRoom(new Room(false), i, j);
            }
        }
    }

    public void setStartLoc(Location startLoc) {
        this.startLoc = startLoc;
    }

    public Location getCurrentLoc() {
        return currentLoc;
    }

    public void setCurrentLoc(Location currentLoc) {
        this.currentLoc = currentLoc;
    }

    public boolean isInBound(int row, int col){
        return isInBound(new Location(row, col));
    }

    public boolean isInBound(Location loc){
        if(loc == null)
            return false;
        return (0 <= loc.getRow() && loc.getRow() < rows) &&
                (0 <= loc.getCol() && loc.getCol() < cols);
    }

    public boolean isValidMove(Location loc){
        if (loc == null || currentLoc == null || !isInBound(loc))
            return false;
        return !map[loc.getRow()][loc.getCol()].isWall();
    }

    public boolean move(Location loc){
        if(isValidMove(loc) && !getRoom(loc).isLocked()){
            setCurrentLoc(loc);
            player.regenHp();
            return true;
        }
        else if(isValidMove(loc) && getRoom(loc).isLocked()){
            System.out.println("The door is locked. Find the key to unlock");
        }
        else{
            System.out.println("You can't move there");
        }
        return false;
    }

    public void placeRoom(Room room, int row, int col){
        placeRoom(room, new Location(row, col));
    }

    public void placeRoom(Room room, Location loc){
        if(room == null || loc == null || !isInBound(loc)) {
            System.err.println("Error: cannot place the entity");
            return;
        }
        map[loc.getRow()][loc.getCol()] = room;
    }

    public void printMap(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Location location = new Location(i, j);
                Room room = map[i][j];
                if(currentLoc.equals(location)){
                    System.out.print("X");
                }
                else if(room.isWall()){
                    System.out.print("O");
                }
                else if(!room.isWall()){
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public abstract boolean achieveObjective();

    public abstract void printObjective();
}
