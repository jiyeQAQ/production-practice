package com.example.a56520.healthmanagementapplication.fragment.detailfragment.detailtakeinfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a56520.healthmanagementapplication.Adapter.ImageRollingAdapter;
import com.example.a56520.healthmanagementapplication.Adapter.ImageRollingData;
import com.example.a56520.healthmanagementapplication.Adapter.ShowGraphicsAndTextData;
import com.example.a56520.healthmanagementapplication.Adapter.ShowGraphicsAndTextDataAdapter;
import com.example.a56520.healthmanagementapplication.R;
import com.example.a56520.healthmanagementapplication.db.BloodPressure;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class DietFragment extends Fragment {
    private ShowGraphicsAndTextDataAdapter showGraphicsAndTextDataAdapter;
    private ImageRollingAdapter imageRollingAdapter;
    private GridLayoutManager sLayoutManager;
    private LinearLayoutManager iLayoutManager;
    private String b[];
    private int a[]={R.drawable.apple,R.drawable.banana,R.drawable.cherry,R.drawable.grape,
            R.drawable.mango,R.drawable.watermelon,R.drawable.strawberry,R.drawable.pineapple};
    private String tag[]={"饿","好饿","超级饿"};
    private List<ShowGraphicsAndTextData> showGraphicsAndTextDataList= new ArrayList<>();
    private List<ImageRollingData> imageRollingDataList = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_detail_take_in_diet,
                container,false);


//        Connector.getDatabase();
//        List<BloodPressure> bloodPressures = DataSupport.findAll(BloodPressure.class);
//                .select("bloodPressureTestLocation")
//                .where("bloodPressureTestLocation != ?","null")
//                .findALL(BloodPressure.class);
//        if(bloodPressures.size()!=0){
//            for(int i= 0;i<bloodPressures.size();i++){
//                b[i]=bloodPressures.get(i).getBloodPressureTestLocation();
//            }
//        }
        //initShowGraphicsAndTextDataList();
        RecyclerView sRecyclerView = v.findViewById(R.id.detail_take_in_diet_recyclerView);
        sLayoutManager = new GridLayoutManager(getActivity(),1);
        sRecyclerView.setLayoutManager(sLayoutManager);
        //if(b.length!=0){
            ShowGraphicsAndTextData showGraphicsAndTextData= new ShowGraphicsAndTextData("饮食", 1809072322,a,tag);
            showGraphicsAndTextDataList.add(showGraphicsAndTextData);
        //}
        showGraphicsAndTextDataAdapter = new ShowGraphicsAndTextDataAdapter(showGraphicsAndTextDataList);
        sRecyclerView.setAdapter(showGraphicsAndTextDataAdapter);
//

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){


        super.onActivityCreated(savedInstanceState);

    }

//    private void initShowGraphicsAndTextDataList(){
//        int a[]={1};
//        String tag[]={"饿","好饿","超级饿"};
//        showGraphicsAndTextDataList.add(new ShowGraphicsAndTextData("饮食",
//                1809072322,a,tag));
//    }
}
