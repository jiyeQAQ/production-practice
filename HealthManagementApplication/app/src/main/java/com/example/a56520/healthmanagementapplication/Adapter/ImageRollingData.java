package com.example.a56520.healthmanagementapplication.Adapter;

import android.widget.ImageButton;

public class ImageRollingData {
    private  int imageId;
    private  String imageUri;

    public ImageRollingData(int imageId){
        this.imageId=imageId;

    }
    public ImageRollingData(String imageUri){
        this.imageUri = imageUri;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
