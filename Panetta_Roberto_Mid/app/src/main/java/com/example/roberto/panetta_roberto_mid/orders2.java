package com.example.roberto.panetta_roberto_mid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class orders2 extends AppCompatActivity {

    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders2);     initialize();
        myGetIntent();
    }

    public void initialize(){

        textView = findViewById(R.id.tvName);
        textView2 = findViewById(R.id.tvOrders);
    }
    private void myGetIntent(){
        String client = getIntent().getStringExtra("Name");
        String order = getIntent().getStringExtra("Item");
        textView.setText(client);
        textView2.setText(order);
    }

    public void btnBack(View view){
        Toast.makeText(this, "Thank you for using our application " + textView.getText().toString() , Toast.LENGTH_LONG).show();
        finish();
    }
}
