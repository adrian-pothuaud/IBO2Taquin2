package edu.esilv.ibo2.taquin.controller;

import edu.esilv.ibo2.taquin.model.Tree;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by adrianpothuaud on 20/03/2017.
 */
public class _NOptTreeGeneratorTest {
    @Test
    public void getNbConfigs() throws Exception {

    }

    @Test
    public void getNbPerfectConf() throws Exception {

    }

    @Test
    public void letOnlyBestGrids() throws Exception {

    }

    @Test
    public void lvlOrderBuildTillPerfect() throws Exception {
        N_Opt_TreeGenerator myGenerator = new N_Opt_TreeGenerator(new Tree(new SolvableGrid().genSolvablegrid(20)));
        System.out.println(myGenerator.getMyTree().getRoot().getGrid());
        ArrayList<String> myDirections = myGenerator.lvlOrderBuildTillPerfect();
        System.out.println("Tree build complete");
        System.out.println(myDirections);
    }

    @Test
    public void lvlOrderBuild() throws Exception {
        N_Opt_TreeGenerator myGenerator = new N_Opt_TreeGenerator(new Tree(new SolvableGrid().genSolvablegrid(2)));
        System.out.println(myGenerator.getMyTree().getRoot().getGrid());
        myGenerator.lvlOrderBuild(myGenerator.getMyTree().getRoot());
        System.out.println("Tree build complete");
    }

}