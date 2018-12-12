package com.mysimpledream.a2017_03_02_questioner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mysimpledream.a2017_03_02_questioner.Model.Client;
import com.mysimpledream.a2017_03_02_questioner.Model.DataCollection;

public class ShowClient extends AppCompatActivity {

    RadioButton radioBtnAdventure, radioBtnAction, radioBtnComedy, radioBtnAll;
    Button ListBtn;
    TextView textViewClients;

    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client);

        Initialize();
    }

    private void Initialize() {

        // RadioGroup
        radioBtnAdventure = (RadioButton) findViewById(R.id.radioBtnAdventure);
        radioBtnAction = (RadioButton) findViewById(R.id.radioBtnAction);
        radioBtnComedy = (RadioButton) findViewById(R.id.radioBtnComedy);
        radioBtnAll = (RadioButton) findViewById(R.id.radioBtnAll);

        ListBtn = (Button) findViewById(R.id.ListBtn);

        textViewClients = (TextView) findViewById(R.id.textViewClients);
    }


    public void showListOfClients(View view) {

        if (radioBtnAdventure.isChecked())
            iterateByType("adv");

        else if (radioBtnAction.isChecked())
            iterateByType("action");

        else if (radioBtnComedy.isChecked())
            iterateByType("comedy");

        else if (radioBtnAll.isChecked())
            iterateByType("all");

        textViewClients.setText(str);
    }


    void iterateByType(String myType) {
        str = "";
        for (Client oneClient : DataCollection.clientArray) {
            if (myType.equals("all")) {
                str = str + oneClient;
            } else if (oneClient.getType().equals(myType)) {
                str = str + oneClient;
            }
        }
    }
}
