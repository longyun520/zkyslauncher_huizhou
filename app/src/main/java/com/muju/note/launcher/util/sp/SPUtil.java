package com.muju.note.launcher.util.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muju.note.launcher.base.LauncherApplication;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Johnny-R on 2017/6/27.
 * 一个用户id文件
 * 一个账号对应一个文件
 */
public class SPUtil {
    private static SharedPreferences getSharedPreferences() {
        SharedPreferences sp = LauncherApplication.getContext().getSharedPreferences("zkys_pad", Context.MODE_PRIVATE);
        return sp;
    }


    public static void putString(String key, String value) {
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }


    public static String getString(String key) {
        SharedPreferences sp = getSharedPreferences();
        return sp.getString(key, "");
    }

    public static void putInt(String key, int value){
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key, value);
    }

    public static int getInt(String key){
        SharedPreferences sp=getSharedPreferences();
        return sp.getInt(key,0);
    }

    public static void putLong(String key, long value) {
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor edit = sp.edit();
        edit.putLong(key, value);
        edit.commit();
    }

    public static long getLong(String key) {
        SharedPreferences sp = getSharedPreferences();
        return sp.getLong(key, -1);
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean getBoolean(String key) {
        SharedPreferences sp = getSharedPreferences();
        return sp.getBoolean(key, false);
    }

    /**
     * 保存集合到本地
     *
     * @param key
     * @param value
     */
    public static void saveMapData(@NonNull String key, @NonNull Map<String, String> value) {
        Gson gson = new Gson();
        String editRescueOrder = gson.toJson(value);
        SPUtil.putString(key, editRescueOrder);
    }

    public static Map<String, String> getMapData(@NonNull String key) {
        if (TextUtils.isEmpty(getString(key))) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> map = gson.fromJson(getString(key), type);
        return map;

    }

    public static <T> void saveDataList(String tag, List<T> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        //转换成json数据，再保存
        String strJson = gson.toJson(datalist);
//        Log.e("zkpad","saveDataList-strJson=="+strJson);
        editor.putString(tag, strJson);
        editor.commit();
    }
}
