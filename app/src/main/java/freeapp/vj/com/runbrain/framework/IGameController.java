package freeapp.vj.com.runbrain.framework;

import android.graphics.Bitmap;

import java.util.List;

public interface IGameController {

    void onUpdate(float deltaTime, List<TouchHandler.TouchEvent> touchEvents);
    Bitmap onDrawingRequested();

}
