package com.example.recyclerview_exercise;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Integer> numbArray;
    Context context;

    public MyAdapter(Context ct, ArrayList<Integer> numbers) {
        context = ct;
        numbArray = numbers;
        Log.d("MyArray", "MyAdapter: numbers= " + numbers.get(5));
        Log.d("MyArray", "MyAdapter: numbArray= " + numbArray.get(5));
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Log.d("aei", "onBindViewHolder: position = " + position);
        Log.d("MyArray", "onBindViewHolder: postioncheck= " + numbArray.get(5));
        holder.myText1.setText(numbArray.get(position) + "");

        holder.conLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //numbArray.remove(pos);
                Snackbar snackbar = Snackbar.make(holder.conLayout, "This is a sncakbar", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return numbArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1;
        ConstraintLayout conLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            myText1 = itemView.findViewById(R.id.numberInList);
            conLayout = (ConstraintLayout) itemView;
        }
    }
}
