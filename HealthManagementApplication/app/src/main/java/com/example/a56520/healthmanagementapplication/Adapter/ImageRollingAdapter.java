package com.example.a56520.healthmanagementapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a56520.healthmanagementapplication.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class ImageRollingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<ImageRollingData>mImageRollingDataList;

    public ImageRollingAdapter(List<ImageRollingData> imageRollingData){
        this.mImageRollingDataList = imageRollingData;
    }

    class ImageRollingViewHolder extends RecyclerView.ViewHolder{
        CardView image_rolling_card_view;
        ImageView image_rolling_image_view;
        public ImageRollingViewHolder(View view){
            super(view);
            image_rolling_card_view = (CardView)view.findViewById(R.id.image_rolling_card_view);
            image_rolling_image_view = (ImageView)view.findViewById(R.id.image_rolling_image_view);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.image_rolling_card_view,
                parent, false);
        return new ImageRollingViewHolder(view);
    }

    @Override

    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position){
        ImageRollingData imageRollingData = mImageRollingDataList.get(position);
        ImageRollingViewHolder viewHolder = (ImageRollingViewHolder) holder;

//        if (imageRollingData.getImageUri().length()!=0){
//            FileInputStream fis= null;
//            try {
//                fis = new FileInputStream(imageRollingData.getImageUri());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            Bitmap bitmap = BitmapFactory.decodeStream(fis);
//            viewHolder.image_rolling_image_view.setImageBitmap(bitmap);
//        }

//        String cutAlbumPictureFilePath=sizeCompress(imagePath);
//        Bitmap bitmap= BitmapFactory.decodeFile(cutAlbumPictureFilePath);
//        mViewImage.setImageBitmap(bitmap);
//        if(imageRollingData.getImageUrl()!= null){
//            //此处为解析uri文件
//        }else{
            Glide.with((Activity)mContext).load(imageRollingData.getImageId())
                    .into(viewHolder.image_rolling_image_view);
//        }
    }
    @Override
    public int getItemCount(){
        return mImageRollingDataList.size();
    }
}
