package com.pgf.architcompspractice1.api;

import com.pgf.architcompspractice1.model.User;

import java.util.ArrayList;
import java.util.List;

public class AppDataSourceRemote implements AppDataSource {

    // public static final String URL_BASE = "https://reqres.in/api/";

    @Override
    public List<User> getUsers(DataSourceListener dataSourceListener) {

        // TODO: 19/03/2019 call Retrofit
        List<User> users = new ArrayList<>();


        // Dummy users
//        users.add(new User(
//                4,
//                "Eve",
//                "Holt",
//                "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
//        ));
//        users.add(new User(
//                4,
//                "Eve",
//                "Holt",
//                "https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"
//        ));
//        users.add(new User(
//                6,
//                "Tracey",
//                "Ramos",
//                "https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"
//        ));

        return users;
    }
}
