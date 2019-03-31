package com.pgf.architcompspractice1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pgf.architcompspractice1.model.User;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterUsers extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;

    public AdapterUsers() {
        this.users = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(itemRootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        User user = users.get(position);

        ((UserViewHolder) holder).bindUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> userList) {
        this.users = userList;
        notifyDataSetChanged();
    }
}
