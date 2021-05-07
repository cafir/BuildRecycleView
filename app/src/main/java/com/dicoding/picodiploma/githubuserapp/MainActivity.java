package com.dicoding.picodiploma.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] dummyName, dummyUsername, dummyLocation, dummyCompany, dummyRepository,
            dummyFollower, dummyFollowing;
    TypedArray dummyPhoto;
    ArrayList<User> users;
    RecyclerView rvUser;
    ListUserAdapter listUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUser = findViewById(R.id.rv_user);
        rvUser.setHasFixedSize(true);

        dummyData();
        addItem();

        buildListUser();

    }

    public void buildListUser() {
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        listUserAdapter = new ListUserAdapter(users);
        rvUser.setAdapter(listUserAdapter);

        listUserAdapter.setOnItemClickCallBack(data -> {
            Intent intent = new Intent(MainActivity.this, UserDetailActivity.class);
            intent.putExtra("User", users.get(data));
            startActivity(intent);
        });

    }



    private void dummyData() {
        dummyName = getResources().getStringArray(R.array.name);
        dummyUsername = getResources().getStringArray(R.array.username);
        dummyPhoto = getResources().obtainTypedArray(R.array.avatar);
        dummyLocation = getResources().getStringArray(R.array.location);
        dummyCompany = getResources().getStringArray(R.array.company);
        dummyRepository = getResources().getStringArray(R.array.repository);
        dummyFollower = getResources().getStringArray(R.array.followers);
        dummyFollowing = getResources().getStringArray(R.array.following);


    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dummyUsername.length; i++) {
            User user = new User();
            user.setName(dummyName[i]);
            user.setUsername(dummyUsername[i]);
            user.setAvatar(dummyPhoto.getResourceId(i, -1));
            user.setLocation(dummyLocation[i]);
            user.setCompany(dummyCompany[i]);
            user.setRepository(dummyRepository[i]);
            user.setFollower(dummyFollower[i]);
            user.setFollowing(dummyFollowing[i]);
            users.add(user);
        }
    }
}