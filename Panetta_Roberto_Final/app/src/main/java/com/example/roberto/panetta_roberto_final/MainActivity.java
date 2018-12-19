package com.example.roberto.panetta_roberto_final;

import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd, btnRemove, btnUpdate, btnShow, btnSave, btnLoad, btnClear;
    EditText etAccountNum, etDate, etBalance, etName, etFamily, etPhone, etSIN;

    ArrayList<Customer> custList = new ArrayList<>();
    int acntNumber, sin;
    Date openDate;
    double balance;
    String FName, LName, PhoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        etAccountNum = findViewById(R.id.etAccountNum);
        etDate = findViewById(R.id.etOpenDate);
        etBalance = findViewById(R.id.etBalance);
        etName = findViewById(R.id.etName);
        etFamily = findViewById(R.id.etFamily);
        etPhone = findViewById(R.id.etPhone);
        etSIN = findViewById(R.id.etSIN);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        
        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(this);
        
        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
        
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        switch(btnId){
            case R.id.btnAdd:
                addAccount();
                break;
            case R.id.btnRemove:
                removeCustomer();
                break;
            case R.id.btnUpdate:
                updateCust();
                break;
            case R.id.btnShow:
                showList();
                break;
            case R.id.btnSave:
                saveEntries();
                break;
            case R.id.btnLoad:
                loadRecent();
                break;
            case R.id.btnClear:
                clearAll();
                break;
        }

    }

    private void clearAll() {
        etAccountNum.setText(null);
        etDate.setText(null);
        etBalance.setText(null);
        etName.setText(null);
        etFamily.setText(null);
        etPhone.setText(null);
        etSIN.setText(null);
    }

    private void loadRecent() {
    }

    private void saveEntries() {
    }

    private void showList() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("customers", custList);

        Intent myIntent = new Intent(this,List.class);
        myIntent.putExtra("IntentKey",bundle);
        startActivity(myIntent);
    }

    private void updateCust() {
        for(Customer x : custList){
            if(x.getSIN() == Integer.parseInt(etSIN.getText().toString())){
                balance = Double.parseDouble(etBalance.getText().toString());
                FName = etName.getText().toString();
                LName = etFamily.getText().toString();
                PhoneNo = etPhone.getText().toString();

                x.getAccount().setBalance(balance);
                x.setName(FName);
                x.setFamily(LName);
                x.setPhoneNo(PhoneNo);
            }
        }
    }

    private void removeCustomer() {
        for(Customer x : custList){
            if(x.getSIN() == Integer.parseInt(etSIN.getText().toString())){
                custList.remove(x);
            }else{
                return;
            }
        }
    }

    private void addAccount() {
        if(etAccountNum.getText() == null || etDate.getText() == null|| etBalance.getText() == null || etName.getText() == null
                || etFamily.getText() ==null || etPhone.getText()==null|| etSIN.getText() ==null){
            return;
        }else{
            acntNumber = Integer.parseInt(etAccountNum.getText().toString());
            try{
            openDate = new SimpleDateFormat("MM/dd/yyyy").parse(etDate.getText().toString());}
            catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
            balance = Double.parseDouble(etBalance.getText().toString());
            Account x = new Account(acntNumber,openDate,balance);
            FName = etName.getText().toString();
            LName = etFamily.getText().toString();
            PhoneNo = etPhone.getText().toString();
            sin = Integer.parseInt(etSIN.getText().toString());

            Customer y = new Customer(x,FName,LName,PhoneNo,sin);
            custList.add(y);
            Toast.makeText(this,"Account: "+x.getAccountNumber()+"\nHas been added!",Toast.LENGTH_SHORT).show();

        }
    }
}
