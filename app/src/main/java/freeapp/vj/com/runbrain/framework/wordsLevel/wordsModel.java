package freeapp.vj.com.runbrain.framework.wordsLevel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import freeapp.vj.com.runbrain.model.Images;
import freeapp.vj.com.runbrain.model.Words;

public class wordsModel{

        public List<String> palabras;
        public Words words;
        public List<Integer> coordX;
        public List<Integer> coordY;


        public wordsModel(int x, int y){

            words = new Words();
            palabras = words.listaDePalabras();
            Log.i("PALABRAS", "size: "+palabras.size());
            coordX = new ArrayList<>();
            coordY = new ArrayList<>();

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

        public String palabra(int i){
            return palabras.get(i);
        }

}