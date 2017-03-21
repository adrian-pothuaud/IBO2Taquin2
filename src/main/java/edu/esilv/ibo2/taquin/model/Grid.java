package edu.esilv.ibo2.taquin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A grid is a frame composed by several Cases and their Position
 * @author adrianpothuaud
 *
 */

public class Grid {

    private List<ArrayList<Case>> grid = new ArrayList<ArrayList<Case>>();
/*
    public Grid(Case c){
        grid.get(0);
    }*/

    // random constructor
    public Grid(){
        List<Integer> tmplist = new ArrayList<Integer>();
        int cpt = 0;
        while(cpt<16){
            Random rdm = new Random();
            int tmp = rdm.nextInt() % 16;
            if(tmp<0){
                tmp = - tmp;
            }
            if (!tmplist.contains(tmp)){
                tmplist.add(tmp);
                cpt++;
            }
        }
        for (int i=0; i<4; i++){
            grid.add(i, new ArrayList<Case>());
            for (int j=0; j<4; j++){
                grid.get(i).add(new Case(tmplist.get(4*i+j),i,j));
            }
        }
    }

    // constructor with given list of integers
    public Grid(ArrayList<Integer> config1){
        for (int i=0; i<4; i++){
            grid.add(i, new ArrayList<Case>());
            for (int j=0; j<4; j++){
                grid.get(i).add(new Case(config1.get(4*i+j),i,j));
            }
        }
    }

    // copy constructor
    public Grid(Grid other){
        for(int l = 0; l < other.getGrid().size(); l++){
            grid.add(l, new ArrayList<Case>());
            for(int c = 0; c < other.getGrid().get(l).size(); c++){
                grid.get(l).add(new Case(other.getGrid().get(l).get(c)));
            }
        }
    }

    private List<ArrayList<Case>> getGrid(){
        return grid;
    }

    public Case getCaseByKey(int k){
        //LOGGER.info("getCaseByKey method...(Key: " + k + ")");
        if(k<0 || k>15) return null;
        List<Case> l = grid.get(0);
        return this.getCaseByKey(k, l, 0);
    }

    private Case getCaseByKey(int k, List<Case> l, int line){
        for(Case c : l){
            if(c.getKey()==k){
                return c;
            }
        }
        if(line<grid.size()){
            return this.getCaseByKey(k, grid.get(line+1), line+1);
        }
        return null;
    }

    public Case getCaseByPos(Position k){
        try{
            return grid.get(k.getX()).get(k.getY());
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void moveCase(Case toMove){
        int key = toMove.getKey();
        Position val = toMove.getPos();
        Position zer = this.getCaseByKey(0).getPos();
        Case newZer = new Case(0, val);
        Case newVal = new Case(key, zer);
		/*
		 * Change value case pos to zero case pos
		 */
        grid.get(val.getX()).get(val.getY()).equals(newZer);
		/*
		 * Change zero case pos to value case pos
		 */
        grid.get(zer.getX()).get(zer.getY()).equals(newVal);
    }

    public boolean isSimilarTo(Grid other){
        // verify size
        int l1 = this.getGrid().size(), l2 = other.getGrid().size();
        if(l1 == l2){
            for(int l = 0; l < l1; l++){
                int c1 = grid.get(l).size(), c2 = other.getGrid().get(l).size();
                if(c1 == c2){
                    for(int c = 0; c < c1; c++){
                        if(!grid.get(l).get(c).isEqual(other.getGrid().get(l).get(c))){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public String toString(){
        String tmp = "";
        for (List<Case> i : grid){
            for(Case j : i){
                tmp+="|| ";
                if(j.getKey()/10==0){
                    tmp += " ";
                }
                tmp += String.valueOf(j.getKey());
                tmp+=" ";
            }
            tmp += "||\n";
        }
        return tmp;
    }

    public Object getCases() {
        return grid;
    }

    public int computeNOptFactor() {
        int factor = 0;
        for (int value = 1; value <= 15; value++) {
            if(getCaseByKey(value).getKey() == ((4 * getCaseByKey(value).getPos().getX()) + getCaseByKey(value).getPos().getY() + 1)) {
                factor++;
            }
            else{
                break;
            }
        }
        return factor;
    }
}
