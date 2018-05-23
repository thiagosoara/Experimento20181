package com.example.thiago.experimento20181;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class StudentFormFragment extends Fragment {
    private static final String STUDENT = "student";

    private Student student;
    private TextInputEditText etPhone;
    private TextInputEditText etName;
    private TextInputEditText etEmail;


    public StudentFormFragment() {
        // Required empty public constructor
    }

    public static StudentFormFragment newInstance(Student student) {
        StudentFormFragment fragment = new StudentFormFragment();
        Bundle args = new Bundle();
        args.putSerializable(STUDENT, student);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            student = (Student) getArguments().getSerializable(STUDENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_form, container, false);

        etName = (TextInputEditText) view.findViewById(R.id.et_name);
        etEmail = (TextInputEditText) view.findViewById(R.id.et_email);
        etPhone = (TextInputEditText) view.findViewById(R.id.et_phone);

        Button btSave = (Button)view.findViewById(R.id.bt_save);

        if (student != null){
            etName.setText(student.getName());
            etEmail.setText(student.getEmail());
            etPhone.setText(student.getPhone());
        }

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName(etName.getText().toString());
                student.setEmail(etEmail.getText().toString());
                student.setPhone(etPhone.getText().toString());
                StudentDAO dao = new StudentDAO(getActivity());
                dao.insert(student);
                /*Intent it = getIntent();
                it.putExtra("student",student);
                setResult(RESULT_OK, it);*/
                getActivity().finish();
            }
        });

        return view;
    }

}
