package com.example.abinash.student.juniors.m_JSON;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abinash.student.juniors.R;
import com.example.abinash.student.juniors.rate_staff;
import com.example.abinash.student.juniors.view_staff;

import java.util.ArrayList;
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    ArrayList<String> staffname;
    Context z;

    public CustomAdapter(Context context, ArrayList<String> staffname) {
        this.z = context;
        this.staffname = staffname;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.name.setText(staffname.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(z);
                builder1.setMessage("Write your message here.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "View",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(z,view_staff.class);
                                intent.putExtra("name",String.valueOf(staffname.get(position)));
                                z.startActivity(intent);
                            }
                        });

                builder1.setNegativeButton(
                        "Rate",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(z,rate_staff.class);
                                intent.putExtra("name",String.valueOf(staffname.get(position)));
                                z.startActivity(intent);
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }
    @Override
    public int getItemCount() {

        return staffname.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        Button action;
        public MyViewHolder(View itemView) {
            super(itemView);

            name =(TextView) itemView.findViewById(R.id.staff);;
            action=(Button)itemView.findViewById(R.id.action);
        }
    }
}