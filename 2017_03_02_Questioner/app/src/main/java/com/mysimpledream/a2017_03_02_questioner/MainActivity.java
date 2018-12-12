package com.mysimpledream.a2017_03_02_questioner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mysimpledream.a2017_03_02_questioner.Model.Client;
import com.mysimpledream.a2017_03_02_questioner.Model.DataCollection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextClientNumber, editTextClientEmail;

    RadioButton radioButtonAdventure, radioButtonAction, radioButtonComedy;
    RadioGroup radioGroup;

    Button ClearBtn, AddBtn, RemoveBtn, UpdateBtn, ShowBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        editTextClientNumber = (EditText) findViewById(R.id.EditTextClientNumber);
        editTextClientEmail = (EditText) findViewById(R.id.EditTextClientEmail);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioButtonAdventure = (RadioButton) findViewById(R.id.radioButtonAdventure);
        radioButtonAction = (RadioButton) findViewById(R.id.radioButtonAction);
        radioButtonComedy = (RadioButton) findViewById(R.id.radioButtonComedy);


        ClearBtn = (Button) findViewById(R.id.ClearBtn);
        ClearBtn.setOnClickListener(this);

        AddBtn = (Button) findViewById(R.id.AddBtn);
        AddBtn.setOnClickListener(this);

        RemoveBtn = (Button) findViewById(R.id.RemoveBtn);
        RemoveBtn.setOnClickListener(this);

        UpdateBtn = (Button) findViewById(R.id.UpdateBtn);
        UpdateBtn.setOnClickListener(this);

        ShowBtn = (Button) findViewById(R.id.ShowBtn);
        ShowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.ClearBtn:
                clear();
                break;

            case R.id.AddBtn:
                add();
                break;

            case R.id.RemoveBtn:
                remove();
                break;

            case R.id.UpdateBtn:
                update();
                break;

            case R.id.ShowBtn:
                show();
                break;
        }
    }

    private void clear() {
        editTextClientEmail.setText(null);
//        editTextClientNumber.setText(null);
    }

    private void add() {

        int clientNumber = Integer.valueOf(editTextClientNumber.getText().toString());
        String clientEmail = editTextClientEmail.getText().toString();
        String selectedRadioGroup = "";

        if (radioButtonAdventure.isChecked()) {
            selectedRadioGroup = radioButtonAdventure.getTag().toString();

            System.out.println(radioButtonAdventure.getTag().toString());
            System.out.println(selectedRadioGroup);

        } else if (radioButtonAction.isChecked()) {
            selectedRadioGroup = radioButtonAction.getTag().toString();

        } else if (radioButtonComedy.isChecked()) {
            selectedRadioGroup = radioButtonComedy.getTag().toString();
        }
        System.out.println("clientNumber: " + clientNumber + "     clientEmail: " + clientEmail + "    selectRadioGroup: " + selectedRadioGroup );

        Client client = new Client(clientNumber, clientEmail, selectedRadioGroup);
//        System.out.println(client.toString());

        DataCollection.clientArray.add(client);
//        System.out.println(DataCollection.clientArray);

        Toast.makeText(this, client.getClientNumber() + " added successfully", Toast.LENGTH_SHORT).show();
    }

    private void remove() {

        if (findClient() >= 0) {
            DataCollection.clientArray.remove(findClient());
            Toast.makeText(this, "Client removed", Toast.LENGTH_SHORT).show();
        }
    }

    private void update() {

        if (findClient() >= 0) {
            DataCollection.clientArray.get(findClient()).setEmail(editTextClientEmail.getText().toString());
            Toast.makeText(this, "Client email updated", Toast.LENGTH_SHORT).show();
        }
    }

    private void show() {
        Intent intent = new Intent(this, ShowClient.class);
        startActivity(intent);
    }

    private int findClient() {
        //----------------------------------------- Detect client number in edit Text field
        int clientNumber = Integer.valueOf(editTextClientNumber.getText().toString());
        boolean found = false;

        //----------------------------------------- Iterate on clint array
        for (Client oneClient : DataCollection.clientArray) {
            //----------------------------------------- Check each client for client number
            if (oneClient.getClientNumber() == clientNumber) {
                found = true;
//                System.out.println(DataCollection.clientArray);
                return DataCollection.clientArray.indexOf(oneClient);
            }
        }
        if (!found)
            Toast.makeText(this, "not found", Toast.LENGTH_SHORT).show();
        return -1;
    }
}
