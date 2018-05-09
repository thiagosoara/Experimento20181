package com.example.thiago.experimento20181;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.Normalizer;
import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {

    private static final int NEW_STUDENT_REQUEST_CODE = 1;
    private ListView lvStudents;
    private ArrayList<Student> students;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        lvStudents = (ListView) findViewById(R.id.lv_students);
        /*if (savedInstanceState != null){
            students = (ArrayList<Student>) savedInstanceState.getSerializable("students");
        }else{
            students = new ArrayList<Student>();
        }
*/

        FloatingActionButton btNew = (FloatingActionButton) findViewById(R.id.bt_new_student);

        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ListStudentActivity.this, FormStudentActivity.class);
                startActivityForResult(it, NEW_STUDENT_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAO(this);
        students = (ArrayList<Student>) dao.getAllStudents();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,students);
        lvStudents.setAdapter(adapter);
    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("students", students);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == NEW_STUDENT_REQUEST_CODE){
                Student student = (Student) data.getSerializableExtra("student");
                students.add(student);
                adapter.notifyDataSetChanged();
            }
        }
    }*/
}
