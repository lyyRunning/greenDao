package com.function.luo.day0620;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.function.luo.bean.DaoMaster;
import com.function.luo.bean.DaoSession;
import com.function.luo.utils.MySqliteOpenHelper;
import com.github.yuweiguocn.library.greendao.MigrationHelper;

/**
 * Created by luo on 2019/6/20.
 */

public class MyApplication  extends Application{

    private static DaoSession daoSession;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initGreenDao();
    }



    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private void initGreenDao() {
        // 初始化//如果你想查看日志信息，请将 DEBUG 设置为 true
        if (BuildConfig.DEBUG){
            MigrationHelper.DEBUG = true;
        }else {
            MigrationHelper.DEBUG = false;
        }

        //数据库名字
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(mContext, "greenDaoTest.db",null);

        SQLiteDatabase db = mySqliteOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);


        daoSession = daoMaster.newSession();


    }

    /**
     * 提供一个全局的会话
     * @return
     */
    public static DaoSession getDaoSession() {
        return daoSession;
    }

    /**
     * 提供一个全局的上下文
     * @return
     */
    public static Context getApplication(){
        return  mContext;
    }
}
