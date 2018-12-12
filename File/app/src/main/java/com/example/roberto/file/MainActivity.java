package com.example.roberto.file;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button writeStringPrivate, readStringPrivate, writeStringPublic, readStringPublic,
    writeObjectPrivate, readObjectPrivate;
    EditText editText;

    int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        storagePermissionRequest();
        
        createFileInExternalStoragePrivateDirectory();
    }

    private void createFileInExternalStoragePrivateDirectory() {
    }

    private void initialize(){
        editText = findViewById(R.id.editText);

        writeStringPrivate = findViewById(R.id.writeStringPrivate);
        writeStringPrivate.setOnClickListener(this);

        readStringPrivate = findViewById(R.id.readStringPrivate);
        readStringPrivate.setOnClickListener(this);

        writeStringPublic = findViewById(R.id.writeStringPublic);
        writeStringPublic.setOnClickListener(this);

        readStringPublic = findViewById(R.id.readStringPublic);
        readStringPublic.setOnClickListener(this);

        writeObjectPrivate = findViewById(R.id.writeObjectPrivate);
        writeObjectPrivate.setOnClickListener(this);

        readObjectPrivate = findViewById(R.id.button6);
        readObjectPrivate.setOnClickListener(this);


    }

    private void storagePermissionRequest(){
        ActivityCompat.requestPermissions(this,
                new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
                REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_DENIED){
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
            else Toast.makeText(this,"Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.writeStringPrivate:
                FileManager.saveByte(file_string_private_external_storage, editText.getText().toString());
                break;
            case R.id.readStringPrivate:
                editText.setText();
        }
    }
}
