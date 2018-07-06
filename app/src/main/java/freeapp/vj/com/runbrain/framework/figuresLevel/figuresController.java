package freeapp.vj.com.runbrain.framework.figuresLevel;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import freeapp.vj.com.runbrain.Assets;
import freeapp.vj.com.runbrain.R;
import freeapp.vj.com.runbrain.framework.Graphics;
import freeapp.vj.com.runbrain.framework.IGameController;
import freeapp.vj.com.runbrain.framework.TouchHandler;
import freeapp.vj.com.runbrain.framework.arrowsLevel.arrowsModel;

import static freeapp.vj.com.runbrain.framework.TouchHandler.TouchType.TOUCH_DOWN;

public class figuresController implements IGameController {

    int width, height;
    private Graphics graphics;
    private Drawable d;
    private figuresModel model;
    private boolean botonU = false;
    Random random;
    Random sixRandom;
    ArrayList<Integer> sixR;
    boolean firstTime;
    boolean firstPress;
    int aciertos;
    int fallos;
    float sec;
    float secFirst;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ArrayList<Integer> noImgs;
    int aleatorio;
    int aciertosHigh;
    int fallosHigh;
    SharedPreferences sharedPreferences;


    CountDownTimer countDownTimer = new CountDownTimer(30 * 1000, 1000) {
        public void onTick(long millisUntilFinished) {
            sec = millisUntilFinished/1000;
        }
        public void onFinish() {

        }
    };

    CountDownTimer countDownTimerFirst = new CountDownTimer(10 * 1000, 1000) {
        public void onTick(long millisUntilFinished) {
            secFirst = millisUntilFinished/1000;
        }
        public void onFinish() {

        }
    };

    public figuresController(Context context, int width, int height){

        this.width = width;
        this.height = height;
        d = ContextCompat.getDrawable(context, R.drawable.arrows);

        sharedPreferences = context.getSharedPreferences("highScore",Context.MODE_PRIVATE);
        aciertosHigh = sharedPreferences.getInt("imageAciertos",0);
        fallosHigh = sharedPreferences.getInt("imageFallos",0);

        noImgs = new ArrayList<Integer>();

        sixRandom = new Random();
        sixR = new ArrayList<Integer>();
        int numero = sixRandom.nextInt(21);

        while (sixR.size() < 6){

            if(sixR.contains(numero)){
                numero = sixRandom.nextInt(21);
                }
                else{
                    sixR.add(numero);
                }
            }


        sec = 60;
        secFirst = 60;
        firstTime = true;
        firstPress = false;
        model = new figuresModel(width, height);
        Assets.createAssets(context,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        graphics = new Graphics(width,height);

    }

    @Override
    public void onUpdate(float deltaTime, List<TouchHandler.TouchEvent> touchEvents) {

        for (TouchHandler.TouchEvent event : touchEvents) {

            if (event.type == TOUCH_DOWN) {
                if (firstTime) {
                    countDownTimerFirst.start();
                    firstTime = false;
                    firstPress = true;

                } else {

                    if (event.x <= 480 && event.x >= 300  && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                        botonU = true;
                        comprobar(0);

                    }
                    if (event.x <= 820 && event.x >= 640 && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                        comprobar(1);
                        botonU = true;
                    }
                }
            }


        }

    }

    private void comprobar(int boton) {
        if (sec > 0) {
            if (sixR.contains(aleatorio)) {
                if (boton == 0) {
                    aciertos++;
                } else {
                    fallos++;
                }
            } else {
                if (boton == 0) {
                    fallos++;
                } else {
                    aciertos++;
                }
            }
        }
    }

    @Override
    public Bitmap onDrawingRequested() {


        /*if(model.isWaiting())
            graphics.drawText("TAP TO START", width/4, height/2, Color.BLACK, 100);*/

        if (firstTime){
            graphics.clear(Color.YELLOW);
            graphics.drawText("Memoriza las imágenes de la lista y luego", width/8, height/2 - 200, Color.BLUE, 45);
            graphics.drawText("indica si la imagen de la pantalla estaba en la lista!", width/8 - 90, height/2 - 160, Color.BLUE, 45);
            graphics.drawText("TIENES 30 SEGUNDOS", width/4, height/2 + 160, Color.BLUE, 45);
            graphics.drawText("Pulsa para comenzar!", width/4, height/2 + 320, Color.BLUE, 55);
        }
        else{

            if(secFirst > 0){
                graphics.clear(Color.YELLOW);
                for(int i = 0; i<3; i++){
                    int x = width / 2;
                    int y = height-250;
                    graphics.drawBitmap(Assets.images[sixR.get(i)], (width / 2) - 380, 550 + (290 * i));
                    model.addTO(x, y);
                }

                int a = 0;
                for(int i = 3; i<6; i++){
                    int x = width / 2;
                    int y = height-250;
                    graphics.drawBitmap(Assets.images[sixR.get(i)], (width / 2) + 100, 550 + (290 * a));
                    model.addTO(x, y);
                    a++;
                }

            }

            else{

                graphics.drawBitmap(Assets.botonSi, (width/2) - 250, height-250);
                model.addTO((width/2)-250,height-250);
                graphics.drawBitmap(Assets.botonNo, (width/2) + 100, height-250);
                model.addTO((width/2)+100,height-250);
                graphics.drawText("Aciertos: "+aciertos, (width/2)-100, (height / 8) - 85, Color.BLACK, 50);


/*

                for(int i = 0; i<4; i++){

                    int x = 170+(i*300);
                    int y = height-250;

                    if(i==0) graphics.drawBitmap(Assets.botonSi, (i*300), height-250);
                    if(i==3) graphics.drawBitmap(Assets.botonNo, (i*300), height-250);

                    model.addTO(x, y);
                }
*/

            if(botonU == true || firstPress) {
                if(firstPress){
                    countDownTimer.start();
                    firstPress = false;
                }
                graphics.clear(Color.YELLOW);

                    random = new Random();
                    aleatorio = random.nextInt(21);
                    graphics.drawBitmap(Assets.imagesGrandes[aleatorio], (width / 2) - 350, height/2 - 400);

                    botonU = false;
            }

            }

        }

        if(sec <=0){
            graphics.clear(Color.YELLOW);
            graphics.drawText("¡TIEMPO!", width/2 - 170, height/2, Color.BLACK, 80);
            graphics.drawText("Puntuación: "+aciertos, width/2 - 170, height/2 + 100, Color.BLACK, 50);
            graphics.drawText("Fallos: "+fallos, width/2 - 170, height/2 + 200, Color.BLACK, 50);



            if(aciertosHigh < aciertos){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("imageAciertos", aciertos);
                editor.putInt("imageFallos", fallos);
                editor.apply();
            }



        }

        return graphics.getFrameBuffer();
    }
}
