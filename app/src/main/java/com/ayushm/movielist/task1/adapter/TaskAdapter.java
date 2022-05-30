package com.ayushm.movielist.task1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ayushm.movielist.R;
import com.ayushm.movielist.task1.model.TaskModel;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder>{
    private ArrayList<TaskModel> listData;
    private Context context;
    private OnEditListener onEditListener;

    public TaskAdapter(Context context, ArrayList<TaskModel> list,OnEditListener onEditListener){
        this.listData=list;
        this.context=context;
        this.onEditListener=onEditListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.show_task_list_layout,parent,false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        TaskModel dataObj=listData.get(position);


        holder.titleText.setText(dataObj.getTaskTitle());
        holder.bodyText.setText(dataObj.getTaskBody());
        holder.imgDelete.setOnClickListener(v->{
            listData.remove(position);
            notifyDataSetChanged();

        });
        holder.imgEdit.setOnClickListener(v->{
            onEditListener.onEditClick(listData.get(position),position);
        });


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView titleText, bodyText;
        ImageView imgEdit,imgDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText =itemView.findViewById(R.id.titleTxtId);
            imgEdit=itemView.findViewById(R.id.imgEdit);
            imgDelete=itemView.findViewById(R.id.imgDelete);
            bodyText =itemView.findViewById(R.id.bodyTxtId);

        }
    }



    public void editData(TaskModel listDataObj,int currentPosition){

        listData.get(currentPosition).setTaskTitle(listDataObj.getTaskTitle());
        listData.get(currentPosition).setTaskBody(listDataObj.getTaskBody());
        notifyDataSetChanged();


    }

    public interface OnEditListener{

        void onEditClick(TaskModel listCurrentData,int CurrentPosition);

    }
}