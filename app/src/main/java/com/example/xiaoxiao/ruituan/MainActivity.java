package com.example.xiaoxiao.ruituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

/**
 * 抽屉效果
 * DrawerLayout与Fragment的联用
 * DrawerLayout相关：
 * 1.一般内容层使用framelayout
 * 2.slidingLayout需要设置一个layout_grative属性
 *   文档建议使用android:layout_gravity="start"
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener,OnItemClickListener{

    private DrawerLayout mDrawer_layout;  //抽屉式布局
    private LinearLayout mMenu_layout;

    private TextView tv_tab1,tv_tab2,tv_tab3,tv_tab4;
    public FragmentTransaction ft=null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ft = getSupportFragmentManager().beginTransaction();
        initView();

    }
    private void initView(){
        mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMenu_layout = (LinearLayout) findViewById(R.id.menu_layout);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_layout, TabOneFragment.newInstance(null, null));
        ft.addToBackStack(null);
        ft.commit();
        tv_tab1= (TextView) findViewById(R.id.tv_tab1);
        tv_tab1.setOnClickListener(this);
        tv_tab2= (TextView) findViewById(R.id.tv_tab2);
        tv_tab2.setOnClickListener(this);
        tv_tab3= (TextView) findViewById(R.id.tv_tab3);
        tv_tab3.setOnClickListener(this);
        tv_tab4= (TextView) findViewById(R.id.tv_tab4);
        tv_tab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fg;
        switch (v.getId()) {
            case R.id.tv_tab1:
                fg=TabOneFragment.newInstance(null,null);
                replaceFragment(fg);
                break;
            case R.id.tv_tab2:
                fg=TabTwoFragment.newInstance(null,null);
                replaceFragment(fg);
                break;
            case R.id.tv_tab3:
                fg=TabThreeFragment.newInstance(null,null);
                replaceFragment(fg);
                break;
            case R.id.tv_tab4:
                fg=TabFourFragment.newInstance(null,null);
                replaceFragment(fg);
                break;
        }
    }

    private void replaceFragment(Fragment newFragment) {
        if(!newFragment.isAdded()){
            try{
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_layout, newFragment);
                ft.addToBackStack(null);
                ft.commit();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }else
            ft.show(newFragment);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment = null;
        ft = getSupportFragmentManager().beginTransaction();
        //根据item点击行号判断启用指定Fragment
        switch (position){
            case 0:
                fragment = new FirstFragment();
                break;
            case 1:
                fragment = new NextFragment();
                break;
            default:
                fragment = new FirstFragment();
                break;
        }
        ft.replace(R.id.fragment_layout, fragment);
        ft.commit();
        mDrawer_layout.closeDrawer(mMenu_layout);//点击后关闭mMenu_layout
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            // 创建退出对话框
            AlertDialog.Builder isExit= new AlertDialog.Builder(this);
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setPositiveButton("确定", listener);
            isExit.setNegativeButton("取消", listener);
            // 显示对话框
            isExit.show();
        }
        return false;
    }
    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
}