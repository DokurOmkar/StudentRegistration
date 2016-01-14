package com.omkar.bestbuyapi.studentregistration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.omkar.bestbuyapi.model.Student;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by omkardokur on 12/19/15.
 */
public class DetailsActivity extends Activity {

    ArrayList<Student> studentsList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        listView = (ListView) findViewById(R.id.listView);
        updateAdapter();

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(DetailsActivity.this, UpdateActivity.class);
//                intent.putExtra("id",  studentsList.get(position));
//            }
//        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateAdapter();
    }

    public void updateAdapter() {
        studentsList = (new SqliteHelper(getApplicationContext())).getStudentDetails();
        DetailsAdapter adapter=new DetailsAdapter(DetailsActivity.this,studentsList);
        listView.setAdapter(adapter);
    }
}
