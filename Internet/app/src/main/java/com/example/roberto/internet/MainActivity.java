package com.example.roberto.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HttpURLConnectionPostProcessorInterface, View.OnClickListener {

    TextView textViewData, textViewProgress;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize(){
        textViewData = findViewById(R.id.textViewData);
        textViewProgress = findViewById(R.id.textViewProgress);

        btnLoad=findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }


    @Override
    public void successHandler(String dataInXML) {
        System.out.println("------------------------ successHandler: "+dataInXML);
        textViewData.setText(dataInXML);
    }

    @Override
    public void failureHandler(Exception exception) {
        System.out.println("------------------------ failureHandler: "+ exception);

    }

    @Override
    public void onClick(View v) {
        String muURLString = "https://www.w3schools.com/xml/simple.xml";

        AsynchronousHttpURLConnector asynchronousHttpURLConnector =
                new AsynchronousHttpURLConnector(this,muURLString,textViewProgress);

        asynchronousHttpURLConnector.execute();
    }
}
