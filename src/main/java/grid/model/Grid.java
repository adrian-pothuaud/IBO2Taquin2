package grid.model;

import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A grid is a frame composed by several Cases and their Position
 * @author adrianpothuaud
 *
 */

public class Grid {

    private static final Logger LOGGER = Logger.getLogger(Case.class.getName());

    List<ArrayList<Case>> grid = new ArrayList<ArrayList<Case>>();

    public Grid(){
        //LOGGER.info("Grid instance under construction within Random generation...");
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
        //LOGGER.info("Grid created: \n" + this);
    }

    public Grid(ArrayList<Integer> config1){
        //LOGGER.info("Grid instance under construction within given configuration...");
        for (int i=0; i<4; i++){
            grid.add(i, new ArrayList<Case>());
            for (int j=0; j<4; j++){
                grid.get(i).add(new Case(config1.get(4*i+j),i,j));
            }
        }
        //LOGGER.info("Grid created: \n" + this);
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

    public Case getCaseByKey(int k){
        //LOGGER.info("getCaseByKey method...(Key: " + k + ")");
        List<Case> l = grid.get(0);
        return this.getCaseByKey(k, l, 0);
    }

    public Case getCaseByKey(int k, List<Case> l, int line){
        for(Case c : l){
            if(c.getKey()==k){
                return c;
            }
        }
        if(line<grid.size()){
            return this.getCaseByKey(k, grid.get(line+1), line+1);
        }
        else{
            return null;
        }
    }

    public Case getCaseByPos(Position k){
        //LOGGER.info("getCaseByPos method...(Position: " + k + ")");
        return grid.get(k.getX()).get(k.getY());
    }

    public void move(Case toMove){
        //LOGGER.info("call to permute method for Case " + this.getCaseByKey(0) + " with other Case " + toMove);
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

    public boolean SimilarTo(Grid other){
        return (grid.get(0).get(0) == other.grid.get(0).get(0)
                && SimilarToHelper(other, 0, 1));
    }

    private boolean SimilarToHelper(Grid other, int line, int column){
        if(column<4){
            return (grid.get(line).get(column) == other.grid.get(line).get(column)
                    && SimilarToHelper(other, line, column + 1));
        }
        else{
            if(line<4){
                return (grid.get(line).get(column) == other.grid.get(line).get(column)
                        && SimilarToHelper(other, line + 1, column));
            }
            else{
                return true;
            }
        }
    }

}
