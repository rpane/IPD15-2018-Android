package com.example.roberto.numsum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize(){
         editText = findViewById(R.id.editText);
         editText2 = findViewById(R.id.editText2);
    }

    public void doSum(View view){
        String editText_string = editText.getText().toString();
        String editText2_string = editText2.getText().toString();

        int editText_int = Integer.valueOf(editText_string);
        int editText2_int = Integer.valueOf(editText2_string);

        int sum = editText_int + editText2_int;

        Toast.makeText(this, String.valueOf(sum), Toast.LENGTH_LONG).show();
    }
}
