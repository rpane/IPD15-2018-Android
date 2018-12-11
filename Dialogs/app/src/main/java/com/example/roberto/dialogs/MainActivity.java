package com.example.roberto.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        button1 = findViewById(R.id.button);
    }


    public void showAlertDialog1(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Button 1 Dialog");

        alertDialogBuilder.setPositiveButton("Yes", this);
        alertDialogBuilder.setNegativeButton("No", this);
        alertDialogBuilder.setNeutralButton("Cancel", this);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                System.out.println("--------- Clicked button id: " + which);
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                System.out.println("----------- Clicked button id " + which);
                break;

            case DialogInterface.BUTTON_NEUTRAL:
                System.out.println("----------- Clicked button id " + which);
                break;

        }
    }

    public void showAlertDialog2(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog")
                .setMessage("Do you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"File Deleted!", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel", null);
        builder.show();

    }


    public void showAlertDialog3(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Question?")
                .setCancelable(false)
                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"}, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "i = " +which,Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK",null);
        builder.show();
    }

    public void showAlertDialog4(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"},
                        new boolean[]{false, true, false, true, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(MainActivity.this,
                                        "item"+ which +" : "+isChecked,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("Ok", null);
        builder.show();
    }

    public void showAlertDialog5(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setCancelable(true);

        progressDialog.setTitle("Progress Dialog Test");
        progressDialog.setMessage("Please wait...");

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.show();

        progressDialog.setProgress(0);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress()<progressDialog.getMax()){
                    progressDialog.incrementProgressBy(1);
                }else{
                    progressDialog.dismiss();
                }
            }
        },0,200);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getSecondaryProgress()<progressDialog.getMax()){
                    progressDialog.incrementSecondaryProgressBy(1);
                }
            }
        },0,140);

    }

    public void customDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_main);
        dialog.show();
    }

    public void loadWeb(View view) {
        Intent myIntent = new Intent(this,webView.class);
        startActivity(myIntent);
    }
}
