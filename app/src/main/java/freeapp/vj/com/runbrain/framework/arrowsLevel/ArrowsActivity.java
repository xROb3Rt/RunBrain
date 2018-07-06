package freeapp.vj.com.runbrain.framework.arrowsLevel;

import android.util.DisplayMetrics;

import freeapp.vj.com.runbrain.framework.GameActivity;
import freeapp.vj.com.runbrain.framework.IGameController;

public class ArrowsActivity extends GameActivity {


    @Override
    protected IGameController buildGameController() {

        int heightPixels;
        int widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        heightPixels = displayMetrics.heightPixels;
        widthPixels = displayMetrics.widthPixels;

        IGameController gameController = new arrowsController(this,widthPixels,heightPixels);

        return gameController;
    }
}
