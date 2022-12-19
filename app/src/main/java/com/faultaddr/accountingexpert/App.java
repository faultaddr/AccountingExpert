package com.faultaddr.accountingexpert;

import android.app.Application;

import com.faultaddr.greendaoapp.db.DaoMaster;
import com.faultaddr.greendaoapp.db.DaoSession;
import com.faultaddr.greendaoapp.db.RecordDetailDao;

import org.greenrobot.greendao.database.Database;

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        // regular SQLite database
        ExampleOpenHelper helper = new ExampleOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();

        // encrypted SQLCipher database
        // note: you need to add SQLCipher to your dependencies, check the build.gradle file
        // ExampleOpenHelper helper = new ExampleOpenHelper(this, "notes-db-encrypted");
        // Database db = helper.getEncryptedWritableDb("encryption-key");

        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static class ExampleOpenHelper extends DaoMaster.OpenHelper {

        public ExampleOpenHelper(App context, String name) {
            super(context, name);
        }

        @Override
        public void onCreate(Database db) {
            super.onCreate(db);

            // Insert some example data.
            // INSERT INTO NOTE (_id, DATE, TEXT) VALUES(1, 0, 'Example Note')
            db.execSQL("INSERT INTO " + RecordDetailDao.TABLENAME + " (" +
                    RecordDetailDao.Properties.Id.columnName + ", " +
                    RecordDetailDao.Properties.Detail.columnName + ", " +
                    RecordDetailDao.Properties.Category.columnName + ", " +
                    RecordDetailDao.Properties.Amount.columnName + ", " +
                    RecordDetailDao.Properties.Account.columnName + ", " +
                    RecordDetailDao.Properties.Date.columnName + ", " +
                    RecordDetailDao.Properties.Timestamp.columnName +
                    ") VALUES(1,'有点意思','nnb',100.00,'abc', '2022-12-19',1671389476)");
        }
    }
}
