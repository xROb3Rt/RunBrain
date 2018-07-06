package freeapp.vj.com.runbrain.model;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> palabras;

    public Words(){

        palabras = new ArrayList<String>();
        constuirLista();

    }

    private void constuirLista(){
        palabras.add("palabras");
        palabras.add("listas");
        palabras.add("deberes");
        palabras.add("universidad");
        palabras.add("vaca");
        palabras.add("imagen");
        palabras.add("vino");
        palabras.add("casa");
        palabras.add("apartamento");
        palabras.add("departamento");
        palabras.add("casamiento");
        palabras.add("talleres");
        palabras.add("lista");
        palabras.add("palabra");
        palabras.add("imágenes");
        palabras.add("sillas");
        palabras.add("silla");
        palabras.add("rodar");
        palabras.add("ruedas");
        palabras.add("morder");
        palabras.add("pastar");
        palabras.add("pastel");
        palabras.add("mirar");
        palabras.add("mirada");
        palabras.add("defensa");
        palabras.add("ofensa");
        palabras.add("propensa");
        palabras.add("ver");
        palabras.add("alto");
        palabras.add("palo");
        palabras.add("hola");
        palabras.add("bola");
        palabras.add("cola");
        palabras.add("mola");
        palabras.add("video");

    }

    public List<String> listaDePalabras(){
        return palabras;
    }

}
