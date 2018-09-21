package com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailmeasurablefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.a56520.healthmanagementapplication.Adapter.MeasurableData;
import com.example.a56520.healthmanagementapplication.Adapter.MeasurableDataAdapter;
import com.example.a56520.healthmanagementapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MeasurableBodyTemperatureFragment extends Fragment {

    private int testDate[]={1809010000,1809020000,1809030000,1809030030,1809100000,1809110000,1809110030,1809110500,1809110600,1809110700,1809110730,1809110745,1809110800,1809110810};
    private int testResult1[]={3600,3600,3600,3700,3700,3700,3750,3751,3755,3800,3800,3850,3850,3850};
    private int testResult2[]={3241,3431,3557,3249,2368,4255,2352,4323,1232,4322,1444,2319,3249,1239};
    private MeasurableDataAdapter measurableDataAdapter;
    private GridLayoutManager layoutManager;
    private List<MeasurableData> measurableDataList=new ArrayList<>();
    private MeasurableData[] measurableDatas = {
            new MeasurableData("体温",2,testDate,testResult1),
            new MeasurableData("体温",36,9172344,01),
            new MeasurableData("体温",38,9122344,01),
            new MeasurableData("体温",38,9122344,01),
            new MeasurableData("体温",38,9122344,01),
            new MeasurableData("体温",38,9122344,01),
            new MeasurableData("体温",38,9122344,01),
            new MeasurableData("体温",38,9122344,01)};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_measurable_body_temperature,
                container,false);


        initMeasurableData();
        RecyclerView recyclerView = v.
                findViewById(R.id.measurable_body_temperature_recyclerView);
        layoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        measurableDataAdapter = new MeasurableDataAdapter(measurableDataList);
        recyclerView.setAdapter(measurableDataAdapter);
        measurableDataAdapter.setOnItemClickListener(mOnItemClickListener);
        measurableDataAdapter.setInItemClickListener(mInItemClickListener);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){


        super.onActivityCreated(savedInstanceState);

    }


    private MeasurableDataAdapter.InItemClickListener mInItemClickListener = new MeasurableDataAdapter.InItemClickListener() {
        @Override
        public void inItemClick(View v, int position) {

            switch (v.getId()){
                case R.id.measurable_chart_day:{
                    measurableDataList.get(position).setRange(4);
                    measurableDataAdapter.notifyItemChanged(position);
                    break;
                }
                case R.id.measurable_chart_week:{
                    measurableDataList.get(position).setRange(3);
                    measurableDataAdapter.notifyItemChanged(position);
                    break;
                }
                case R.id.measurable_chart_month:{

                    measurableDataList.get(position).setRange(2);
                    measurableDataAdapter.notifyItemChanged(position);
                    break;
                }
                case R.id.measurable_chart_year:{
                    measurableDataList.get(position).setRange(1);
                    measurableDataAdapter.notifyItemChanged(position);
                    break;
                }

            }

        }

        @Override
        public void inItemLongClick(View v, int position) {

        }
    };

    private MeasurableDataAdapter.OnItemClickListener mOnItemClickListener = new MeasurableDataAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(getActivity(), "touch"+position,
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemLongClick(View v,int position) {
            Toast.makeText(getActivity(), "longtouch"+position,
                    Toast.LENGTH_SHORT).show();
        }


    };



    private  void initMeasurableData() {
        measurableDataList.clear();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < measurableDatas.length; j++) {
                measurableDataList.add(measurableDatas[j]);
            }
        }
    }
}
