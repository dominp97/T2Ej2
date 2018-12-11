package com.pmdm.t2ej2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click(View v){
        Intent i=new Intent();
        //i.putExtra("PROVINCIA",a.getItemAtPosition(position).toString());
        setResult(RESULT_OK,i);
        finish();
    }
}
