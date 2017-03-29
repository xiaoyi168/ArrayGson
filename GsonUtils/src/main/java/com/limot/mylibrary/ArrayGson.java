package com.limot.mylibrary;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mr Li  on 2017/3/28.
 */

public class ArrayGson {


    /**
     * 改方法有改动，可以防止接收的数据和bean不一致导致的报错
     * GSON优化，防止数据类型和bean不一致导致报错
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public <T> T fromJson(String json, Class<T> classOfT){

        try {
            return  new Gson().fromJson(json, classOfT);

        }
        catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }


    /**
     * 改方法没有改动，直接用
     * @param src
     * @return
     */
    public  String toJson(Object src){

        return  new Gson().toJson(src);

    }


/*
    public  <T> List<T>  fromArray(String src, final Class<T> clazz){

        Gson gson=new Gson();

        List<T> arrayList=new ArrayList<>();

        Type type = new TypeToken<ArrayList<T>>() {}.getType();

        arrayList=gson.fromJson(src, type);

         return arrayList;


    }*/


    /**
     * 直接解析纯json数组
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {

        try {
            ArrayList<T> mList = new ArrayList<T>();
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for(final JsonElement elem : array){
                mList.add(new Gson().fromJson(elem, cls));
            }
            return mList;
        }
        catch (Exception e){
            return null;
        }

    }



}
