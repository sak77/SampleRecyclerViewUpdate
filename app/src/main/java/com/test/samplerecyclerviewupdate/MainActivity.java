package com.test.samplerecyclerviewupdate;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.test.samplerecyclerviewupdate.dummy.DummyContent;

import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentFragment.OnListFragmentInteractionListener, ControlFragment.OnFragmentInteractionListener {

    int new_user_index=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().getFragments().size()==0){
            setUI();
        }
    }

    private void setUI(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frm_list, StudentFragment.newInstance(1),"list");
        fragmentTransaction.add(R.id.frm_control, ControlFragment.newInstance("",""),"control");
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(StudentDao item) {

    }

    @Override
    public void onFragmentInteraction(Boolean isAdd) {
        StudentFragment studentFragment = (StudentFragment) getSupportFragmentManager().findFragmentByTag("list");
        if (isAdd){
            //add new item to list
            StudentDao newStudent = new StudentDao();
            newStudent = new StudentDao();
            newStudent.student_name = "New Student "+new_user_index++;
            newStudent.student_class = new_user_index;
            newStudent.age = 12;
            newStudent.studenid = new_user_index;
            studentFragment.addStudent(newStudent);
        }else {

            //studentFragment.removeStudent();
        }
    }
}
