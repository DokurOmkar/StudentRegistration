package com.omkar.bestbuyapi.studentregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.omkar.bestbuyapi.model.Student;

public class UpdateActivity extends AppCompatActivity {
    EditText studentName, studentMarks, studentClass;
    Button update;
    Student student;
    Student mainStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        mainStudent=(Student)getIntent().getSerializableExtra("id");

        studentName = (EditText) findViewById(R.id.editText);
        studentMarks = (EditText) findViewById(R.id.editText2);
        studentClass = (EditText) findViewById(R.id.editText3);
        update = (Button) findViewById(R.id.update);

        studentName.setText(mainStudent.getStudentName());
        studentMarks.setText(mainStudent.getStudentMarks());
        studentClass.setText(mainStudent.getStudentClass());

    }

    public void update (View view){
        Student student = new Student();
        student.setStudentName(studentName.getText().toString());
        student.setStudentClass(studentClass.getText().toString());
        student.setStudentMarks(studentMarks.getText().toString());

        (new SqliteHelper(getApplicationContext())).updateStudent(student, mainStudent.getStudentId());
        Toast.makeText(UpdateActivity.this, "Updated successfully", Toast.LENGTH_LONG).show();
    }
}
