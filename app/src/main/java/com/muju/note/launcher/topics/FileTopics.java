package com.muju.note.launcher.topics;

import android.os.Environment;

import java.io.File;

public class FileTopics {

    /**
     *  激活文件
     */
    public static final String FILE_ACTIVE_INFO = Environment.getExternalStorageDirectory().toString() + File.separator + "zkys" + File.separator + "active.info";

}
