package io.fronky.homework3.zorkart;

public class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Location loc) {
        return row == loc.getRow() && col == loc.getCol();
    }

    public String toString() {
        return row + "," + col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isAdjacent(Location loc){
        Location left = new Location(this.row-1, this.col);
        Location right = new Location(this.row+1, this.col);
        Location top = new Location(this.row, this.col-1);
        Location bot = new Location(this.row, this.col+1);
        return loc.equals(left) || loc.equals(right) || loc.equals(top) || loc.equals(bot);
    }
}
