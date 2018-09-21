package com.example.a56520.healthmanagementapplication.Adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.a56520.healthmanagementapplication.R;

import java.util.List;

public class NewDataLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int BLOOD_PRESSURE = 1;
    private int BLOOD_GLUCOSE = 2;
    private int HEART_RATE = 3;
    private int BODY_TEMPERATURE = 4;
    private int BLOOD_OXYGEN = 5;
    private int BODY_WEIGHT = 6;
    private int DIET = 7;
    private int MEDICINE = 8;
    private int MEDICAL_HISTORY = 9;
    private int ALLERGY = 10;
    private int LOCATION = 21;
    private int CONDITION = 22;
    private int DATE = 23;
    private int TOOL = 24;



    private Context mContext;
    private List<NewDataLayout> mNewDataLayoutList;

    public interface InItemClickListener {
        void inItemClick(View v, int position);
        void inItemLongClick(View v,int position);
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;
    private InItemClickListener mInItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }
    public void setInItemClickListener(InItemClickListener  InItemClickListener) {

        this.mInItemClickListener  = InItemClickListener;

    }

    public NewDataLayoutAdapter(List<NewDataLayout> newDataLayouts){
        this.mNewDataLayoutList = newDataLayouts;
    }


    class BloodPressureViewHolder extends RecyclerView.ViewHolder{
                public BloodPressureViewHolder(View view){
            super(view);
        }
    }
    class BloodGlucoseViewHolder extends RecyclerView.ViewHolder{
        public BloodGlucoseViewHolder(View view){
            super(view);
        }
    }
    class HeartRateViewHolder extends RecyclerView.ViewHolder{
        public HeartRateViewHolder(View view){
            super(view);
        }
    }
    class BodyTemperatureViewHolder extends RecyclerView.ViewHolder{
        public BodyTemperatureViewHolder(View view){
            super(view);
        }
    }
    class BloodOxygenViewHolder extends RecyclerView.ViewHolder{
        public BloodOxygenViewHolder(View view){
            super(view);
        }
    }
    class BodyWeightViewHolder extends RecyclerView.ViewHolder{
        public BodyWeightViewHolder(View view){
            super(view);
        }
    }
    class DietViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView new_diet_data_imageView;
        Button new_diet_data_shot_button,new_diet_data_album_button,new_diet_data_delete_button;
        public DietViewHolder(View view){
            super(view);
            new_diet_data_imageView = view.findViewById(R.id.new_diet_data_imageView);
            new_diet_data_shot_button = view.findViewById(R.id.new_diet_data_shot_button);
            new_diet_data_album_button = view.findViewById(R.id.new_diet_data_album_button);
            new_diet_data_delete_button = view.findViewById(R.id.new_diet_data_delete_button);

            new_diet_data_imageView.setOnClickListener(this);
            new_diet_data_shot_button.setOnClickListener(this);
            new_diet_data_album_button.setOnClickListener(this);
            new_diet_data_delete_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mInItemClickListener != null){
                mInItemClickListener.inItemClick(v,getAdapterPosition());
            }
        }
    }
    class MedicineViewHolder extends RecyclerView.ViewHolder{
        public MedicineViewHolder(View view){
            super(view);
        }
    }
    class MedicalHistoryViewHolder extends RecyclerView.ViewHolder{
        public MedicalHistoryViewHolder(View view){
            super(view);
        }
    }
    class AllergyViewHolder extends RecyclerView.ViewHolder{
        public AllergyViewHolder(View view){
            super(view);
        }
    }
    class LocationViewHolder extends RecyclerView.ViewHolder{
        public LocationViewHolder(View view){
            super(view);
        }
    }
    class ConditionViewHolder extends RecyclerView.ViewHolder{
        public ConditionViewHolder(View view){
            super(view);
        }
    }
    class DateViewHolder extends RecyclerView.ViewHolder{
        public DateViewHolder(View view){
            super(view);
        }
    }
    class ToolViewHolder extends RecyclerView.ViewHolder{
        public ToolViewHolder(View view){
            super(view);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view;

        if(viewType == BLOOD_PRESSURE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_blood_pressure,
                            parent,false);
            return new BloodPressureViewHolder(view);
        } else if(viewType == BLOOD_GLUCOSE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_blood_glucose,
                            parent,false);
            return new BloodGlucoseViewHolder(view);
        }else if(viewType == HEART_RATE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_heart_rate,
                            parent,false);
            return new HeartRateViewHolder(view);
        }else if(viewType == BODY_TEMPERATURE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_body_temperature,
                            parent,false);
            return new BodyTemperatureViewHolder(view);
        }else if(viewType == BLOOD_OXYGEN){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_blood_oxygen,
                            parent,false);
            return new BloodOxygenViewHolder(view);
        }else if(viewType == BODY_WEIGHT){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_body_weight,
                            parent,false);
            return new BodyWeightViewHolder(view);
        }else if(viewType == DIET){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_diet,
                            parent,false);
            return new DietViewHolder(view);
        }else if(viewType == MEDICINE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_medicine,
                            parent,false);
            return new MedicineViewHolder(view);
        }else if(viewType == MEDICAL_HISTORY){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_medical_history,
                            parent,false);
            return new MedicalHistoryViewHolder(view);
        }else if(viewType == ALLERGY){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_allergy,
                            parent,false);
            return new AllergyViewHolder(view);
        }else if(viewType == LOCATION){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_test_location,
                            parent,false);
            return new LocationViewHolder(view);
        }else if(viewType == CONDITION){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_test_condition,
                            parent,false);
            return new ConditionViewHolder(view);
        }else if(viewType == DATE){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_date,
                            parent,false);
            return new DateViewHolder(view);
        }else if(viewType == TOOL){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_test_tool,
                            parent,false);
            return new ToolViewHolder(view);
        }else {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.new_data_blood_pressure,
                            parent,false);
            return new BloodPressureViewHolder(view);
        }
    }


    //待改
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

        if(holder instanceof BloodPressureViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            BloodPressureViewHolder viewHolder = (BloodPressureViewHolder) holder;
        }else if(holder instanceof BloodGlucoseViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            BloodGlucoseViewHolder viewHolder = (BloodGlucoseViewHolder) holder;
        }else if (holder instanceof HeartRateViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            HeartRateViewHolder viewHolder = (HeartRateViewHolder) holder;
        }else if (holder instanceof BodyTemperatureViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            BodyTemperatureViewHolder viewHolder = (BodyTemperatureViewHolder) holder;
        }else if (holder instanceof BloodOxygenViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            BloodOxygenViewHolder viewHolder = (BloodOxygenViewHolder) holder;
        }else if (holder instanceof BodyWeightViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            BodyWeightViewHolder viewHolder = (BodyWeightViewHolder) holder;
        }else if (holder instanceof DietViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            DietViewHolder viewHolder = (DietViewHolder) holder;
        }else if (holder instanceof MedicineViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            MedicineViewHolder viewHolder = (MedicineViewHolder) holder;
        }else if (holder instanceof MedicalHistoryViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            MedicalHistoryViewHolder viewHolder = (MedicalHistoryViewHolder) holder;
        }else if (holder instanceof AllergyViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            AllergyViewHolder viewHolder = (AllergyViewHolder) holder;
        }else if (holder instanceof LocationViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            LocationViewHolder viewHolder = (LocationViewHolder) holder;
        }else if (holder instanceof ConditionViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            ConditionViewHolder viewHolder = (ConditionViewHolder) holder;
        }else if (holder instanceof DateViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            DateViewHolder viewHolder = (DateViewHolder) holder;
        }else if (holder instanceof ToolViewHolder){
            NewDataLayout newDataLayout = mNewDataLayoutList.get(position);
            ToolViewHolder viewHolder = (ToolViewHolder) holder;
        }

    }

    @Override
    public int getItemCount(){
        return mNewDataLayoutList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mNewDataLayoutList.get(position).getItemId()==BLOOD_PRESSURE){
            return BLOOD_PRESSURE;
        }else if(mNewDataLayoutList.get(position).getItemId()==BLOOD_GLUCOSE){
            return BLOOD_GLUCOSE;
        }else if (mNewDataLayoutList.get(position).getItemId() == HEART_RATE){
            return HEART_RATE;
        }else if (mNewDataLayoutList.get(position).getItemId() == BODY_TEMPERATURE){
            return BODY_TEMPERATURE;
        }else if (mNewDataLayoutList.get(position).getItemId() == BLOOD_OXYGEN){
            return BLOOD_OXYGEN;
        }else if (mNewDataLayoutList.get(position).getItemId() == BODY_WEIGHT){
            return BODY_WEIGHT;
        }else if (mNewDataLayoutList.get(position).getItemId() == DIET){
            return DIET;
        }else if (mNewDataLayoutList.get(position).getItemId() == MEDICINE){
            return MEDICINE;
        }else if (mNewDataLayoutList.get(position).getItemId() == MEDICAL_HISTORY){
            return MEDICAL_HISTORY;
        }else if (mNewDataLayoutList.get(position).getItemId() == ALLERGY){
            return ALLERGY;
        }else if (mNewDataLayoutList.get(position).getItemId() == LOCATION){
            return LOCATION;
        }else if (mNewDataLayoutList.get(position).getItemId() == CONDITION){
            return CONDITION;
        }else if (mNewDataLayoutList.get(position).getItemId() == DATE){
            return DATE;
        }else if (mNewDataLayoutList.get(position).getItemId() == TOOL){
            return TOOL;
        }else return 0;
    }

}
