package com.muju.note.launcher.url;

public class UrlUtil {

    //    public static final String HOST_DEFAULT = "http://pad.zgzkys.com";
    public static final String HOST_DEFAULT = "http://test.pad.zgzkys.com";
//    public static final String HOST_DEFAULT = "http://192.168.1.114:8086";
//    public static final String HOST_DEFAULT = "http://192.168.1.200:8086";

    public static String getHost(){
        return HOST_DEFAULT;
    }

    /**
     *   获取平板配置信息
     * @return
     */
    public static String getPadConfigsNew(){
        return getHost()+"/padConfig/getConfig";
    }

}
