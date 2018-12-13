package ca.masoudbozorgi.johnabbott_ipd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.masoudbozorgi.johnabbott_ipd.asynchronousHttpURLConnector.URLConnectorActivity;
import ca.masoudbozorgi.johnabbott_ipd.db.DBManager;
import ca.masoudbozorgi.johnabbott_ipd.db.DB_CRUD_Test;
import ca.masoudbozorgi.johnabbott_ipd.internet.InternetActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button listViewBtn, fileBtn, dialogBtn, internetBtn, broadcastBtn, dbBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {

        listViewBtn = findViewById(R.id.listViewBtn);
        listViewBtn.setOnClickListener(this);

        fileBtn = findViewById(R.id.fileBtn);
        fileBtn.setOnClickListener(this);

        dialogBtn = findViewById(R.id.dialogBtn);
        dialogBtn.setOnClickListener(this);

        internetBtn = findViewById(R.id.internetBtn);
        internetBtn.setOnClickListener(this);

        broadcastBtn = findViewById(R.id.broadcastBtn);
        broadcastBtn.setOnClickListener(this);

        dbBtn = findViewById(R.id.dbBtn);
        dbBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.listViewBtn:
                startActivity(new Intent(this,ListViewActivity.class));
                break;
            case R.id.fileBtn:
                startActivity(new Intent(this, FileActivity.class));
                break;
            case R.id.dialogBtn:
                startActivity(new Intent(this, AlertDialogueActivity.class));
                break;
            case R.id.internetBtn:
                startActivity(new Intent(this, InternetActivity.class));
//                startActivity(new Intent(this, URLConnectorActivity.class));
                break;
            case R.id.dbBtn:
                // Manually must be added to AndroidManifest.xml
                // <application
                //        android:name=".db.DBManager"
                // </application>
                DBManager dbManager = (DBManager) getApplication();
                new DB_CRUD_Test(dbManager);
                break;
            case R.id.broadcastBtn:
                startActivity(new Intent(this, URLConnectorActivity.class));
                break;
        }
    }
}
