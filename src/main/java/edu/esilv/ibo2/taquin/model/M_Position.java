package edu.esilv.ibo2.taquin.model;

/**
 * A class that represents a Position in the Game's Grid in [row, column] format.
 * Position's attributes are:
 *      -*- x (line)
 *      -*- y (column)
 * Constructors:
 *      -*- M_Position()
 *      -*- M_Position(x, y)
 * Methods:
 *      -*-
 */
public class M_Position {

    private int x;
    private int y;

    M_Position(){
        x=0;
        y=0;
    }

    M_Position(int a, int c) {
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

    M_Position getTop(){
        //LOGGER.info("call to M_Position.getTop()");
        return (new M_Position(x-1,y));
    }

    M_Position getRight(){
        //LOGGER.info("call to M_Position.getRight()");
        return (new M_Position(x,y+1));
    }

    M_Position getBottom(){
        //LOGGER.info("call to M_Position.getBottom()");
        return new M_Position(x+1,y);
    }

    M_Position getLeft(){
        //LOGGER.info("call to M_Position.getLeft()");
        return new M_Position(x,y-1);
    }

    public String toString(){
        return "POSITION: line: " + String.valueOf(x+1) + " colunm: " + String.valueOf(y+1) + "\n";
    }

    void equals(M_Position other){
        x=other.getX();
        y=other.getY();
    }

    boolean isEqual(M_Position other){
        return x==other.getX()&&y==other.getY();
    }

    boolean isInGrid(){
        //LOGGER.info("call to isInGrid method for M_Case " + this);
        return ((x >= 0) && (x < 4) && (y >= 0) && (y < 4));
    }

}
