package com.muju.note.launcher.util.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muju.note.launcher.app.home.bean.AdvertsBean;
import com.muju.note.launcher.util.Constants;
import com.muju.note.launcher.util.log.LogFactory;
import com.muju.note.launcher.util.sp.SPUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CacheUtil {
    /**
     * 获取广告List
     * @param
     * @return
     */
    public static List<AdvertsBean> getDataList(String code) {
        List<AdvertsBean> datalist=new ArrayList<AdvertsBean>();
        String response = SPUtil.getString(Constants.ZKYS_ADVERTS);
        Gson gson = new Gson();
        try {
            JSONObject jsonObject = new JSONObject(response);
            if(jsonObject.optInt("code")==200){
                JSONArray data = jsonObject.getJSONArray("data");
                for (int i = 0; i < data.length(); i++) {
                    JSONObject obj=data.getJSONObject(i);
                    if(obj.optString("code").equals(code)){
                        String adverts=obj.optString("adverts");
                        if(!adverts.equals("[]")){
                            datalist=gson.fromJson(adverts, new TypeToken<List<AdvertsBean>>() {}.getType());
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogFactory.l().e("e==="+e.getMessage());
            e.printStackTrace();
        }

        return datalist;
    }
}
