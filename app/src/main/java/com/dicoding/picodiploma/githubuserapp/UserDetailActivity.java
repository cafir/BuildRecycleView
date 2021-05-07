package com.dicoding.picodiploma.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    TextView dummyName, dummyUsername, dummyLocation, dummyCompany, dummyRepository,
    dummyFollower, dummyFollowing;

    ImageView dummyAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("User");


        dummyName = findViewById(R.id.dummy_name);
        dummyUsername = findViewById(R.id.dummy_username);
        dummyLocation = findViewById(R.id.dummy_location);
        dummyCompany = findViewById(R.id.dummy_company);
        dummyRepository = findViewById(R.id.dummy_repository);
        dummyFollower = findViewById(R.id.dummy_follower);
        dummyFollowing = findViewById(R.id.dummy_following);
        dummyAvatar =  findViewById(R.id.dummy_img);

        dummyName.setText(user.getName());
        dummyUsername.setText(user.getUsername());
        dummyLocation.setText(user.getLocation());
        dummyCompany.setText(user.getCompany());
        dummyAvatar.setImageResource(user.getAvatar());
        dummyRepository.setText(user.getRepository());
        dummyFollowing.setText(user.getFollowing());
        dummyFollower.setText(user.getFollower());

    }
}