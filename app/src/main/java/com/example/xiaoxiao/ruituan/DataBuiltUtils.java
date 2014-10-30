package com.example.xiaoxiao.ruituan;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBuiltUtils {

    public static ArrayList<HashMap<String,String>> getMainMapList(){
        ArrayList<HashMap<String, String>> tempMapList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<5;i++){
            HashMap<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("menu", "菜单【"+(i+1)+"】");
            tempMapList.add(tempMap);
        }
        return tempMapList;
    }

    public static ArrayList<HashMap<String,String>> getFirstMapList(){
        ArrayList<HashMap<String, String>> tempMapList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<5;i++){
            HashMap<String, String> tempMap = new HashMap<String, String>();
            tempMap.put("menu", "FirstFragment菜单【"+(i+1)+"】");
            tempMapList.add(tempMap);
        }
        return tempMapList;
    }
}
