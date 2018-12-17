package com.pmdm.t2ej2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void click2(View v){
        TextView t1 = findViewById(R.id.editText);
        TextView t2 = findViewById(R.id.editText2);

        Intent i=new Intent();
        if(t1.getText().toString() != null && !t1.getText().toString().equals("")){
            i.putExtra("TXT1",t1.getText().toString());
            setResult(RESULT_OK,i);
        }else if(t2.getText() != null ){
            i.putExtra("TXT1",Integer.parseInt(t2.getText().toString()));
            setResult(RESULT_CANCELED,i);
        }
        finish();
    }
}
