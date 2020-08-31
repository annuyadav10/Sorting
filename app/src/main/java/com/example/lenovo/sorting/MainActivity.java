package com.example.lenovo.sorting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   JSONObject jsonObject=new JSONObject();
    JSONArray jsonArray;
   Model model;
   List<Model>list;
   RecyclerView recyclerView;
   Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        list=new ArrayList<>();
        try {
            jsonObject.put("id","4");
            jsonObject.put("name","abc");
            jsonObject.put("id","10");
            jsonObject.put("id","ab2");
            jsonObject.put("id","5");
            jsonObject.put("id","abc3");
            jsonObject.put("id","6");
            jsonObject.put("id","abc5");

            model=new Model();
              model.setid(jsonObject.getString("id"));
              model.setid(jsonObject.getString("name"));
                list.add(model);
             Collections.sort(list, new Comparator<Model>() {
                 @Override
                 public int compare(Model o1, Model o2) {
                     return o1.getid().compareToIgnoreCase(o2.getid());
                 }
             });

            adapter=new Adapter(list,getApplicationContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setHasFixedSize(true);
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}