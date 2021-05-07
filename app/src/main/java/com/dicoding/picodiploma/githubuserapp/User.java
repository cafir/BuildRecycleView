package com.dicoding.picodiploma.githubuserapp;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String username;
    String name;
    String location;
    String company;
    String repository;
    int avatar;
    String follower;
    String following;

    public User() {
    }

    protected User(Parcel in){
        username = in.readString();
        name = in.readString();
        location = in.readString();
        company = in.readString();
        repository = in.readString();
        avatar = in.readInt();
        follower = in.readString();
        following = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(company);
        dest.writeString(repository);
        dest.writeInt(avatar);
        dest.writeString(follower);
        dest.writeString(following);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String  getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }
}
