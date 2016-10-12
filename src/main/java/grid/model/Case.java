package grid.model;

import java.util.logging.Logger;


public class Case{

    private static final Logger LOGGER = Logger.getLogger(Case.class.getName());

    private int key;
    private Position pos;

    public Case(int k, int a, int b) {
        key = k;
        pos = new Position(a, b);
        //LOGGER.info("Case instance created for key "+k+" in position ["+a+","+b+"]");
    }

    public Case(int k, Position p){
        key=k;
        pos = new Position();
        pos.equals(p);
        //LOGGER.info("Case instance created for key "+k+" with position " + p);
    }

    public Case(Case case1) {
        key = case1.getKey();
        pos = case1.getPos();
        //LOGGER.info("Case instance created from case: " + case1);
    }

    public int getKey(){
        return key;
    }

    public void setKey(int x){
        key=x;
    }

    public Position getPos(){
        return pos;
    }

    public void setPos(int a, int b){
        pos.setX(a);
        pos.setY(b);
    }

    public Case getTop(Grid g){
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

    public Case getRight(Grid g){
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

    public Case getBottom(Grid g){
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

    public Case getLeft(Grid g){
        //LOGGER.info("call to getLeft method for Case " + this);
        if(pos.getY()<=0){
            //LOGGER.warning("LEFT Case doesn't exists (is out of Grid) for Case "+ this +" in Grid "+g);
            //LOGGER.info("null is returned");
            return null;
        }else{
            return g.getCaseByPos(pos.getLeft());
        }
    }

    public boolean isInGrid(){
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

    public String toString(){
        return "CASE: key("+String.valueOf(key)+") " + pos.toString();
    }

    public void equals(Case other){
        key = other.getKey();
        pos.equals(other.getPos());
    }

}
