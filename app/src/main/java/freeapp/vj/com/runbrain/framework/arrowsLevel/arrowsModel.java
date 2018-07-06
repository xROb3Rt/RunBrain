package freeapp.vj.com.runbrain.framework.arrowsLevel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import freeapp.vj.com.runbrain.model.Arrows;

public class arrowsModel {

    public List <Arrows> arrow;
    public List<Integer> coordX;
    public List<Integer> coordY;


    public arrowsModel(int x, int y){

        arrow = new ArrayList<>();
        coordX = new ArrayList<>();
        coordY = new ArrayList<>();

        arrow.add(new Arrows(x, y, 100, 100));

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
