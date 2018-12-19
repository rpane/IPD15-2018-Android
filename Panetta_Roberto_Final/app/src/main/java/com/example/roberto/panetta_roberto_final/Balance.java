package com.example.roberto.panetta_roberto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Balance extends AppCompatActivity implements View.OnClickListener{

    TextView tvBalance;
    EditText etWithdraw;
    Button btnWithdraw;
    int position;
    ArrayList<Customer> balanceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        initialize();
    }
    private void initialize(){
        tvBalance = findViewById(R.id.tvBalance);

        etWithdraw = findViewById(R.id.etAmount);

        btnWithdraw = findViewById(R.id.btnWithdraw);
        btnWithdraw.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("IntentKey");
        position = getIntent().getIntExtra("position",0);
        Serializable bundledInputs = bundle.getSerializable("customers");

        balanceList = (ArrayList<Customer>) bundledInputs;
        tvBalance.setText(balanceList.get(position).getAccount().getBalance()+"");

    }

    @Override
    public void onClick(View v) {

        int butId = v.getId();
        switch(butId){
            case R.id.btnWithdraw:
                newBalance();
                break;
        }
    }

    private void newBalance() {
        double currentBal = Double.parseDouble(tvBalance.getText().toString());
        double amountWithdrawn = Double.parseDouble(etWithdraw.getText().toString());
        double newBalance = currentBal - amountWithdrawn;

        tvBalance.setText(newBalance+"");

        Toast.makeText(this,"$"+amountWithdrawn+" Has been withdrawn from\n Account:"+balanceList.get(position).getAccount().getAccountNumber(),Toast.LENGTH_SHORT).show();
    }
}
