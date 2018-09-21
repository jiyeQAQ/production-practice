package com.example.a56520.healthmanagementapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a56520.healthmanagementapplication.R;

import java.util.List;

public class DiscomfortDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<DiscomfortData> mDiscomfortDataList;

    public DiscomfortDataAdapter(List<DiscomfortData> discomfortDatas){
        this.mDiscomfortDataList=discomfortDatas;
    }

    class DiscomfortViewHolder extends RecyclerView.ViewHolder{
        ImageView discomfort_type_imageView;
        TextView discomfort_type_textView;

        public DiscomfortViewHolder(View view){
            super(view);
            discomfort_type_imageView = view.findViewById(R.id.discomfort_type_image);
            discomfort_type_textView = view.findViewById(R.id.discomfort_type_name_textView);

            //----------放入布局定义------------//
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view;
        //---------改布局--------//
        view = LayoutInflater.from(mContext).inflate(R.layout.discomfort_type,
                parent, false);
        return new DiscomfortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        DiscomfortData imageRollingData = mDiscomfortDataList.get(position);
        DiscomfortViewHolder viewHolder = (DiscomfortViewHolder) holder;

        viewHolder.discomfort_type_textView.setText(imageRollingData.getDiscomfortType());
        Glide.with(mContext).load(imageRollingData.getDiscomfortTypeImageId())
                .into(viewHolder.discomfort_type_imageView);
    }

    @Override
    public int getItemCount(){
        return mDiscomfortDataList.size();
    }














}
