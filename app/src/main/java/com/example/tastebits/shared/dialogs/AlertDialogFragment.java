package com.example.tastebits.shared.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class AlertDialogFragment extends DialogFragment {
    DialogInterface.OnClickListener callback;
    String text;
    String title;
    public AlertDialogFragment(String title,String text,DialogInterface.OnClickListener callback){
        this.callback = callback;
        this.text = text;
        this.title = title;
    }
    public AlertDialogFragment(String title,String text){
        this.callback = null;
        this.text = text;
        this.title = title;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.text)
                .setTitle(this.title);
        if (this.callback != null){
            builder.setPositiveButton("OK",callback);
        }else{
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }

        return builder.create();
    }
}