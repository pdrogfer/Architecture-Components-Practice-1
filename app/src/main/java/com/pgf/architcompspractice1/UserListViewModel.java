package com.pgf.architcompspractice1;

import com.pgf.architcompspractice1.api.WebRepository;
import com.pgf.architcompspractice1.model.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class UserListViewModel extends ViewModel {

    private static final String TAG = "UserListViewModel";

    private WebRepository webRepository;
    private LiveData<List<User>> userList;

    public void init() {
        webRepository = new WebRepository();
        userList = webRepository.getUserList();
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }
}
