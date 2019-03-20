package com.pgf.architcompspractice1.api;

import com.pgf.architcompspractice1.model.User;

import java.util.List;

public interface AppDataSource {

    List<User> getUsers(DataSourceListener dataSourceListener);
}
