package freeapp.vj.com.runbrain.framework.figuresLevel;

import java.util.ArrayList;
import java.util.List;

import freeapp.vj.com.runbrain.model.Arrows;
import freeapp.vj.com.runbrain.model.Images;

public class figuresModel {

    public List<Images> imgs;
    public List<Integer> coordX;
    public List<Integer> coordY;


    public figuresModel(int x, int y){

        imgs = new ArrayList<>();
        coordX = new ArrayList<>();
        coordY = new ArrayList<>();

        imgs.add(new Images(x, y, 100, 100));

    }

    public void addTO(int x, int y){
        coordX.add(x);
        coordY.add(y);
    }

    public int getA(int i){
        return coordX.get(i);
    }

    public int getB(int i){
        return coordY.get(i);
    }

}