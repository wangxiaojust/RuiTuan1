package com.example.xiaoxiao.ruituan;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;

/**
 * 抽屉效果
 * DrawerLayout与Fragment的联用
 * DrawerLayout相关：
 * 1.一般内容层使用framelayout
 * 2.slidingLayout需要设置一个layout_grative属性
 *   文档建议使用android:layout_gravity="start"
 */
public class MainActivity extends FragmentActivity{

    private DrawerLayout mDrawer_layout;  //抽屉式布局
    private LinearLayout mMenu_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mMenu_layout = (LinearLayout) findViewById(R.id.menu_layout);
        ListView menu_listview = (ListView) mMenu_layout.findViewById(R.id.menu_listView);
        ArrayList<HashMap<String, String>> tempMapList = DataBuiltUtils.getMainMapList();
        menu_listview.setAdapter(new MenuListViewAdapter( getApplicationContext(), tempMapList));
        //菜单ListView设置监听事件
        menu_listview.setOnItemClickListener(new DrawerItemClickListener());
    }

    public class DrawerItemClickListener implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment fragment = null;
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
    }
}