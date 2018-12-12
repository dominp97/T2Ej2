package com.pmdm.t2ej2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements ListView.OnItemClickListener{


    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lista = new ArrayList<String>();
        String [] elementos={"Toledo","Ciudad Real","Cuenca","Guadalajara","Albacete"};
        ArrayAdapter<String> adaptador;
        ListView l=(ListView)findViewById(R.id.listView);
        l.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,elementos);
        l.setAdapter(adaptador);
        l.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> a, View view, int position, long id){
        ListView l=(ListView)findViewById(R.id.listView);
        SparseBooleanArray checked = l.getCheckedItemPositions();
        for(int i=0;i<checked.size();i++)
            if(checked.valueAt(i) && !lista.contains(a.getItemAtPosition(checked.keyAt(i)).toString()) ){
                lista.add(a.getItemAtPosition(checked.keyAt(i)).toString());
            }
    }

    public void click(View v){
        Intent i=new Intent();
        if(!lista.isEmpty()){
            //i.putExtra("TXT1",lista);
            i.putStringArrayListExtra("TXT1",lista);
            setResult(RESULT_OK,i);
        }else{
            CheckBox cb = findViewById(R.id.checkBox);
            i.putExtra("TXT1",cb.isChecked());
            setResult(RESULT_CANCELED,i);
        }
        finish();
    }
}
