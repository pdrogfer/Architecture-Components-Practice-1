package com.pgf.architcompspractice1.api;

import com.pgf.architcompspractice1.model.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private AppDataSource dataSource;

    public UserRepositoryImpl(AppDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void getUsers(final UserRepositoryListener userRepositoryListener) {

        dataSource.getUsers(new DataSourceListener() {

            @Override
            public void onSuccess(List<User> users) {
                userRepositoryListener.onSuccess(users);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
