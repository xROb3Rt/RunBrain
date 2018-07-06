package freeapp.vj.com.runbrain;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class InstructionDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstancesState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Instrucciones para cada mini-juego")
                .setMessage("Images: Memoriza las imagenes para responder correctamente.\n" +
                        "Arrows: Indica la direccion de la flecha central utilizando los botones.\n" +
                        "Words: Memoriza la lista de palabras para acertar.\n")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });

        return builder.create();

    }

}
