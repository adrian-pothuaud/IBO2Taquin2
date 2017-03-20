package edu.esilv.ibo2.taquin.model;

/**
 * A class that represents a <b>Case</b> in Puzzle Game's Grid.
 * Case's attributes are:
 *      -*- key (value in the case)
 *      -*- pos (position in [x, y] format)
 * Constructors:
 *      -*- Case(key, x, y)
 *      -*- Case(key, position)
 *      -*- Case(otherCase) <i>Copy constructor</i>
 * Methods:
 *      -*- getKey()
 *      -*- setKey(newKey)
 *      -*- getPos()
 *      -*-
 */
public class Case {

    private int key;
    private Position pos;

    public Case(int k, int a, int b) {
        key = k;
        pos = new Position(a, b);
    }

    Case(int k, Position p){
        key=k;
        pos = new Position();
        pos.equals(p);
    }

    Case(Case case1) {
        key = case1.getKey();
        pos = case1.getPos();
    }

    public int getKey(){
        return key;
    }

    void setKey(int x){
        key=x;
    }

    public Position getPos(){
        return pos;
    }

    void setPos(int a, int b){
        pos.setX(a);
        pos.setY(b);
    }

    void setPos(Position newPos){
        pos.equals(newPos);
    }

    Case getTop(Grid g){
        //LOGGER.info("call to getTop method for Case " + this);
        if((pos.getX())<=0){
            //LOGGER.warning("TOP Case doesn't exists (is out of Grid) for Case "+ this +" in Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return(g.getCaseByPos(pos.getTop()));
        }
    }

    Case getRight(Grid g){
        //LOGGER.info("call to getRight method for Case " + this);
        if(pos.getY()>=3){
            //LOGGER.warning("RIGHT Case doesn't exists (is out of Grid) for Case "+ this +" in Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return g.getCaseByPos(pos.getRight());
        }
    }

    Case getBottom(Grid g){
        //LOGGER.info("call to getBottom method for Case " + this);
        if(pos.getX()>=3){
            //LOGGER.warning("BOTTOM Case doesn't exists (is out of Grid) for Case "+ this +" in Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }
        else{
            return g.getCaseByPos(pos.getBottom());
        }
    }

    Case getLeft(Grid g){
        //LOGGER.info("call to getLeft method for Case " + this);
        if(pos.getY()<=0){
            //LOGGER.warning("LEFT Case doesn't exists (is out of Grid) for Case "+ this +" in Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }else{
            return g.getCaseByPos(pos.getLeft());
        }
    }

    boolean isInGrid() {
        //LOGGER.info("call to isInGrid method for Case " + this);
        return ((pos.getX() >= 0) && (pos.getX() < 4) && (pos.getY() >= 0) && (pos.getY() < 4));
    }

    public boolean isMovable(Grid g){
        //LOGGER.info("call to isMovable method for Case " + this);
        return ((this.getTop(g)!=null && this.getTop(g).getKey()==0) ||
                (this.getRight(g)!=null && this.getRight(g).getKey()==0) ||
                (this.getBottom(g)!=null && this.getBottom(g).getKey()==0) ||
                (this.getLeft(g)!=null && this.getLeft(g).getKey()==0));
    }
/*

    public String whereIsZero(Grid g){ // on considère que la grid est movable
        if (this.getTop(g)!=null && this.getTop(g).getKey()==0){
            return "top";
        }
        else if (this.getRight(g)!=null && this.getRight(g).getKey()==0){
            return "right";
        }
        else if (this.getBottom(g)!=null && this.getBottom(g).getKey()==0){
            return "bottom";
        }
        else if (this.getLeft(g)!=null && this.getLeft(g).getKey()==0){
            return "left";
        }
        else return "error";
    }
*/

    public String toString(){
        return "CASE: key("+String.valueOf(key)+") " + pos.toString();
    }

    void equals(Case other){
        key = other.getKey();
        pos.equals(other.getPos());
    }

    boolean isEqual(Case other){
        return key == other.getKey() && pos.isEqual(other.getPos());
    }

}
