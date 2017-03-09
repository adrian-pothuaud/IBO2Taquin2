package edu.esilv.ibo2.taquin.model;

import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A grid is a frame composed by several Cases and their M_Position
 * @author adrianpothuaud
 *
 */

public class M_Grid {

    private static final Logger LOGGER = Logger.getLogger(M_Case.class.getName());

    List<ArrayList<M_Case>> grid = new ArrayList<ArrayList<M_Case>>();

    // random constructor
    public M_Grid(){
        //LOGGER.info("M_Grid instance under construction within Random generation...");
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
            grid.add(i, new ArrayList<M_Case>());
            for (int j=0; j<4; j++){
                grid.get(i).add(new M_Case(tmplist.get(4*i+j),i,j));
            }
        }
        //LOGGER.info("M_Grid created: \n" + this);
    }

    // constructor with given list of integers
    public M_Grid(ArrayList<Integer> config1){
        //LOGGER.info("M_Grid instance under construction within given configuration...");
        for (int i=0; i<4; i++){
            grid.add(i, new ArrayList<M_Case>());
            for (int j=0; j<4; j++){
                grid.get(i).add(new M_Case(config1.get(4*i+j),i,j));
            }
        }
        //LOGGER.info("M_Grid created: \n" + this);
    }

    // copy constructor
    public M_Grid(M_Grid other){

        for(int l = 0; l < other.getGrid().size(); l++){
            grid.add(l, new ArrayList<M_Case>());
            for(int c = 0; c < other.getGrid().get(l).size(); c++){
                grid.get(l).add(new M_Case(other.getGrid().get(l).get(c)));
            }
        }

    }

    public List<ArrayList<M_Case>> getGrid(){

        return grid;

    }

    public M_Case getCaseByKey(int k){
        //LOGGER.info("getCaseByKey method...(Key: " + k + ")");
        if(k<0 || k>15) return null;
        List<M_Case> l = grid.get(0);
        return this.getCaseByKey(k, l, 0);
    }

    public M_Case getCaseByKey(int k, List<M_Case> l, int line){
        for(M_Case c : l){
            if(c.getKey()==k){
                return c;
            }
        }
        if(line<grid.size()){
            return this.getCaseByKey(k, grid.get(line+1), line+1);
        }
        return null;
    }

    public M_Case getCaseByPos(M_Position k){
        //LOGGER.info("getCaseByPos method...(M_Position: " + k + ")");
        try{
            return grid.get(k.getX()).get(k.getY());
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void moveCase(M_Case toMove){
        //LOGGER.info("call to permute method for M_Case " + this.getCaseByKey(0) + " with other M_Case " + toMove);
        int key = toMove.getKey();
        M_Position val = toMove.getPos();
        M_Position zer = this.getCaseByKey(0).getPos();
        M_Case newZer = new M_Case(0, val);
        M_Case newVal = new M_Case(key, zer);
		/*
		 * Change value case pos to zero case pos
		 */
        grid.get(val.getX()).get(val.getY()).equals(newZer);
		/*
		 * Change zero case pos to value case pos
		 */
        grid.get(zer.getX()).get(zer.getY()).equals(newVal);
    }

    public boolean isSimilarTo(M_Grid other){
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
        for (List<M_Case> i : grid){
            for(M_Case j : i){
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

}
