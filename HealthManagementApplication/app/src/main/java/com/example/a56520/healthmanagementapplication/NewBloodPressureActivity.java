package com.example.a56520.healthmanagementapplication;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a56520.healthmanagementapplication.Adapter.NewDataLayout;
import com.example.a56520.healthmanagementapplication.Adapter.NewDataLayoutAdapter;
import com.example.a56520.healthmanagementapplication.db.BloodPressure;

import org.litepal.tablemanager.Connector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class NewBloodPressureActivity extends AppCompatActivity {

    public static final String ITEM_NAME = "血压";
    public static final String ITEM_IMAGE_ID = "item_image_id";

    private String mFilePath,mCutFilePath;
    private ImageView dietImageView;
    private static int REQ_2 =2;
    public final static int CHOOSE_PHOTO=3;

    private GridLayoutManager layoutManager;
    private List<NewDataLayout> newDataLayouts = new ArrayList<>();
    private NewDataLayoutAdapter newDataLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_blood_pressure);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra(ITEM_NAME);
        int itemImageId = intent.getIntExtra(ITEM_IMAGE_ID,0);
        initNewDataLayout(itemName);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.new_data_recyclerView);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        newDataLayoutAdapter = new NewDataLayoutAdapter(newDataLayouts);
        recyclerView.setAdapter(newDataLayoutAdapter);
        newDataLayoutAdapter.setInItemClickListener(mInItemClickListener);


        int i=(int)(Math.random()*100);
        mFilePath= Environment.getExternalStorageDirectory().getPath();//获取根路径
        String a= String.valueOf(i);

        mFilePath=mFilePath+"/"+"666"+"/"+"temp"+a+".png";

        Toolbar toolbar = (Toolbar)findViewById(R.id.new_blood_pressure_toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)
                findViewById(R.id.new_blood_pressure_collapsing_toolbar);
        ImageView titleImageView = (ImageView)findViewById(R.id.new_blood_pressure_app_bar_image_view);

        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(itemName);
        Glide.with(this).load(itemImageId).into(titleImageView);


        FloatingActionButton button = (FloatingActionButton)findViewById(R.id.new_data_floating_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //View view =layoutManager.findViewByPosition(1);
                //EditText editText =(EditText)view.findViewById(R.id.new_systolic_pressure_data);
                //String string = editText.getText().toString();
                Toast.makeText(NewBloodPressureActivity.this, "点击保存按钮",
                        Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initNewDataLayout(String itemName){
        newDataLayouts.clear();

        switch (itemName){
            case "血压":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(1));
                newDataLayouts.add(new NewDataLayout(21));
                newDataLayouts.add(new NewDataLayout(24));

                break;
            case "血糖":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(2));
                newDataLayouts.add(new NewDataLayout(22));
                newDataLayouts.add(new NewDataLayout(24));
                break;
            case "体重":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(6));
                newDataLayouts.add(new NewDataLayout(22));

                break;
            case "体温":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(4));
                newDataLayouts.add(new NewDataLayout(21));
                newDataLayouts.add(new NewDataLayout(24));

                break;
            case "心率":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(3));
                newDataLayouts.add(new NewDataLayout(24));

                break;
            case "血氧":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(5));
                newDataLayouts.add(new NewDataLayout(24));

                break;
            case "饮食":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(7));

                break;
            case "服药":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(8));

                break;
            case "过敏":

                newDataLayouts.add(new NewDataLayout(23));
                newDataLayouts.add(new NewDataLayout(10));
                break;
        }
    }

    private  NewDataLayoutAdapter.InItemClickListener mInItemClickListener =
            new NewDataLayoutAdapter.InItemClickListener() {
        @Override
        public void inItemClick(View v, int position) {
            dietImageView= layoutManager.findViewByPosition(position)
                    .findViewById(R.id.new_diet_data_imageView);
            switch(v.getId()){
                case R.id.new_diet_data_shot_button:{
                    Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Uri photoUri= Uri.fromFile(new File(mFilePath));
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                    startActivityForResult(cameraIntent,REQ_2);
                    newDataLayouts.add(new NewDataLayout(7));
                    break;

                }
                case R.id.new_diet_data_album_button:{
                    if(ContextCompat.checkSelfPermission(NewBloodPressureActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(NewBloodPressureActivity.this,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);//进行相册授权，发现没用还是要在Android中声明
                    }else {
                        openAlbum();//调用函数打开相册
                    }
                    newDataLayouts.add(new NewDataLayout(7));
                    break;

                }
                case R.id.new_diet_data_delete_button:{
                    newDataLayouts.remove(position);
                    break;
                }

            }
            newDataLayoutAdapter.notifyDataSetChanged();
        }

        @Override
        public void inItemLongClick(View v, int position) {

        }
    };


    private void openAlbum(){
        Intent albumIntent=new Intent("android.intent.action.GET_CONTENT");
        albumIntent.setType("image/*");
        startActivityForResult(albumIntent,CHOOSE_PHOTO);//调用startActivityForResult
    }

    @Override
    public void onRequestPermissionsResult(int requestCode1,String[] permissions,int[]grantReaults){//判断用户是否对相册权限打开
        switch (requestCode1){
            case 1:
                if (grantReaults.length>0&&grantReaults[0]==PackageManager.PERMISSION_GRANTED){
                    openAlbum();
                }else {
                    Toast.makeText(this,"你不允许",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        BloodPressure bloodPressuredata=new BloodPressure();
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQ_2) {//相机照片的展示
                FileInputStream fis = null;
                try {
                    /*fis = new FileInputStream(mFilePath);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);*/

                    String cameraFliePath=sizeCompress(mFilePath);
                    fis = new FileInputStream(cameraFliePath);
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    deleteImage(mFilePath);

                    dietImageView.setImageBitmap(bitmap);//展示图片
                    //luJing.setText(cameraFliePath);//展示路径

                    //Connector.getDatabase();

                    bloodPressuredata.setBloodPressureTestLocation(cameraFliePath);
                    bloodPressuredata.setUserCode(1);
                    bloodPressuredata.setBloodPressureTestDate(viewTime());
                    bloodPressuredata.save();//将路径存储到数据库

                    Toast.makeText(NewBloodPressureActivity.this,"保存成功",
                            Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        switch (requestCode){//判断Android的版本，因为版本不一样，获取路径的方式不一样
            case CHOOSE_PHOTO:
                if (resultCode==RESULT_OK){
                    if(Build.VERSION.SDK_INT>=19){
                        handleImageOnKitKat(data);
                    }else{
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }
    @TargetApi(19)
    private void handleImageOnKitKat(Intent data){//高版本的处理方法
        String imagePath=null;
        Uri uri=data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)){
            String dcoID=DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id=dcoID.split(":")[1];
                String selection=MediaStore.Images.Media._ID+"="+id;
                imagePath=getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);

            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri= ContentUris.withAppendedId(Uri.parse("content://download/public_downloads"),Long.valueOf(dcoID));
                imagePath=getImagePath(contentUri,null);

            }
        }else if ("content".equalsIgnoreCase(uri.getScheme())){
            imagePath=getImagePath(uri,null);
        }else if ("file".equalsIgnoreCase(uri.getScheme())){
            imagePath=uri.getPath();
        }
        displayImage(imagePath);//调用展示图片的函数

    }
    private void handleImageBeforeKitKat(Intent data){//低版本的处理方法
        Uri uri=data.getData();
        String imagePath=getImagePath(uri,null);
        displayImage(imagePath);//调用展示图片的函数
    }
    private String getImagePath(Uri uri,String selection){//获取路径
        String path=null;
        Cursor cursor=getContentResolver().query(uri,null,selection,null,null);
        if (cursor!=null){
            if (cursor.moveToFirst()){
                path=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
    private void displayImage(String imagePath){//相册的展示图片
        if (imagePath!=null){
            String cutAlbumPictureFilePath=sizeCompress(imagePath);
            Bitmap bitmap= BitmapFactory.decodeFile(cutAlbumPictureFilePath);
            dietImageView.setImageBitmap(bitmap);//相册的展示图片
            //luJing.setText(cutAlbumPictureFilePath);//相册的展示路径
        }else {
            Toast.makeText(this,"未能得到图片",Toast.LENGTH_SHORT).show();
        }
    }

    private String sizeCompress(String getPath){
        BitmapFactory.Options newOpts=new BitmapFactory.Options();
        newOpts.inJustDecodeBounds=true;
        Bitmap bitmap=BitmapFactory.decodeFile(getPath,newOpts);
        newOpts.inJustDecodeBounds=false;

        int width=newOpts.outWidth;
        int height=newOpts.outHeight;
        float hh=800f;
        float ww=480f;

        int be=1;
        if (width>height&&width>ww){
            be=(int)(newOpts.outWidth/ww);
        }else if (width<height&&height>hh){
            be=(int)(newOpts.outHeight/hh);
        }
        if (be<=0){
            be=1;
        }
        newOpts.inSampleSize=be;
        bitmap=BitmapFactory.decodeFile(getPath,newOpts);
        return compressQuality(bitmap);
    }
    private String compressQuality(Bitmap image){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,baos);
        int options=100;
        while (baos.toByteArray().length/1024>100){
            baos.reset();;
            image.compress(Bitmap.CompressFormat.JPEG,options,baos);
            options=options-10;
        }
        ByteArrayInputStream isBm=new ByteArrayInputStream(baos.toByteArray());
        Bitmap savingBitmap=BitmapFactory.decodeStream(isBm,null,null);
        String finalFilePath=saveMyBitmap(savingBitmap);
        return finalFilePath;
    }
    public String saveMyBitmap(Bitmap cutSavingBitmap){
        mCutFilePath= Environment.getExternalStorageDirectory().getPath();//获取根路径
        mCutFilePath=mCutFilePath+"/"+"666"+"/"+"temp666"+".png";
        File cutFile=new File(mCutFilePath);
        try {
            cutFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fOut=null;
        try {
            fOut=new FileOutputStream(cutFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cutSavingBitmap.compress(Bitmap.CompressFormat.PNG,100,fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mCutFilePath;
    }
    public void deleteImage(String deletePath){
        /*String deldete=Environment.getExternalStorageDirectory().getPath()+"/"+"666"+"/"+"temp0"+".png";*/
        String delete=deletePath;
        File file=new File(delete);
        if (file.exists())file.delete();
        else Toast.makeText(NewBloodPressureActivity.this, "账号不存在",
                Toast.LENGTH_SHORT).show();
    }

    private int viewTime(){
        String year,month,day,hour,minute,second;
        Calendar cal;
        final String allTimeText;
        String all;
        int allTime;
        final long testTime;
        cal=Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        year=String.valueOf(cal.get(Calendar.YEAR));
        month=String.valueOf(cal.get(Calendar.MONTH)+1);
        day=String.valueOf(cal.get(Calendar.DATE));
        if (cal.get(Calendar.AM_PM)==0)
            hour=String.valueOf( cal.get(Calendar.HOUR));
        else
            hour=String.valueOf( cal.get(Calendar.HOUR)+12);
        minute=String.valueOf(cal.get(Calendar.MINUTE));
        second=String.valueOf(cal.get(Calendar.SECOND));
        //allTimeText=year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分"+second+"秒";
        //all=year+month+day+hour+minute+second;
        allTime=Integer.parseInt(year)%100;
        allTime=allTime*100+(Integer.parseInt(month));
        allTime=allTime*100+(Integer.parseInt(day));
        allTime=allTime*100+(Integer.parseInt(hour));
        allTime=allTime*100+(Integer.parseInt(minute));
        allTimeText= String.valueOf(allTime);
        Toast.makeText(NewBloodPressureActivity.this, allTimeText,
                Toast.LENGTH_SHORT).show();
        return allTime;
    }




}
