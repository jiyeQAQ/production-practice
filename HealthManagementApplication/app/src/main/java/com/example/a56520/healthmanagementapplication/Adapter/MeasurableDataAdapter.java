package com.example.a56520.healthmanagementapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a56520.healthmanagementapplication.NewBloodPressureActivity;
import com.example.a56520.healthmanagementapplication.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MeasurableDataAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private int SINGLE_DATA=1,DOUBLE_DATA=2,CHART_VIEW=3;

    private Context mContext;
    private List<MeasurableData> mMeasurableDataList;

//
//    public interface OnItemClickListener{
//        void onItemClick(View view,int position);
//        void onItemLongClick(View view,int position);
//    }
    public interface InItemClickListener {
        void inItemClick(View v, int position);
        void inItemLongClick(View v,int position);
    }

    public interface OnItemClickListener  {

        void onItemClick(View v, int position);

        void onItemLongClick(View v,int position);

    }

    private OnItemClickListener mOnItemClickListener;
    private InItemClickListener mInItemClickListener;


//    public OnItemClickListener mOnItemClickListener;//第二步：声明自定义的接口

    //第三步：定义方法并暴露给外面的调用者

    public void setOnItemClickListener(OnItemClickListener  OnItemClickListener) {

        this.mOnItemClickListener  = OnItemClickListener;

    }
    public void setInItemClickListener(InItemClickListener  InItemClickListener) {

        this.mInItemClickListener  = InItemClickListener;

    }


    public  MeasurableDataAdapter(List<MeasurableData> measurableDatas){
        this.mMeasurableDataList = measurableDatas;
    }

    class SingleDataViewHolder extends RecyclerView.ViewHolder{
        TextView measurable_single_data_name,measurable_single_data_number,measurable_single_data_unit
                ,measurable_single_data_date,measurable_single_data_time;
        public SingleDataViewHolder(View view){
            super(view);
            measurable_single_data_date = (TextView)view.findViewById(R.id.measurable_single_data_date);
            measurable_single_data_time = (TextView)view.findViewById(R.id.measurable_single_data_time);
            measurable_single_data_name = (TextView) view.findViewById(R.id.measurable_single_data_name);
            measurable_single_data_number = (TextView) view.findViewById(R.id.measurable_single_data_number);
            measurable_single_data_unit = (TextView) view.findViewById(R.id.measurable_single_data_unit);
        }
    }

    class DoubleDataViewHolder extends RecyclerView.ViewHolder{
        TextView measurable_double_data_date,measurable_double_data_time,measurable_double_data_name1,
                measurable_double_data_number1,measurable_double_data_unit1,measurable_double_data_name2,
                measurable_double_data_number2,measurable_double_data_unit2;
        public DoubleDataViewHolder(View view){
            super(view);
            measurable_double_data_date = (TextView)view.findViewById(R.id.measurable_double_data_date);
            measurable_double_data_time = (TextView)view.findViewById(R.id.measurable_double_data_time);
            measurable_double_data_name1 = (TextView) view.findViewById(R.id.measurable_double_data_name1);
            measurable_double_data_number1 = (TextView) view.findViewById(R.id.measurable_double_data_number1);
            measurable_double_data_unit1 = (TextView) view.findViewById(R.id.measurable_double_data_unit1);
            measurable_double_data_name2 = (TextView) view.findViewById(R.id.measurable_double_data_name2);
            measurable_double_data_number2 = (TextView) view.findViewById(R.id.measurable_double_data_number2);
            measurable_double_data_unit2 = (TextView) view.findViewById(R.id.measurable_double_data_unit2);

        }
    }

    class ChartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LineChart lineChart;
        Button chartDayButton,chartWeekButton,chartMonthButton,chartYearButton;
        public ChartViewHolder(View view){
            super(view);
            lineChart =(LineChart)view.findViewById(R.id.measurable_chart_LineChart);
            chartDayButton = (Button)view.findViewById(R.id.measurable_chart_day);
            chartWeekButton = (Button)view.findViewById(R.id.measurable_chart_week);
            chartMonthButton = (Button)view.findViewById(R.id.measurable_chart_month);
            chartYearButton = (Button)view.findViewById(R.id.measurable_chart_year);

            lineChart.setOnClickListener(this);
            chartDayButton.setOnClickListener(this);
            chartWeekButton.setOnClickListener(this);
            chartMonthButton.setOnClickListener(this);
            chartYearButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(mInItemClickListener != null){
                mInItemClickListener.inItemClick(v,getAdapterPosition());
            }
        }
    }



    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view;

        if (viewType == SINGLE_DATA) {
            view = LayoutInflater.from(mContext).inflate(R.layout.measurable_single_data,
                    parent, false);
            return new SingleDataViewHolder(view);
        } else if (viewType == DOUBLE_DATA) {
            view = LayoutInflater.from(mContext).inflate(R.layout.measurable_double_data,
                    parent, false);
            return new DoubleDataViewHolder(view);
        } else if (viewType == CHART_VIEW) {
            view = LayoutInflater.from(mContext).inflate(R.layout.measurable_chart_view,
                    parent, false);
            return new ChartViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.measurable_single_data,
                    parent, false);
            return new SingleDataViewHolder(view);
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

        if(holder instanceof SingleDataViewHolder){
            MeasurableData measurableData = mMeasurableDataList.get(position);
            SingleDataViewHolder viewHolder = (SingleDataViewHolder)holder;

            viewHolder.measurable_single_data_date.setText((measurableData.getDate()/1000000)+"/"+((measurableData.getDate()/10000)%100));
            viewHolder.measurable_single_data_time.setText(((measurableData.getDate()%10000)/100)+":"+(measurableData.getDate()%100));
            viewHolder.measurable_single_data_name.setText(measurableData.getDataType());
            viewHolder.measurable_single_data_number.setText(measurableData.getBodyTemperature()+"");
            switch(measurableData.getDataType()){
                case "体温":{
                    viewHolder.measurable_single_data_number.setText(((float)measurableData.getBodyTemperature())/10+"");
                    viewHolder.measurable_single_data_unit.setText("℃");
                    break;
                }case "体重":{
                    viewHolder.measurable_single_data_number.setText(((float)measurableData.getBodyWeight())/100+"");
                    viewHolder.measurable_single_data_unit.setText("Kg");
                    break;
                }case"心率":{
                    viewHolder.measurable_single_data_number.setText(((float)measurableData.getHeartRate())+"");
                    viewHolder.measurable_single_data_unit.setText("次/分钟");
                    break;
                }case"血糖":{
                    viewHolder.measurable_single_data_number.setText(((float)measurableData.getBloodGlucose())/10+"");
                    viewHolder.measurable_single_data_unit.setText("mmol/L");
                    break;
                }case"血氧":{
                    viewHolder.measurable_single_data_number.setText(((float)measurableData.getBloodOxygen())+"");
                    viewHolder.measurable_single_data_unit.setText("%");
                    break;
                }
            }

        }else if(holder instanceof DoubleDataViewHolder){
            MeasurableData measurableData = mMeasurableDataList.get(position);
            DoubleDataViewHolder viewHolder =(DoubleDataViewHolder)holder;
            viewHolder.measurable_double_data_date.setText((measurableData.getDate()/1000000)+"/"+((measurableData.getDate()/10000)%100));
            viewHolder.measurable_double_data_time.setText(((measurableData.getDate()%10000)/100)+":"+(measurableData.getDate()%100));
            viewHolder.measurable_double_data_name1.setText("收缩压");
            viewHolder.measurable_double_data_number1.setText(measurableData.getSystolicPressure()+"");
            viewHolder.measurable_double_data_unit1.setText("mmHg");
            viewHolder.measurable_double_data_name2.setText("舒张压");
            viewHolder.measurable_double_data_number2.setText(measurableData.getDiastolicPressure()+"");
            viewHolder.measurable_double_data_unit2.setText("mmHg");

        }else if(holder instanceof ChartViewHolder){
            MeasurableData measurableData = mMeasurableDataList.get(position);
            final ChartViewHolder viewHolder =(ChartViewHolder)holder;


            //-----------------------------LineChart部分---------------------------//
            LineChart mLineChart = viewHolder.lineChart;
            //图例设置
            Legend legend = mLineChart.getLegend();
            legend.setEnabled(true);
            legend.setForm(Legend.LegendForm.CIRCLE);

            //坐标轴位置、线条设置
            XAxis xAxis = mLineChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            YAxis rightAxis = mLineChart.getAxisRight();
            rightAxis.setDrawAxisLine(false);
            rightAxis.setDrawLabels(false);

            //图表设置
            mLineChart.getDescription().setEnabled(false);
            mLineChart.setDrawBorders(true);
            mLineChart.setNoDataText("暂无数据");//没数据的时候显示什么
            mLineChart.setTouchEnabled(false);//不可放缩

            //获取今日时间、日期、星期
            GregorianCalendar today = new GregorianCalendar();
            int todayYear=today.get(Calendar.YEAR)%100;
            int todayMonth=today.get(Calendar.MONTH)+1;
            int todayDate=today.get(Calendar.DATE);
            int todayDay=today.get(Calendar.DAY_OF_WEEK);
            if (todayDay==1){
                todayDay=7;
            }
            else{
                todayDay=todayDay-1;
            }

            //获取本月天数
            int daysOfMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (todayYear % 4 == 0) {
                daysOfMonth[1] = 29;
            }

            final int thisMonthDays = daysOfMonth[todayMonth - 1];


//-----------------------------判断是纳四种类型--------------------贾怡萱负责-----------------------///
            switch (mMeasurableDataList.get(position).getRange()){
                case 1: {
                            //Y轴数据处理,将这一年所有的数据处理成每个月的数据（该月所有数据取平均值）
                            float yearData[] = new float[12];

                            //yearDataCount=0作为这一年没有任何数据的标志，若查到该年有数据则改变其值
                            int yearDataCount = 0;
                            for (int j = 0; j < 12; j++) {
                                float total = 0;
                                int monthCount = 0;//用于累计某个月有几条数据，以便于作均值处理
                                float average = 0;
                                int monthj = j + 1;
                                int monthflag;
                                for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                    monthflag = (mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100;
                                    if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && (monthflag == monthj)) {
                                        if ((mMeasurableDataList.get(position).getDataType() == "体温") || (mMeasurableDataList.get(position).getDataType() == "血糖")) {
                                            total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 10;
                                        }
                                        else if (mMeasurableDataList.get(position).getDataType() == "体重"){
                                            total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 100;
                                        }
                                        else {
                                            total = total + (float) mMeasurableDataList.get(position).getTestResult1()[i];
                                        }
                                        monthCount++;
                                    }
                                }
                                //如果某月没有数据，则该月填0作为标志，以便于后续添加数据的判断，是0表示该X点没有对应的Y点，则不产生一对成对数据
                                if (monthCount != 0) {
                                    average = total / monthCount;
                                    yearDataCount++;
                                }
                                yearData[j] = average;
                            }

                            List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();//dataSets用于存放需要添加到图表的线，线条的数量必须大于0，否则会闪退

                            if (yearDataCount != 0) {

                                //自定义X轴内容
                                //自定义X轴之前，必须对要填入图表的成对数据是否为空进行判断，否则在没有数据时会产生一张乱表
                                final String[] months = new String[]{"1月", "2月", "3月", "4月", "5月", "6月",
                                        "7月", "8月", "9月", "10月", "11月", "12月"};
                                IAxisValueFormatter formatter = new IAxisValueFormatter() {
                                    @Override
                                    public String getFormattedValue(float value, AxisBase axis) {
                                        //用value传入X轴上所有的点，将这些点进行取整等处理，返回与之相对应的字符串
                                        int a = (int) Math.floor(value);
                                        //定义域是到11，因此要对大于11的value进行处理，否则会报错数组越界产生各种问题
                                        if (a > 11) a = 11;
                                        return months[a];
                                    }
                                };

                                //设置X轴刻度、定义域
                                xAxis.setAxisMaximum(11);
                                xAxis.setAxisMinimum(0);
                                xAxis.setLabelCount(11);
                                xAxis.setValueFormatter(formatter);

                                //设置X轴字体旋转角度
                                xAxis.setLabelRotationAngle(0);//设置x轴字体显示角度


                                //向entries中添加成对数据
                                //写在对yearDataCount的判断里，是因为向entries中添加的成对数据为空时也会产生一张乱表
                                List<Entry> entries = new ArrayList<>();
                                for (int i = 0; i < 12; i++) {
                                    if (yearData[i] != 0) {
                                        entries.add(new Entry(i, (float) yearData[i]));//Entry的添加顺序：X轴数据必须从小到大排列
                                    }
                                }

                                //向dataStes中添加一条线
                                //写在对yearDataCount的判断里，是因为成对数据为空时不能建立LineDataSet，否则会闪退
                                LineDataSet lineDataSet1;
                                if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                                    lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年收缩压");
                                }
                                else {
                                    lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年" + mMeasurableDataList.get(position).getDataType());
                                }

                                //线条设置
                                lineDataSet1.setDrawFilled(false);//曲线所包围区域是否填充
                                lineDataSet1.setColor(Color.BLUE);//第一条线的颜色
                                lineDataSet1.setCircleColor(Color.BLUE);//数据点图例的颜色
                                lineDataSet1.setDrawCircleHole(true);//图例的圆形是否空心*/
                                dataSets.add(lineDataSet1);
                            }

                            //如果是血压，则要添加第二条线
                            if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                                float yearData2[] = new float[12];
                                for (int j = 0; j < 12; j++) {
                                    float total = 0;
                                    int monthCount = 0;
                                    float average = 0;
                                    int monthj = j + 1;
                                    int monthflag;
                                    for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                        monthflag = (mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100;
                                        if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && (monthflag == monthj)) {
                                            total = total + (float) mMeasurableDataList.get(position).getTestResult2()[i];
                                            monthCount++;
                                        }
                                    }
                                    if (monthCount != 0) {
                                        average = total / monthCount;
                                    }
                                    yearData2[j] = average;
                                }

                                if (yearDataCount != 0) {
                                    List<Entry> entries2 = new ArrayList<>();
                                    for (int i = 0; i < 12; i++) {
                                        if (yearData2[i] != 0) {
                                            entries2.add(new Entry(i, (float) yearData2[i]));
                                        }
                                    }

                                    LineDataSet lineDataSet2 = new LineDataSet(entries2, "20" + todayYear + "年舒张压");//定义第一条线
                                    lineDataSet2.setDrawFilled(false);
                                    lineDataSet2.setColor(Color.GREEN);
                                    lineDataSet2.setCircleColor(Color.GREEN);
                                    lineDataSet2.setDrawCircleHole(true);
                                    dataSets.add(lineDataSet2);
                                }
                            }

                            if (yearDataCount != 0) {
                                //将dataSets中的线显示到图表中。
                                LineData data = new LineData(dataSets);
                                mLineChart.setData(data);
                            }
                            else {
                                //当添加的成对数据为空时，必须清空图表使之显示预设的“暂无数据”，否则会和其他图表的按钮冲突，显示其他按钮下的内容
                                mLineChart.clear();
                            }
                    break;
                }

                case 2: {
                        float monthData[] = new float[thisMonthDays];
                        int monthDataCount=0;
                        for (int j = 0; j < thisMonthDays; j++) {
                            float total = 0;
                            int dateCount = 0;
                            float average = 0;
                            //dataj用来表示我们正在寻找这个月几号的数据
                            int datej = j + 1;
                            for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && ((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100 == todayMonth) && (datej == ((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100))) {
                                    if ((mMeasurableDataList.get(position).getDataType() == "体温") || (mMeasurableDataList.get(position).getDataType() == "血糖")) {
                                        total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 10;
                                    }
                                    else if (mMeasurableDataList.get(position).getDataType() == "体重"){
                                        total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 100;
                                    }
                                    else {
                                        total = total + (float) mMeasurableDataList.get(position).getTestResult1()[i];
                                    }
                                    dateCount++;
                                }
                            }
                            if (dateCount != 0) {
                                average = total / dateCount;
                                monthDataCount++;
                            }
                            monthData[j] = average;
                        }
                        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

                        if (monthDataCount!=0) {
                            IAxisValueFormatter formatter = new IAxisValueFormatter() {
                                @Override
                                public String getFormattedValue(float value, AxisBase axis) {
                                    int a = (int) Math.floor(value) + 1;
                                    if (a > thisMonthDays) a = thisMonthDays;
                                    String b = ((Integer) a).toString();
                                    return b;
                                }
                            };

                            xAxis.setAxisMaximum(thisMonthDays - 1);
                            xAxis.setAxisMinimum(0);
                            xAxis.setLabelCount(thisMonthDays - 1);
                            xAxis.setValueFormatter(formatter);
                            xAxis.setLabelRotationAngle(0);

                            List<Entry> entries = new ArrayList<>();
                            for (int i = 0; i < thisMonthDays; i++) {
                                if (monthData[i] != 0) {
                                    entries.add(new Entry(i, (float) monthData[i]));
                                }
                            }
                            LineDataSet lineDataSet1;
                            if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                                lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年" + todayMonth + "月收缩压");
                            } else {
                                lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年" + todayMonth + "月" + mMeasurableDataList.get(position).getDataType());
                            }
                            lineDataSet1.setDrawFilled(false);
                            lineDataSet1.setColor(Color.BLUE);
                            lineDataSet1.setCircleColor(Color.BLUE);
                            lineDataSet1.setDrawCircleHole(true);
                            dataSets.add(lineDataSet1);
                        }
                        if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                            float monthData2[] = new float[thisMonthDays];
                            for (int j = 0; j < thisMonthDays; j++) {
                                float total = 0;
                                int dateCount = 0;
                                float average = 0;
                                int datej = j + 1;
                                for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                    if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && ((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100 == todayMonth) && (datej == ((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100))) {
                                        total = total + (float) mMeasurableDataList.get(position).getTestResult2()[i];
                                        dateCount++;
                                    }
                                }
                                if (dateCount != 0) {
                                    average = total / dateCount;
                                }
                                monthData2[j] = average;
                            }
                            if (monthDataCount!=0) {
                                List<Entry> entries2 = new ArrayList<>();
                                for (int i = 0; i < thisMonthDays; i++) {
                                    if (monthData2[i] != 0) {
                                        entries2.add(new Entry(i, (float) monthData2[i]));
                                    }
                                }
                                LineDataSet lineDataSet2 = new LineDataSet(entries2, "20" + todayYear + "年" + todayMonth + "月舒张压");//定义第一条线
                                lineDataSet2.setDrawFilled(false);
                                lineDataSet2.setColor(Color.GREEN);
                                lineDataSet2.setCircleColor(Color.GREEN);
                                lineDataSet2.setDrawCircleHole(true);
                                dataSets.add(lineDataSet2);
                            }
                        }

                        if (monthDataCount!=0) {
                            LineData data = new LineData(dataSets);
                            mLineChart.setData(data);
                        }
                        else {
                            mLineChart.clear();
                        }
                    break;
                }

                case 3:{
                        float weekData[] = new float[7];
                        int weekDataCount=0;
                        //这周还没到来的那几天填0，作为无数据的标志
                        for (int i = todayDay; i < 7; i++) {
                            weekData[i] = 0;
                        }
                        //以下三个变量，用来标志我们正在寻找几年几月几日的数据
                        int monthj = todayMonth;
                        int datej = todayDate;
                        int yearj = todayYear;
                        for (int j = 0; j < todayDay; j++) {
                            float total = 0;
                            int timeCount = 0;
                            float average = 0;
                            if (datej == 0) {
                                if (todayMonth == 1) {
                                    monthj = 12;
                                    yearj = todayYear - 1;
                                } else {
                                    monthj = todayMonth - 1;
                                }
                                datej = daysOfMonth[monthj - 1];
                            }
                            for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == yearj) &&
                                        ((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100 == monthj) &&
                                        (((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100) == datej)) {
                                    if ((mMeasurableDataList.get(position).getDataType() == "体温") || (mMeasurableDataList.get(position).getDataType() == "血糖")) {
                                        total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 10;
                                    }
                                    else if (mMeasurableDataList.get(position).getDataType() == "体重"){
                                        total = total + ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 100;
                                    }
                                    else {
                                        total = total + (float) mMeasurableDataList.get(position).getTestResult1()[i];
                                    }
                                    timeCount++;
                                }
                            }
                            if (timeCount != 0) {
                                average = total / timeCount;
                                weekDataCount++;
                            }
                            //和本年、本月数据不一样，本周数据是逆向查找数据，即先查找今天，再查找昨天，日期一直往前推，直到查到本周周一
                            weekData[todayDay - j - 1] = average;
                            datej = datej - 1;
                        }

                        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                        if (weekDataCount!=0) {
                            final String[] weeks = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周天"};//自定义X轴内容
                            IAxisValueFormatter formatter = new IAxisValueFormatter() {
                                @Override
                                public String getFormattedValue(float value, AxisBase axis) {
                                    int a = (int) Math.floor(value);
                                    if (a > 6) a = 6;
                                    return weeks[a];
                                }
                            };
                            xAxis.setAxisMaximum(6);
                            xAxis.setAxisMinimum(0);
                            xAxis.setLabelCount(6);
                            xAxis.setValueFormatter(formatter);
                            xAxis.setLabelRotationAngle(0);

                            List<Entry> entries = new ArrayList<>();
                            for (int i = 0; i < 7; i++) {
                                if (weekData[i] != 0) {
                                    entries.add(new Entry(i, (float) weekData[i]));
                                }
                            }
                            LineDataSet lineDataSet1;
                            if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                                lineDataSet1 = new LineDataSet(entries, "本周收缩压");
                            } else {
                                lineDataSet1 = new LineDataSet(entries, "本周" + mMeasurableDataList.get(position).getDataType());
                            }
                            lineDataSet1.setDrawFilled(false);
                            lineDataSet1.setColor(Color.BLUE);
                            lineDataSet1.setCircleColor(Color.BLUE);
                            lineDataSet1.setDrawCircleHole(true);
                            dataSets.add(lineDataSet1);
                        }

                        if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                            float weekData2[] = new float[7];
                            for (int i = todayDay; i < 7; i++) {
                                weekData2[i] = 0;
                            }

                            monthj = todayMonth;
                            datej = todayDate;
                            yearj = todayYear;
                            for (int j = 0; j < todayDay; j++) {
                                float total = 0;
                                int timeCount = 0;
                                float average = 0;

                                if (datej == 0) {
                                    if (todayMonth == 1) {
                                        monthj = 12;
                                        yearj = todayYear - 1;
                                    } else {
                                        monthj = todayMonth - 1;
                                    }
                                    datej = daysOfMonth[monthj - 1];
                                }

                                for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                    if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == yearj) && ((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100 == monthj) && (((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100) == datej)) {
                                        total = total + (float) mMeasurableDataList.get(position).getTestResult2()[i];
                                        timeCount++;
                                    }
                                }
                                if (timeCount != 0) {
                                    average = total / timeCount;
                                }
                                weekData2[todayDay - j - 1] = average;
                                datej = datej - 1;
                            }
                            if (weekDataCount!=0) {
                                List<Entry> entries2 = new ArrayList<>();
                                for (int i = 0; i < 7; i++) {
                                    if (weekData2[i] != 0) {
                                        entries2.add(new Entry(i, (float) weekData2[i]));
                                    }
                                }

                                LineDataSet lineDataSet2 = new LineDataSet(entries2, "本周舒张压");
                                lineDataSet2.setDrawFilled(false);
                                lineDataSet2.setColor(Color.GREEN);
                                lineDataSet2.setCircleColor(Color.GREEN);
                                lineDataSet2.setDrawCircleHole(true);
                                dataSets.add(lineDataSet2);
                            }
                        }

                        if (weekDataCount!=0) {
                            LineData data = new LineData(dataSets);
                            mLineChart.setData(data);
                        }
                        else {
                            mLineChart.clear();
                        }
                    break;
                }

                case 4:{
                        //获取每一分的数据，一天共有1440分钟
                        float minuteData[] = new float[1440];
                        int minuteDataCount=0;
                        int minutej;
                        for (int j = 0; j < 1440; j++) {
                            int found = 0;
                            //j表示今天的第j秒，minutej将今天的第j秒转化成例如810（8点10分）的整型，然后以minutej为依据，查找该时刻的数据
                            minutej = 100 * (j / 60) + (j % 60);
                            for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && (((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100) == todayMonth) && (((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100) == todayDate) && (minutej == (mMeasurableDataList.get(position).getTestDate()[i]) % 10000)) {
                                    if ((mMeasurableDataList.get(position).getDataType() == "体温") || (mMeasurableDataList.get(position).getDataType() == "血糖")) {
                                        minuteData[j] = ((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 10;
                                    }
                                    else if (mMeasurableDataList.get(position).getDataType() == "体重"){
                                        minuteData[j] =((float) mMeasurableDataList.get(position).getTestResult1()[i]) / 100;
                                    }
                                    else {
                                        minuteData[j] = (float) mMeasurableDataList.get(position).getTestResult1()[i];
                                    }
                                    found++;
                                    minuteDataCount++;
                                    break;
                                }
                            }
                            if (found == 0) {
                                minuteData[j] = 0;
                            }
                        }

                        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                        if (minuteDataCount!=0) {
                            //自定义X轴是从00:00到24:00，是因为数组中最后一个字符串是在图表的最后一个刻度下的（即图表的最右边缘）
                            //如果按照前几个case的逻辑将X轴极限定义到23:00，则23:00到23:59之间的数据都不能显示。可以理解为年、月、周的数据是离散的，而一天之内的数据是连续的
                            final String[] months = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00","24:00"};//自定义X轴内容
                            IAxisValueFormatter formatter = new IAxisValueFormatter() {
                                @Override
                                public String getFormattedValue(float value, AxisBase axis) {
                                    int a = (int) Math.floor(value);
                                    if (a > 24) a = 24;
                                    return months[a];
                                }
                            };
                            xAxis.setAxisMaximum(24);
                            xAxis.setAxisMinimum(0);
                            xAxis.setLabelCount(24);
                            xAxis.setValueFormatter(formatter);
                            xAxis.setLabelRotationAngle(-90);

                            List<Entry> entries = new ArrayList<>();
                            for (int i = 0; i < 1440; i++) {
                                if (minuteData[i] != 0) {
                                    entries.add(new Entry((((float) i) / 60), (float) minuteData[i]));
                                }
                            }

                            LineDataSet lineDataSet1;
                            if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                                lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年" + todayMonth + "月" + todayDate + "日收缩压");
                            } else {
                                lineDataSet1 = new LineDataSet(entries, "20" + todayYear + "年" + todayMonth + "月" + todayDate + "日" + mMeasurableDataList.get(position).getDataType());
                            }
                            lineDataSet1.setDrawFilled(false);
                            lineDataSet1.setColor(Color.BLUE);
                            lineDataSet1.setCircleColor(Color.BLUE);
                            lineDataSet1.setDrawCircleHole(true);
                            dataSets.add(lineDataSet1);
                        }

                        if (mMeasurableDataList.get(position).getDataType().equals("血压")) {
                            float minuteData2[] = new float[1440];
                            for (int j = 0; j < 1440; j++) {
                                int found = 0;
                                minutej = 100 * (j / 60) + (j % 60);
                                for (int i = 0; i < mMeasurableDataList.get(position).getTestDate().length; i++) {
                                    if ((mMeasurableDataList.get(position).getTestDate()[i] / 100000000 == todayYear) && (((mMeasurableDataList.get(position).getTestDate()[i] / 1000000) % 100) == todayMonth) && (((mMeasurableDataList.get(position).getTestDate()[i] / 10000) % 100) == todayDate) && (minutej == (mMeasurableDataList.get(position).getTestDate()[i]) % 10000)) {
                                        minuteData2[j] = (float) mMeasurableDataList.get(position).getTestResult2()[i];
                                        found++;
                                        break;
                                    }
                                }
                                if (found == 0) {
                                    minuteData2[j] = 0;
                                }
                            }
                            if (minuteDataCount!=0) {
                                List<Entry> entries2 = new ArrayList<>();
                                for (int i = 0; i < 1440; i++) {
                                    if (minuteData2[i] != 0) {
                                        entries2.add(new Entry((((float) i) / 60), (float) minuteData2[i]));
                                    }
                                }
                                LineDataSet lineDataSet2 = new LineDataSet(entries2, "20" + todayYear + "年" + todayMonth + "月" + todayDate + "日舒张压");
                                lineDataSet2.setDrawFilled(false);
                                lineDataSet2.setColor(Color.GREEN);
                                lineDataSet2.setCircleColor(Color.GREEN);
                                lineDataSet2.setDrawCircleHole(true);
                                dataSets.add(lineDataSet2);
                            }
                        }
                        if (minuteDataCount!=0) {
                            LineData data = new LineData(dataSets);
                            mLineChart.setData(data);
                        }
                        else {
                            mLineChart.clear();
                        }
                    break;
                }
            }
        }
    }


    @Override
    public int getItemCount(){
        return  mMeasurableDataList.size();
    }

    @Override
    public int getItemViewType(int position){
        if(mMeasurableDataList.get(position).getTag()==SINGLE_DATA){
            return SINGLE_DATA;
        }else if(mMeasurableDataList.get(position).getTag()==DOUBLE_DATA){
            return DOUBLE_DATA;
        }else if(mMeasurableDataList.get(position).getTag()==CHART_VIEW){
            return CHART_VIEW;
        }else {
            return 0;
        }
    }


}
