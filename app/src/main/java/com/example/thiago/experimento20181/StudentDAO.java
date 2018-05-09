package com.example.thiago.experimento20181;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends SQLiteOpenHelper {

    public StudentDAO(Context context) {
        super(context, "Schedule", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Student( name TEXT, email TEXT, phone TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP table Student;";
        db.execSQL(sql);
        onCreate(db);
    }


    public void insert(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",student.getName());
        cv.put("email", student.getEmail());
        cv.put("phone", student.getPhone());
        db.insert("Student",null,cv);
        db.close();
    }

    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM Student;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Student> students = new ArrayList<Student>();
        while (cursor.moveToNext()){
            Student student = new Student();
            student.setName(cursor.getString(cursor.getColumnIndex("name")));
            student.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            student.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            students.add(student);
        }
        db.close();
        return students;
    }
}
