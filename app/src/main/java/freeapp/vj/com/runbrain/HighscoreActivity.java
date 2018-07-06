package freeapp.vj.com.runbrain;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class HighscoreActivity extends AppCompatActivity {


    TextView aciertosI;
    TextView aciertosW;
    TextView aciertosA;
    TextView fallosI;
    TextView fallosW;
    TextView fallosA;;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        aciertosI = (TextView) findViewById(R.id.aciertosI);
        aciertosW = (TextView) findViewById(R.id.aciertosW);
        aciertosA = (TextView) findViewById(R.id.aciertosA);
        fallosI = (TextView) findViewById(R.id.fallosI);
        fallosW = (TextView) findViewById(R.id.fallosW);
        fallosA = (TextView) findViewById(R.id.fallosA);

        sharedPreferences  = getSharedPreferences("highScore", Context.MODE_PRIVATE);
        aciertosI.setText(""+sharedPreferences.getInt("imageAciertos",0));
        fallosI.setText(""+sharedPreferences.getInt("imageFallos",0));
        aciertosW.setText(""+sharedPreferences.getInt("wordAciertos",0));
        fallosW.setText(""+sharedPreferences.getInt("wordFallos",0));
        aciertosA.setText(""+sharedPreferences.getInt("arrowAciertos",0));
        fallosA.setText(""+sharedPreferences.getInt("arrowFallos",0));

    }


}
