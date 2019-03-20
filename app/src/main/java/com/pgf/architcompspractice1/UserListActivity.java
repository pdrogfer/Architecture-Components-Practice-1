package com.pgf.architcompspractice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        userListViewModel.init();

        userListViewModel.getUserList().observe(this, userList -> {
            updateUserList(userList);
        });
    }

    private void updateUserList(List<User> userList) {
        Log.i(TAG, "updateUserList: " + userList.toString());
    }
}
