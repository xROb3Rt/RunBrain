package freeapp.vj.com.runbrain;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Assets {

    public static Bitmap[] arrow4;
    public static Bitmap[] arrowr;
    public static Bitmap[] arrowb;
    public static Bitmap[] images;
    public static Bitmap[] imagesGrandes;
    public static Bitmap botonSi;
    public static Bitmap botonNo;

    public static void createAssets(Context context, int width, int height){

        Resources resources = context.getResources();

        if(botonSi != null){
            botonSi.recycle();
        }

        if(botonNo != null){
            botonNo.recycle();
        }


        botonSi = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resources, R.drawable.botonsi),
                height, height, false);

        botonNo = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(resources, R.drawable.botonno),
                height, height, false);


        if (arrow4 != null) {
            for (Bitmap bitmap : arrow4)
                bitmap.recycle();
        }



        int[] arrowResources = {R.drawable.left,
                                R.drawable.up,
                                R.drawable.down,
                                R.drawable.right};

        arrow4 = new Bitmap[arrowResources.length];
        for (int i = 0; i < arrow4.length; i++) {
            arrow4[i] = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resources, arrowResources[i]),
                    height, height, false);
        }

        if (arrowr != null) {
            for (Bitmap bitmap : arrowr)
                bitmap.recycle();
        }

        int[] arrowResourcesr = {R.drawable.leftr,
                                 R.drawable.upr,
                                 R.drawable.downr,
                                 R.drawable.rightr};

        arrowr = new Bitmap[arrowResourcesr.length];
        for (int i = 0; i < arrowr.length; i++) {
            arrowr[i] = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resources, arrowResourcesr[i]),
                    height, height, false);
        }

        if (arrowb != null) {
            for (Bitmap bitmap : arrowb)
                bitmap.recycle();
        }

        int[] arrowResourcesb = {R.drawable.leftb,
                R.drawable.upb,
                R.drawable.downb,
                R.drawable.rightb};

        arrowb = new Bitmap[arrowResourcesb.length];
        for (int i = 0; i < arrowb.length; i++) {
            arrowb[i] = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resources, arrowResourcesb[i]),
                    height, height, false);
        }

        if (images != null) {
            for (Bitmap bitmap : images)
                bitmap.recycle();
        }

        int[] imagesResources = {R.drawable.amigosa,
                R.drawable.amigosb,
                R.drawable.amigosc,
                R.drawable.bosquea,
                R.drawable.bosqueb,
                R.drawable.bosquec,
                R.drawable.castilloa,
                R.drawable.castillob,
                R.drawable.castilloc,
                R.drawable.construcciona,
                R.drawable.construccionb,
                R.drawable.construccionc,
                R.drawable.floresa,
                R.drawable.floresb,
                R.drawable.floresc,
                R.drawable.pajaroa,
                R.drawable.pajarob,
                R.drawable.pajaroc,
                R.drawable.parquea,
                R.drawable.parqueb,
                R.drawable.parquec
        };

        images = new Bitmap[imagesResources.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resources, imagesResources[i]),
                    400, 400, false);
        }

        if (imagesGrandes != null) {
            for (Bitmap bitmap : imagesGrandes)
                bitmap.recycle();
        }

        int[] imagesResourcesGrandes = {R.drawable.amigosa,
                R.drawable.amigosb,
                R.drawable.amigosc,
                R.drawable.bosquea,
                R.drawable.bosqueb,
                R.drawable.bosquec,
                R.drawable.castilloa,
                R.drawable.castillob,
                R.drawable.castilloc,
                R.drawable.construcciona,
                R.drawable.construccionb,
                R.drawable.construccionc,
                R.drawable.floresa,
                R.drawable.floresb,
                R.drawable.floresc,
                R.drawable.pajaroa,
                R.drawable.pajarob,
                R.drawable.pajaroc,
                R.drawable.parquea,
                R.drawable.parqueb,
                R.drawable.parquec};

        imagesGrandes = new Bitmap[imagesResourcesGrandes.length];
        for (int i = 0; i < imagesGrandes.length; i++) {
            imagesGrandes[i] = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(resources, imagesResourcesGrandes[i]),
                    700, 750, false);
        }


    }

}
