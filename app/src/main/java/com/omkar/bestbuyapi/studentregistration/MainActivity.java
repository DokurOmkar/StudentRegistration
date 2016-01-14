package com.omkar.bestbuyapi.studentregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.omkar.bestbuyapi.model.Student;

public class MainActivity extends AppCompatActivity {
    EditText studentName, studentMarks, studentClass;
    Button submit, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName = (EditText) findViewById(R.id.editText);
        studentMarks = (EditText) findViewById(R.id.editText2);
        studentClass = (EditText) findViewById(R.id.editText3);
        submit = (Button) findViewById(R.id.submit);
        details = (Button) findViewById(R.id.button2);

    }

    public void submit(View view){
        Student student=new Student();
        student.setStudentName(studentName.getText().toString());
        student.setStudentMarks(studentMarks.getText().toString());
        student.setStudentClass(studentClass.getText().toString());
        (new SqliteHelper(getApplicationContext())).createStudentDetails(student);
    }

    public void details(View view){
        Intent intent=new Intent(MainActivity.this, DetailsActivity.class);
        startActivity(intent);

    }
}
