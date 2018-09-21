package com.example.a56520.healthmanagementapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.a56520.healthmanagementapplication.R;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.HORIZONTAL;

public class ShowGraphicsAndTextDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int MIXED = 1;
    private Context mContext;
    private MeasurableDataAdapter.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {

        void onItemClick(View v, int position);

        void onItemLongClick(View v, int position);

    }

    public void setOnItemClickListener(MeasurableDataAdapter.OnItemClickListener OnItemClickListener) {

        this.mOnItemClickListener = OnItemClickListener;

    }


    private List<ShowGraphicsAndTextData> mShowGraphicsAndTextDataList;
    public ShowGraphicsAndTextDataAdapter(List<ShowGraphicsAndTextData> showGraphicsAndTextDataList){
        this.mShowGraphicsAndTextDataList = showGraphicsAndTextDataList;
    }

    class GraphicsAndTextDataViewHolder extends RecyclerView.ViewHolder {
        CardView graphics_and_text_cardView, graphics_and_text_tag_cardView1,
                graphics_and_text_tag_cardView2, graphics_and_text_tag_cardView3,
                graphics_and_text_tag_cardView4;
        TextView detail_take_in_diet_date_textView, detail_take_in_diet_time_textView,
                graphics_and_text_tag_textView1, graphics_and_text_tag_textView2,
                graphics_and_text_tag_textView3, graphics_and_text_tag_textView4;
        RecyclerView detail_take_in_diet_image_recyclerView;

        public GraphicsAndTextDataViewHolder(View view) {
            super(view);
            detail_take_in_diet_image_recyclerView = (RecyclerView)view.findViewById(R.id.detail_take_in_diet_image_recyclerView);
            graphics_and_text_cardView = (CardView) view.findViewById(R.id.graphics_and_text_cardView);
            graphics_and_text_tag_cardView1 = (CardView) view.findViewById(R.id.graphics_and_text_tag_cardView1);
            graphics_and_text_tag_cardView2 = (CardView) view.findViewById(R.id.graphics_and_text_tag_cardView2);
            graphics_and_text_tag_cardView3 = (CardView) view.findViewById(R.id.graphics_and_text_tag_cardView3);
            graphics_and_text_tag_cardView4 = (CardView) view.findViewById(R.id.graphics_and_text_tag_cardView4);
            detail_take_in_diet_date_textView = (TextView) view.findViewById(R.id.detail_take_in_diet_date_textView);
            detail_take_in_diet_time_textView = (TextView) view.findViewById(R.id.detail_take_in_diet_time_textView);
            graphics_and_text_tag_textView1 = (TextView) view.findViewById(R.id.graphics_and_text_tag_textView1);
            graphics_and_text_tag_textView2 = (TextView) view.findViewById(R.id.graphics_and_text_tag_textView2);
            graphics_and_text_tag_textView3 = (TextView) view.findViewById(R.id.graphics_and_text_tag_textView3);
            graphics_and_text_tag_textView4 = (TextView) view.findViewById(R.id.graphics_and_text_tag_textView4);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view;

        if (viewType == MIXED) {
            view = LayoutInflater.from(mContext).inflate(R.layout.take_in_diet_card_layout,
                    parent, false);
            return new GraphicsAndTextDataViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
        }

        if (holder instanceof GraphicsAndTextDataViewHolder) {
            ShowGraphicsAndTextData showGraphicsAndTextData = mShowGraphicsAndTextDataList.get(position);
            GraphicsAndTextDataViewHolder viewHolder = (GraphicsAndTextDataViewHolder) holder;

            //----------输入字符串环节----------------------------//
//            if (showGraphicsAndTextData.getImageUrl()[0]!= null) {
//
//            } else
                if (showGraphicsAndTextData.getImageId().length != 0) {
                viewHolder.detail_take_in_diet_date_textView
                        .setText((showGraphicsAndTextData.getDate() / 1000000) + "/" +
                                ((showGraphicsAndTextData.getDate() / 10000) % 100));
                viewHolder.detail_take_in_diet_time_textView
                        .setText(((showGraphicsAndTextData.getDate() % 10000) / 100) + ":" +
                                (showGraphicsAndTextData.getDate() % 100));
                int i = showGraphicsAndTextData.getTag().length;
                switch (i) {
                    case 1: {
                        viewHolder.graphics_and_text_tag_textView1
                                .setText(showGraphicsAndTextData.getTag()[0]);
                        viewHolder.graphics_and_text_tag_cardView2
                                .setVisibility(View.INVISIBLE);
                        viewHolder.graphics_and_text_tag_cardView3
                                .setVisibility(View.INVISIBLE);
                        viewHolder.graphics_and_text_tag_cardView4
                                .setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 2: {
                        viewHolder.graphics_and_text_tag_textView1
                                .setText(showGraphicsAndTextData.getTag()[0]);
                        viewHolder.graphics_and_text_tag_textView2
                                .setText(showGraphicsAndTextData.getTag()[1]);
                        viewHolder.graphics_and_text_tag_cardView3
                                .setVisibility(View.INVISIBLE);
                        viewHolder.graphics_and_text_tag_cardView4
                                .setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 3: {
                        viewHolder.graphics_and_text_tag_textView1
                                .setText(showGraphicsAndTextData.getTag()[0]);
                        viewHolder.graphics_and_text_tag_textView2
                                .setText(showGraphicsAndTextData.getTag()[1]);
                        viewHolder.graphics_and_text_tag_textView3
                                .setText(showGraphicsAndTextData.getTag()[2]);
                        viewHolder.graphics_and_text_tag_cardView4
                                .setVisibility(View.INVISIBLE);
                        break;
                    }
                    case 4: {
                        viewHolder.graphics_and_text_tag_textView1
                                .setText(showGraphicsAndTextData.getTag()[0]);
                        viewHolder.graphics_and_text_tag_textView2
                                .setText(showGraphicsAndTextData.getTag()[1]);
                        viewHolder.graphics_and_text_tag_textView3
                                .setText(showGraphicsAndTextData.getTag()[2]);
                        viewHolder.graphics_and_text_tag_textView4
                                .setText(showGraphicsAndTextData.getTag()[3]);
                        break;

                    }
                }
                initImageRolling(mContext,showGraphicsAndTextData.getImageId(),viewHolder);

            }




        }
    }
    @Override
    public  int getItemCount(){
        return mShowGraphicsAndTextDataList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mShowGraphicsAndTextDataList.get(position).getDataTypeFlag() == MIXED){
            return MIXED;
        }else{
            return MIXED;
        }
    }
    private void initImageRolling(Context mContext,int[] imageId,GraphicsAndTextDataViewHolder viewHolder){
        ImageRollingAdapter imageRollingAdapter;
        RecyclerView iRecyclerView = viewHolder.detail_take_in_diet_image_recyclerView;
        LinearLayoutManager iLayoutManager;
        iLayoutManager = new LinearLayoutManager(mContext);
        iLayoutManager.setOrientation(HORIZONTAL);
        iRecyclerView.setLayoutManager(iLayoutManager);
        List<ImageRollingData> imageRollingDataList = new ArrayList<>();
        imageRollingDataList.clear();
        for(int i =0;i<imageId.length;i++){
            imageRollingDataList.add(new ImageRollingData(imageId[i]));
        }
        imageRollingAdapter = new ImageRollingAdapter(imageRollingDataList);
        iRecyclerView.setAdapter(imageRollingAdapter);
    }



}