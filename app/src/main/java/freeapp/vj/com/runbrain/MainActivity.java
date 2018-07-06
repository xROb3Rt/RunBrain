package freeapp.vj.com.runbrain;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import freeapp.vj.com.runbrain.framework.arrowsLevel.ArrowsActivity;
import freeapp.vj.com.runbrain.framework.figuresLevel.FiguresActivity;
import freeapp.vj.com.runbrain.framework.wordsLevel.WordsActivity;

public class MainActivity extends AppCompatActivity {

    private Button figures;
    private Button words;
    private Button arrows;
    private Button highscore;
    private Button instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        figures = (Button) findViewById(R.id.buttonFigures);
        figures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                figures(view);
            }
        });

        words = (Button) findViewById(R.id.buttonWords);
        words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                words(view);
            }
        });

        arrows = (Button) findViewById(R.id.buttonArrows);
        arrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrows(view);
            }
        });

        highscore = (Button) findViewById(R.id.buttonHighscore);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highscore(view);
            }
        });

        instruction = (Button) findViewById(R.id.buttonInstruction);
        instruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                instruction(view);
            }
        });
    }

    public void figures(View view){

        Intent intent = new Intent(this, FiguresActivity.class);
        startActivity(intent);

    }

    public void words(View view){

        Intent intent = new Intent(this, WordsActivity.class);
        startActivity(intent);

    }

    public void arrows(View view){

        Intent intent = new Intent(this, ArrowsActivity.class);
        startActivity(intent);

    }

    public void highscore(View view){

        Intent intent = new Intent(this, HighscoreActivity.class);
        startActivity(intent);

    }

    public void instruction(View view){

        InstructionDialog instructionDialog = new InstructionDialog();
        instructionDialog.show(getSupportFragmentManager(),"");

    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you really want to exit the game?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent main = new Intent(Intent.ACTION_MAIN);
                        main.addCategory(Intent.CATEGORY_HOME);
                        startActivity(main);
                    }
                });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
