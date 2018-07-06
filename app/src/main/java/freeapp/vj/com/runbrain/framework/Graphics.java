package freeapp.vj.com.runbrain.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.graphics.Bitmap.Config.ARGB_8888;

/**
 * Created by jvilar on 29/03/16.
 */

public class Graphics {
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;

    public Graphics(int width, int height) {
        this.frameBuffer = Bitmap.createBitmap(width, height, ARGB_8888);
        canvas = new Canvas(frameBuffer);
        paint = new Paint();
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(20);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public Bitmap getFrameBuffer() {
        return frameBuffer;
    }

    public void clear(int color) {
        canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8, color & 0xff);
    }

    public void drawRect(float x, float y, float width, float height, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
    }

    public int getWidth() {
        return frameBuffer.getWidth();
    }

    public int getHeight() {
        return frameBuffer.getHeight();
    }

    public void drawBitmap(Bitmap bitmap, float x, float y){
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public void drawLine(float startX, float startY, float stopX, float stopY,
                         int color, float width) {
        paint.setColor(color);
        paint.setStrokeWidth(width);
        canvas.drawLine(startX, startY, stopX, stopY, paint);

    }

    public void drawText(String s, float x, float y, int color, int fontSize) {
        paint.setColor(color);
        paint.setTextSize(fontSize);
        canvas.drawText(s, x, y, paint);
    }

    public void drawCircle(float x, float y, float sizeY, int starColor) {
        paint.setColor(starColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y, sizeY, paint);
    }

}
