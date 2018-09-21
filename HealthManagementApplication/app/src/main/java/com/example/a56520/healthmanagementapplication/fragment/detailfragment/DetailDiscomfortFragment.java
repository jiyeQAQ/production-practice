package com.example.a56520.healthmanagementapplication.fragment.detailfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a56520.healthmanagementapplication.Adapter.DiscomfortData;
import com.example.a56520.healthmanagementapplication.Adapter.DiscomfortDataAdapter;
import com.example.a56520.healthmanagementapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DetailDiscomfortFragment extends Fragment {

    private DiscomfortDataAdapter mDiscomfortDataAdapter;
    private GridLayoutManager layoutManager;
    private List<DiscomfortData> mDiscomfortDataList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_detail_discomfort_page,
                container,false);

        initDiscomfortDataType();
        RecyclerView recyclerView = v.findViewById(R.id.detail_discomfort_left_recyclerView);
        layoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        mDiscomfortDataAdapter = new DiscomfortDataAdapter(mDiscomfortDataList);
        recyclerView.setAdapter(mDiscomfortDataAdapter);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){


        super.onActivityCreated(savedInstanceState);

    }


    private void initDiscomfortDataType(){
        mDiscomfortDataList.add(new DiscomfortData("四肢",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("口腔",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("面部",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("臀部",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("腰部",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("会阴",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("皮肤",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("上肢",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("颈部",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("五官",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("眼",R.drawable.apple));
        mDiscomfortDataList.add(new DiscomfortData("全身",R.drawable.banana));

    }
}