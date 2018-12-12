package com.pmdm.t2ej2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int SELECCIONA_TXT_NUM = 1;
    public static final int SELECCIONA_BOOL_LISTSTRING = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsado(View v){
        if(v.getId() == R.id.button){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivityForResult(intent,SELECCIONA_TXT_NUM);
        }else{
            Intent intent = new Intent(this, Main3Activity.class);
            startActivityForResult(intent,SELECCIONA_BOOL_LISTSTRING);
        }

    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data)
    {
        TextView t=(TextView)findViewById(R.id.textView);

        if (requestCode == SELECCIONA_TXT_NUM) {
            if (resultCode == RESULT_OK) {
                t.setText("Se ha seleccionado: texto \n"+data.getStringExtra("TXT1"));
            }else{
                t.setText("Se ha seleccionado: num \n"+data.getIntExtra("TXT1",0));
            }
        }else if(requestCode == SELECCIONA_BOOL_LISTSTRING){
            if (resultCode == RESULT_OK) {
                ArrayList<String> lista = data.getStringArrayListExtra("TXT1");
                String salida = "";
                for(String parte : lista){
                    salida += parte;
                }
                t.setText("Se ha seleccionado: array \n"+salida);
            }else{
                t.setText("Se ha seleccionado: bool \n"+data.getBooleanExtra("TXT1",false));
            }
        }
    }



}
