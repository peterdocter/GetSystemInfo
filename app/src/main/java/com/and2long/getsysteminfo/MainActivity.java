package com.and2long.getsysteminfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.activity_system_info));

        layout = (LinearLayout) findViewById(R.id.layout_infos);
        getIP();
        getDisplayMetrics();
    }

    /**
     * 获取ip地址
     */
    private void getIP() {
        //获取wifi服务
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        String ip = intToIp(ipAddress);
        TextView textView = new TextView(this);
        textView.setText("IP地址：" + ip);
        layout.addView(textView);
    }


    private String intToIp(int i) {
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                (i >> 24 & 0xFF);
    }


    private void getDisplayMetrics() {
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        int densityDpi = dm.densityDpi;
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        TextView tvDensity = new TextView(this);
        TextView tvDensityDpi = new TextView(this);
        TextView tvWidth = new TextView(this);
        TextView tvheight = new TextView(this);
        TextView tvXdpi = new TextView(this);
        TextView tvYdpi = new TextView(this);

        tvDensity.setText("density：" + density);
        tvDensityDpi.setText("densityDpi：" + densityDpi);
        tvWidth.setText("widthPixels : " + widthPixels);
        tvheight.setText("heightPixels : " + heightPixels);
        tvXdpi.setText("xdpi : " + xdpi);
        tvYdpi.setText("ydpi : " + ydpi);

        layout.addView(tvDensity);
        layout.addView(tvDensityDpi);
        layout.addView(tvWidth);
        layout.addView(tvheight);
        layout.addView(tvXdpi);
        layout.addView(tvYdpi);


    }
}
