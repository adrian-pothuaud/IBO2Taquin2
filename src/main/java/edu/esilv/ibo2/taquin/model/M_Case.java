package edu.esilv.ibo2.taquin.model;

import java.util.logging.Logger;


public class M_Case {

    private static final Logger LOGGER = Logger.getLogger(M_Case.class.getName());

    private int key;
    private M_Position pos;

    public M_Case(int k, int a, int b) {
        key = k;
        pos = new M_Position(a, b);
        //LOGGER.info("M_Case instance created for key "+k+" in position ["+a+","+b+"]");
    }

    public M_Case(int k, M_Position p){
        key=k;
        pos = new M_Position();
        pos.equals(p);
        //LOGGER.info("M_Case instance created for key "+k+" with position " + p);
    }

    public M_Case(M_Case case1) {
        key = case1.getKey();
        pos = case1.getPos();
        //LOGGER.info("M_Case instance created from case: " + case1);
    }

    public int getKey(){
        return key;
    }

    public void setKey(int x){
        key=x;
    }

    public M_Position getPos(){
        return pos;
    }

    public void setPos(int a, int b){
        pos.setX(a);
        pos.setY(b);
    }

    public M_Case getTop(M_Grid g){
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

    public M_Case getRight(M_Grid g){
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

    public M_Case getBottom(M_Grid g){
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

    public M_Case getLeft(M_Grid g){
        //LOGGER.info("call to getLeft method for M_Case " + this);
        if(pos.getY()<=0){
            //LOGGER.warning("LEFT M_Case doesn't exists (is out of M_Grid) for M_Case "+ this +" in M_Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }else{
            return g.getCaseByPos(pos.getLeft());
        }
    }

    public boolean isInGrid(){
        //LOGGER.info("call to isInGrid method for M_Case " + this);
        if(this == null) return false;
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

    public void equals(M_Case other){
        key = other.getKey();
        pos.equals(other.getPos());
    }

    public boolean isEqual(M_Case other){
        return key == other.getKey() && pos.isEqual(other.getPos());
    }

}
