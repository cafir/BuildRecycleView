package com.dicoding.picodiploma.githubuserapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.ListViewHolder>{

    private OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    ArrayList<User> userList;

    public ListUserAdapter(ArrayList<User> userList) {
        this.userList = userList;

    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tvDummyUsername.setText(userList.get(position).getUsername());
        holder.tvDummyName.setText(userList.get(position).getName());
        holder.imgDummyAvatar.setImageResource(userList.get(position).getAvatar());

        holder.itemView.setOnClickListener(v -> onItemClickCallBack.onItemClicked(position));

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvDummyName, tvDummyUsername;
        ImageView imgDummyAvatar;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDummyName = itemView.findViewById(R.id.dummy_name);
            tvDummyUsername = itemView.findViewById(R.id.dummy_username);
            imgDummyAvatar = itemView.findViewById(R.id.dummy_img);

        }
    }

    public interface OnItemClickCallBack {
        void onItemClicked(int position);
    }

}
