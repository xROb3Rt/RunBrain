package freeapp.vj.com.runbrain.framework.arrowsLevel;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import freeapp.vj.com.runbrain.Assets;
import freeapp.vj.com.runbrain.R;
import freeapp.vj.com.runbrain.framework.Graphics;
import freeapp.vj.com.runbrain.framework.IGameController;
import freeapp.vj.com.runbrain.framework.TouchHandler;

import static freeapp.vj.com.runbrain.framework.TouchHandler.TouchType.TOUCH_DOWN;
import static freeapp.vj.com.runbrain.framework.TouchHandler.TouchType.TOUCH_UP;

public class arrowsController implements IGameController {

    int width, height;
    private Graphics graphics;
    private Drawable d;
    private arrowsModel model;
    private boolean botonU = false;
    Random random;
    int i1, i2;
    int posicionCorrecta;
    boolean firstTime;
    boolean firstPress;
    int aciertosHigh;
    int fallosHigh;
    int aciertos;
    int fallos;
    float sec;
    boolean countDown;
    SharedPreferences sharedPreferences;

    CountDownTimer countDownTimer = new CountDownTimer(30 * 1000, 1000) {
        public void onTick(long millisUntilFinished) {
            sec = millisUntilFinished/1000;
        }
        public void onFinish() {

        }
    };

    public arrowsController(Context context, int width, int height){

        this.width = width;
        this.height = height;
        d = ContextCompat.getDrawable(context, R.drawable.arrows);

        sharedPreferences = context.getSharedPreferences("highScore",Context.MODE_PRIVATE);
        aciertosHigh = sharedPreferences.getInt("arrowAciertos",0);
        fallosHigh = sharedPreferences.getInt("arrowFallos",0);

        sec = 60;
        firstTime = true;
        firstPress = false;
        countDown = false;
        model = new arrowsModel(width, height);
        Assets.createAssets(context,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        graphics = new Graphics(width,height);

    }

    @Override
    public void onUpdate(float deltaTime, List<TouchHandler.TouchEvent> touchEvents) {

            for (TouchHandler.TouchEvent event : touchEvents) {

                if (event.type == TOUCH_DOWN) {
                    if (firstTime) {
                        firstTime = false;
                        firstPress = true;
                        countDownTimer.start();
                        countDown = true;
                    } else {

                        if (event.x <= model.getA(0) && event.x >= model.getA(0) - 170 && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                            botonU = true;
                            comprobar(0);
                        }
                        if (event.x <= model.getA(1) && event.x >= model.getA(1) - 170 && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                            comprobar(1);
                            botonU = true;
                        }
                        if (event.x <= model.getA(2) && event.x >= model.getA(2) - 170 && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                            comprobar(2);
                            botonU = true;
                        }
                        if (event.x <= model.getA(3) && event.x >= model.getA(3) - 170 && event.y >= model.getB(0) && event.y <= model.getB(0) + 170) {

                            comprobar(3);
                            botonU = true;
                        }

                    }
                }


            }

    }

    private void comprobar(int boton) {
        if (sec > 0) {
            if (boton == posicionCorrecta) {
                aciertos++;
            } else {
                fallos++;
            }
        }
    }

    @Override
    public Bitmap onDrawingRequested() {

        if (firstTime){
            graphics.clear(Color.YELLOW);
            graphics.drawText("Usa los botones para indicar la dirección", width/8, height/2 - 200, Color.BLUE, 45);
            graphics.drawText("en la que apunta la flecha de en medio!", width/8 + 10, height/2 - 160, Color.BLUE, 45);
            graphics.drawText("TIENES 30 SEGUNDOS", width/4, height/2 + 160, Color.BLUE, 45);
            graphics.drawText("Pulsa para comenzar!", width/4, height/2 + 320, Color.BLUE, 55);
        }
        else{
            for(int i = 0; i<4; i++){

                int x = 170+(i*300);
                int y = height-250;

                graphics.drawBitmap(Assets.arrow4[i], (i*300), height-250);
                graphics.drawText("Aciertos: "+aciertos, (width/2)-100, (height / 8) - 85, Color.BLACK, 50);
                model.addTO(x, y);
            }

            if(botonU == true || firstPress) {
                firstPress = false;
                graphics.clear(Color.YELLOW);
                for (int i = 0; i < 5; i++) {

                    random = new Random();
                    i1 = random.nextInt(600 + 1 - 100) + 100;
                    i2 = random.nextInt(500 + 1 + 400) - 500;
                    int flecha = random.nextInt(4);

                    graphics.drawBitmap(Assets.arrowb[flecha], (width / 2) - 85, 310 + (250 * i));
                    if(i == 2){
                        posicionCorrecta = flecha;
                    }

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
                editor.putInt("arrowAciertos", aciertos);
                editor.putInt("arrowFallos", fallos);
                editor.apply();
            }


        }

        return graphics.getFrameBuffer();
    }
}
