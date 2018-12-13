package ca.masoudbozorgi.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    private  static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }


    //AlertDialog.Builder onClick ------------------------------------------------------------------
    public void showAlertDialog1(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // Options ---------------------------------------
        alertDialogBuilder.setTitle("This is my title");

        // Second argument in below methods is a reference to event listener
        alertDialogBuilder.setPositiveButton("Yes", this);
        alertDialogBuilder.setNegativeButton("No", this);
        alertDialogBuilder.setNeutralButton("Neutral", this);
        // -----------------------------------------------

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    // implements DialogInterface.OnClickListener in current Activity
    @Override
    public void onClick(DialogInterface dialog, int which) {

        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                System.out.println("------------ Clicked button id: " + which);
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                System.out.println("------------ Clicked button id: " + which);
                break;

            case DialogInterface.BUTTON_NEUTRAL:
                System.out.println("------------ Clicked button id: " + which);
                break;
        }
    }
    //----------------------------------------------------------------------------------------------


    public void showAlertDialog2(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 2
        builder.setTitle("AlertDialog")
                .setMessage("Do you want to delete this file?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_info)

                // We just define event listener for yes button,
                // but it can be defined for 'No' and 'Cancel' as well
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,
                                "File Deleted!",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .setNeutralButton("Cancel", null);

        builder.show();
    }

    // Radio Group
    public void showAlertDialog3(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 3
        builder.setTitle("Question ?")
                .setCancelable(false)
                .setSingleChoiceItems(new String[]{"A", "B", "C", "D"},
                        2, // -1
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(DialogActivity.this,
                                "i = " + i,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("OK", null);

        builder.show();
    }

    public void showAlertDialog4(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // type 4
        builder.setTitle("")
                .setCancelable(true)
                .setMultiChoiceItems(new String[]{"item0", "item1", "item2", "item3", "item4", "item5"},
                        new boolean[]{false, true, false, true, true, false},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                Toast.makeText(DialogActivity.this,
                                        "item" + i + " : " + b,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                .setPositiveButton("Ok", null);

        builder.show();
    }


    // This method is called by onClick
    public void showProgressDialog(View view) {

        // 1- Create a ProgressDialog object
        final ProgressDialog progressDialog = new ProgressDialog(this);

        // 1-1- Disable ability to dismiss progress dialog
        //progressDialog.setCancelable(false);
        progressDialog.setTitle("progress dialog example");
        progressDialog.setMessage("please wait ...");

        // 1-2- By removing this line the default style will be used which is Spinner
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        // 2- Show the ProgressDialog
        // We can use this line when we do not know when the progress will be finished
        // For activating this line simulator code must be disabled
//        progressDialog.setIndeterminate(true);
        progressDialog.show();


        // Instead of timer, create an indeterminate progress
        //progressDialog.setIndeterminate(true);

        // Create a simulator to start the progress from 0 and increase to 100
        progressDialog.setProgress(0);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                progressDialog.dismiss();
//            }
//        }, 3000L);


        // Change the progress in the specific time interval
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // progressDialog.getMax() is 100 %
                if (progressDialog.getProgress() < progressDialog.getMax()) {
                    // Increase progress 1 % in each 200 ms
                    progressDialog.incrementProgressBy(1);
                } else {
                    // progressDialog.getMax() = 100 % dismiss progressDialog
                    progressDialog.dismiss();
                    this.cancel();
                }
            }
        }, 0, 200); // Each 200 ms run method will be called


        // Secondary progress can be used to show caching data
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progressDialog.getSecondaryProgress() < progressDialog.getMax()) {
                    progressDialog.incrementSecondaryProgressBy(1);
                }
            }
        }, 0, 140);

    }

}