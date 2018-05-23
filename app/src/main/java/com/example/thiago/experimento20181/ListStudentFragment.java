package com.example.thiago.experimento20181;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListStudentFragment extends Fragment {
    private ArrayList<Student> students;
    private ArrayAdapter adapter;
    private ListView lvStudents;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_list_student, container, false);

        lvStudents = (ListView) view.findViewById(R.id.lv_students);

        FloatingActionButton btNew = (FloatingActionButton) view.findViewById(R.id.bt_new_student);

        btNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity(), FormStudentActivity.class);
                startActivity(it);
            }
        });

        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Intent it = new Intent(getActivity(),FormStudentActivity.class);
                it.putExtra("student", student);
                startActivity(it);
            }
        });

        return view;


    }

    @Override
    public void onResume() {
        super.onResume();
        StudentDAO dao = new StudentDAO(getActivity());
        students = (ArrayList<Student>) dao.getAllStudents();
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,students);
        lvStudents.setAdapter(adapter);
    }

}
