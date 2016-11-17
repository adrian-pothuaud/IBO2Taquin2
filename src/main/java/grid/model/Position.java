package grid.model;

import java.util.logging.Logger;

public class Position {

    private static final Logger LOGGER = Logger.getLogger(Case.class.getName());

    private int x;
    private int y;

    public Position(){
        x=0;
        y=0;
    }

    public Position(int a, int c) {
        x=a;
        y=c;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int a){
        x=a;
    }

    public void setY(int b){
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

    public void equals(Position other){
        x=other.getX();
        y=other.getY();
    }

    public boolean IsEqual(Position other){
        return x==other.getX()&&y==other.getY();
    }

    public boolean isInGrid(){
        //LOGGER.info("call to isInGrid method for Case " + this);
        return ((x >= 0) && (x < 4) && (y >= 0) && (y < 4));
    }

}
