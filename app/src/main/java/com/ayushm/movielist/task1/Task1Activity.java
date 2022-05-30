package com.ayushm.movielist.task1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ayushm.movielist.R;
import com.ayushm.movielist.task1.adapter.TaskAdapter;
import com.ayushm.movielist.task1.model.TaskModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Task1Activity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;

    TaskAdapter taskAdapter;

    ArrayList<TaskModel> taskModels;
    private MaterialButton btnAdd;

    EditText userBody,userTitle;


    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        taskModels = new ArrayList<>();






        recyclerView = findViewById(R.id.contactListId);
        recyclerView.setHasFixedSize(true);



        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        floatingActionButton = findViewById(R.id.btn_opendialog);

        Dialog dialog = new Dialog(Task1Activity.this);
        dialog.setContentView(R.layout.layout_edit_task);

        floatingActionButton.setOnClickListener(v -> {
            userTitle = dialog.findViewById(R.id.titleHead);
            userBody = dialog.findViewById(R.id.titleBody);

            btnAdd = dialog.findViewById(R.id.btnEdit);
            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String strUserName = "", strUserContact = "";
                    if (userTitle.getText() != null) {
                        strUserName = userTitle.getText().toString();
                    }

                    if (strUserName.equals("")) {
                        Toast.makeText(Task1Activity.this, "Please enter user name", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (userBody.getText() != null) {
                        strUserContact = userBody.getText().toString();
                    }
                    if (strUserContact.equals("")) {
                        Toast.makeText(Task1Activity.this, "Please enter your contact number", Toast.LENGTH_LONG).show();
                        return;
                    }


                    addTask(strUserName, strUserContact);
                    dialog.dismiss();
                }
            });dialog.show();

        });

    }


    public void addTask(String strUserTitle, String strUserBody) {


        TaskModel obj = new TaskModel(strUserTitle,strUserBody);

        obj.setTaskTitle(strUserTitle);
        obj.setTaskBody(strUserBody);


        taskModels.add(obj);



        taskAdapter = new TaskAdapter(this, taskModels, this::onEditClick);
        recyclerView.setAdapter(taskAdapter);


    }


    public void onEditClick(TaskModel listCurrentData,int currentPosition) {


        AlertDialog.Builder builderObj=new AlertDialog.Builder(this);
        View view= LayoutInflater.from(this).inflate(R.layout.layout_edit_task,null);

        EditText userTitleEtn=view.findViewById(R.id.titleHead);
        EditText userBodyEtn=view.findViewById(R.id.titleBody);
        MaterialButton btnEdit=view.findViewById(R.id.btnEdit);

        userBodyEtn.setText(listCurrentData.getTaskTitle());
        userTitleEtn.setText(listCurrentData.getTaskBody());

        ImageView closeAlert=view.findViewById(R.id.closeAlert);
        builderObj.setCancelable(false);
        builderObj.setView(view);

        closeAlert.setOnClickListener(v->{
            alertDialog.cancel();
        });

        btnEdit.setOnClickListener(v->{
            String strUserName = "", strUserContact = "";
            if (userTitleEtn.getText() != null) {
                strUserName = userTitleEtn.getText().toString();
            }

            if (strUserName.equals("")) {
                Toast.makeText(this, "Please enter user name", Toast.LENGTH_LONG).show();
                return;
            }

            if (userBodyEtn.getText() != null) {
                strUserContact = userBodyEtn.getText().toString();
            }
            if (strUserContact.equals("")) {
                Toast.makeText(this, "Please enter your contact number", Toast.LENGTH_LONG).show();
                return;
            }


            editContact(strUserName, strUserContact,currentPosition);
            recyclerView.scrollToPosition(taskModels.size()-1);
        });


        alertDialog=builderObj.create();
        alertDialog.show();





    }


    public void editContact(String strUserTitle, String strUserBody,int currentPosition){



        TaskModel obj = new TaskModel(strUserTitle,strUserBody);

        obj.setTaskTitle(strUserTitle);
        obj.setTaskBody(strUserBody);


        taskModels.add(obj);



        taskAdapter = new TaskAdapter(this, taskModels, this::onEditClick);
        recyclerView.setAdapter(taskAdapter);
        alertDialog.cancel();

    }
}