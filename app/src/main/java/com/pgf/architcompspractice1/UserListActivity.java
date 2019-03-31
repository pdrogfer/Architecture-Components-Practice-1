package com.pgf.architcompspractice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.pgf.architcompspractice1.model.User;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    /* API used in this example about Architecture Components:
    * https://reqres.in/
    */

    private static final String TAG = "UserListActivity";

    UserListViewModel userListViewModel;
    RecyclerView rvUsers;
    AdapterUsers adapterUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        setUI();

        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        userListViewModel.init();

        userListViewModel.getUserList().observe(this, userList -> {
            updateUserList(userList);
        });
    }

    private void setUI() {
        rvUsers = findViewById(R.id.rv_users);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        rvUsers.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapterUsers = new AdapterUsers();
        rvUsers.setAdapter(adapterUsers);
    }

    private void updateUserList(List<User> userList) {
        Log.i(TAG, "updateUserList: " + userList.toString());
        adapterUsers.setUsers(userList);
    }
}
