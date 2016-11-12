package com.guyj.permissions;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /**
     * TODO 配置所需的全部权限
     * 9个危险权限组分类，如有申请，则保留，如无申请，则整行注释
     * 权限组是指当组内权限被允许后，那么同组的权限则都允许使用
     * 以下是6.0下九组危险权限分类，请根据自己app的实际情况调整
     * 假设同时需要READ_EXTERNAL_STORAGE和WRITE_EXTERNAL_STORAGE权限时，可只申请一个，另一个也会默认通过
     */
    private String[] permissions = new String[]{
//            Manifest.permission.READ_CALENDAR,//WRITE_CALENDAR
            Manifest.permission.CAMERA,
//            Manifest.permission.READ_CONTACTS,//WRITE_CONTACTS，GET_ACCOUNTS
//            Manifest.permission.ACCESS_FINE_LOCATION,//ACCESS_COARSE_LOCATION
//            Manifest.permission.RECORD_AUDIO,
//            Manifest.permission.READ_PHONE_STATE,//CALL_PHONE,READ_CALL_LOG,WRITE_CALL_LOG,ADD_VOICEMAIL,USE_SIP,PROCESS_OUTGOING_CALLS
//            Manifest.permission.BODY_SENSORS,
            Manifest.permission.SEND_SMS,//RECEIVE_SMS,READ_SMS,RECEIVE_WAP_PUSH,RECEIVE_MMS
            Manifest.permission.READ_EXTERNAL_STORAGE,//WRITE_EXTERNAL_STORAGE
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            new CheckPermissionsForAPI23(this, permissions);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            checkPermissionsResult(requestCode, resultCode);
    }

    /**
     * 处理用户拒绝权限后的操作
     */
    private void checkPermissionsResult(int requestCode, int resultCode) {
        //sdk23+用 如果用户拒绝赋予你所需要的权限 则直接退出app，if内方法可自行斟酌
        if (requestCode == PermissionsActivity.REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }
}
