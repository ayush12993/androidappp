package com.ayushm.movielist.task1;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ayushm.movielist.R;
import com.ayushm.movielist.task1.adapter.TaskAdapter;
import com.ayushm.movielist.task1.model.TaskModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Task1Activity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;

    TaskAdapter taskAdapter;

    ArrayList<TaskModel> taskModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        recyclerView = findViewById(R.id.recycler_view1);
        floatingActionButton = findViewById(R.id.btn_opendialog);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Task1Activity.this);
                dialog.setContentView(R.layout.add_something);

                EditText taskBody,taskTitle;
                Button submit;
                taskTitle = dialog.findViewById(R.id.taskHeadingTitle);
                taskBody = dialog.findViewById(R.id.taskHeadingBody);
                submit = dialog.findViewById(R.id.btn_Action);

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title="",body="";
                        if (!taskTitle.getText().toString().equals("")){
                        title = taskTitle.getText().toString();}
                        else {
                            Toast.makeText(Task1Activity.this,"Please Enter Title",Toast.LENGTH_SHORT).show();}
                        if (!taskBody.getText().toString().equals("")){
                            body = taskBody.getText().toString();}
                        else {
                            Toast.makeText(Task1Activity.this,"Please Enter Body",Toast.LENGTH_SHORT).show();}
                    taskModels.add(new TaskModel(title,body));
                                           taskAdapter.notifyItemInserted(taskModels.size()-1);
                        recyclerView.scrollToPosition(taskModels.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(Task1Activity.this));
        taskAdapter = new TaskAdapter(Task1Activity.this,taskModels);
        recyclerView.setAdapter(taskAdapter);

    }
}