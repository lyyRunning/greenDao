package com.function.luo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.function.luo.bean.DaoMaster;
import com.function.luo.bean.StudentDao;
import com.github.yuweiguocn.library.greendao.MigrationHelper;


/**
 * Created by cyb on 2018/04/03.
 * 版本更新需要添加字段
 */

public class MySqliteOpenHelper extends DaoMaster.OpenHelper {

    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }



    /**
     * 需要在实体类加一个字段 或者 改变字段属性等 就需要版本更新来保存以前的数据了
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);

            //这里添加要增加的字段
            MigrationHelper.migrate(db, StudentDao.class);

    }
}
