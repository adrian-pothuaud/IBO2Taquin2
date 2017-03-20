package edu.esilv.ibo2.taquin.model;

/**
 * A class that represents a Position in the Game's Grid in [row, column] format.
 * Position's attributes are:
 *      -*- x (line)
 *      -*- y (column)
 * Constructors:
 *      -*- Position()
 *      -*- Position(x, y)
 * Methods:
 *      -*-
 */
public class Position {

    private int x;
    private int y;

    Position(){
        x=0;
        y=0;
    }

    Position(int a, int c) {
        x=a;
        y=c;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    void setX(int a){
        x=a;
    }

    void setY(int b){
        y=b;
    }

    public Position getTop(){
        //LOGGER.info("call to Position.getTop()");
        return (new Position(x-1,y));
    }

    public Position getRight(){
        //LOGGER.info("call to Position.getRight()");
        return (new Position(x,y+1));
    }

    public Position getBottom(){
        //LOGGER.info("call to Position.getBottom()");
        return new Position(x+1,y);
    }

    public Position getLeft(){
        //LOGGER.info("call to Position.getLeft()");
        return new Position(x,y-1);
    }

    public String toString(){
        return "POSITION: line: " + String.valueOf(x+1) + " colunm: " + String.valueOf(y+1) + "\n";
    }

    void equals(Position other){
        x=other.getX();
        y=other.getY();
    }

    boolean isEqual(Position other){
        return x==other.getX()&&y==other.getY();
    }

    public boolean isInGrid(){
        //LOGGER.info("call to isInGrid method for Case " + this);
        return ((x >= 0) && (x < 4) && (y >= 0) && (y < 4));
    }

}
