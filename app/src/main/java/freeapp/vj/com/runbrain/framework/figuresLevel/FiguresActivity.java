package freeapp.vj.com.runbrain.framework.figuresLevel;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import freeapp.vj.com.runbrain.framework.GameActivity;
import freeapp.vj.com.runbrain.framework.IGameController;
import freeapp.vj.com.runbrain.framework.arrowsLevel.arrowsController;

public class FiguresActivity extends GameActivity {


    @Override
    protected IGameController buildGameController() {

        int heightPixels;
        int widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        heightPixels = displayMetrics.heightPixels;
        widthPixels = displayMetrics.widthPixels;

        IGameController gameController = new figuresController(this,widthPixels,heightPixels);

        return gameController;
    }
}
