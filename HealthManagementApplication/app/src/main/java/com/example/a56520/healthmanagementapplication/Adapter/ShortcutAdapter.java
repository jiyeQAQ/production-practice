package com.example.a56520.healthmanagementapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a56520.healthmanagementapplication.R;

import java.util.List;

public class ShortcutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int MEASURABLE_DATA = 1;
    private int PICTURE=2;

    private Context mContext;
    private List<Shortcut> mShortcutList;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public ShortcutAdapter(List<Shortcut> shortcuts){
        this.mShortcutList = shortcuts;
    }


    class MeasurableViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView shortcutImage;
        TextView shortcutName,shortcutDateNumber,shortcutDataName1,shortcutDataNumber1,
        shortcutDataUnit1,shortcutDataName2,shortcutDataNumber2,shortcutDataUnit2,shortcut_date_name;

        public MeasurableViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            shortcutImage = (ImageView)view.findViewById(R.id.shortcut_iamge);
            shortcutName = (TextView)view.findViewById(R.id.shortcut_name);
            shortcutDataName1 = (TextView)view.findViewById(R.id.shortcut_data_name_1);
            shortcutDataName2 = (TextView)view.findViewById(R.id.shortcut_data_name_2);
            shortcutDataNumber1 = (TextView)view.findViewById(R.id.shortcut_data_number_1);
            shortcutDataNumber2 = (TextView)view.findViewById(R.id.shortcut_data_number_2);
            shortcutDataUnit1 = (TextView)view.findViewById(R.id.shortcut_data_unit_1);
            shortcutDataUnit2 = (TextView)view.findViewById(R.id.shortcut_data_unit_2);
            shortcutDateNumber = (TextView)view.findViewById(R.id.shortcut_date_number);
            shortcut_date_name=(TextView)view.findViewById(R.id.shortcut_date_name);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view;

        if(viewType == MEASURABLE_DATA){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.main_interface_shortcut_card_layout,
                            parent,false);
            return new MeasurableViewHolder(view);
        }
        else
//            if(viewType == PICTURE)
            {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.main_interface_shortcut_card_layout,
                            parent,false);
            return new MeasurableViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position){

        if( mOnItemClickListener!=null ){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos =holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView,pos);
                    return false;
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,pos);
                }
            });

        }

        if(holder instanceof MeasurableViewHolder){
            Shortcut shortcut = mShortcutList.get(position);
            MeasurableViewHolder viewHolder = (MeasurableViewHolder) holder;
            if(shortcut.getType().equals("PICTURE")){
                Glide.with(mContext).load(shortcut.getShortcutImageId())
                        .into(viewHolder.shortcutImage);
                viewHolder.shortcutName.setText(shortcut.getShortcutName());
                viewHolder.shortcutDataName1.setVisibility(View.INVISIBLE);
                viewHolder.shortcutDataNumber1.setVisibility(View.INVISIBLE);
                viewHolder.shortcutDataUnit1.setVisibility(View.INVISIBLE);
                viewHolder.shortcutDateNumber.setVisibility(View.INVISIBLE);
                viewHolder.shortcut_date_name.setVisibility(View.INVISIBLE);
            }else {
                Glide.with(mContext).load(shortcut.getShortcutImageId())
                        .into(viewHolder.shortcutImage);
                viewHolder.shortcutName.setText(shortcut.getShortcutName());
                viewHolder.shortcutDateNumber.setText(shortcut.getShortcutDateNumber()+"");
                viewHolder.shortcutDataName1.setText(shortcut.getShortcutDataName1());
                viewHolder.shortcutDataNumber1.setText(shortcut.getShortcutDataNumber1()+"");
                viewHolder.shortcutDataUnit1.setText(shortcut.getShortcutDataUnit1());
                if(shortcut.getTag().equals("DOUBLE")){
                    viewHolder.shortcutDataName2.setText(shortcut.getShortcutDataName2());
                    viewHolder.shortcutDataNumber2.setText(shortcut.getShortcutDataNumber2()+"");
                    viewHolder.shortcutDataUnit2.setText(shortcut.getShortcutDataUnit2());
                }
            }
        }

    }

    @Override
    public int getItemCount(){
        return mShortcutList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mShortcutList.get(position).getType().equals("MEASURABLE_DATA")){
            return MEASURABLE_DATA;
        }else if(mShortcutList.get(position).getType().equals("PICTURE")){
            return PICTURE;
        }else{
            return 0;
        }
    }











}
