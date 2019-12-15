package com.fiid.moviecataloguesub1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private int photo;
    private String title;
    private String description;

    protected Movies(Parcel in) {
        photo = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(title);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public int getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Movies(int photo, String title, String description){
        this.title = title;
        this.description = description;
        this.photo = photo;
    }
}