package edu.esilv.ibo2.taquin.model;

/**
 * A class that represents a <b>Case</b> in Puzzle Game's Grid.
 * Case's attributes are:
 *      -*- key (value in the case)
 *      -*- pos (position in [x, y] format)
 * Constructors:
 *      -*- M_Case(key, x, y)
 *      -*- M_Case(key, position)
 *      -*- M_Case(otherCase) <i>Copy constructor</i>
 * Methods:
 *      -*- getKey()
 *      -*- setKey(newKey)
 *      -*- getPos()
 *      -*-
 */
public class M_Case {

    private int key;
    private M_Position pos;

    M_Case(int k, int a, int b) {
        key = k;
        pos = new M_Position(a, b);
    }

    M_Case(int k, M_Position p){
        key=k;
        pos = new M_Position();
        pos.equals(p);
    }

    M_Case(M_Case case1) {
        key = case1.getKey();
        pos = case1.getPos();
    }

    int getKey(){
        return key;
    }

    void setKey(int x){
        key=x;
    }

    M_Position getPos(){
        return pos;
    }

    void setPos(int a, int b){
        pos.setX(a);
        pos.setY(b);
    }

    void setPos(M_Position newPos){
        pos.equals(newPos);
    }

    M_Case getTop(M_Grid g){
        //LOGGER.info("call to getTop method for M_Case " + this);
        if((pos.getX())<=0){
            //LOGGER.warning("TOP M_Case doesn't exists (is out of M_Grid) for M_Case "+ this +" in M_Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return(g.getCaseByPos(pos.getTop()));
        }
    }

    M_Case getRight(M_Grid g){
        //LOGGER.info("call to getRight method for M_Case " + this);
        if(pos.getY()>=3){
            //LOGGER.warning("RIGHT M_Case doesn't exists (is out of M_Grid) for M_Case "+ this +" in M_Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return g.getCaseByPos(pos.getRight());
        }
    }

    M_Case getBottom(M_Grid g){
        //LOGGER.info("call to getBottom method for M_Case " + this);
        if(pos.getX()>=3){
            //LOGGER.warning("BOTTOM M_Case doesn't exists (is out of M_Grid) for M_Case "+ this +" in M_Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return g.getCaseByPos(pos.getBottom());
        }
    }

    M_Case getLeft(M_Grid g){
        //LOGGER.info("call to getLeft method for M_Case " + this);
        if(pos.getY()<=0){
            //LOGGER.warning("LEFT M_Case doesn't exists (is out of M_Grid) for M_Case "+ this +" in M_Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }else{
            return g.getCaseByPos(pos.getLeft());
        }
    }

    boolean isInGrid() {
        //LOGGER.info("call to isInGrid method for M_Case " + this);
        return ((pos.getX() >= 0) && (pos.getX() < 4) && (pos.getY() >= 0) && (pos.getY() < 4));
    }

    public boolean isMovable(M_Grid g){
        //LOGGER.info("call to isMovable method for M_Case " + this);
        return ((this.getTop(g)!=null && this.getTop(g).getKey()==0) ||
                (this.getRight(g)!=null && this.getRight(g).getKey()==0) ||
                (this.getBottom(g)!=null && this.getBottom(g).getKey()==0) ||
                (this.getLeft(g)!=null && this.getLeft(g).getKey()==0));
    }

    public String toString(){
        return "CASE: key("+String.valueOf(key)+") " + pos.toString();
    }

    void equals(M_Case other){
        key = other.getKey();
        pos.equals(other.getPos());
    }

    boolean isEqual(M_Case other){
        return key == other.getKey() && pos.isEqual(other.getPos());
    }

}
