package mx.unam.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MySqliteHelper extends MySqliteHelperDMO
{
    public MySqliteHelper(Context context)
    {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE_USER);

        Log.d(ServiceTimer.TAG,"MySqliteHelper.onCreate(): OK");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.d(ServiceTimer.TAG, "MySqliteHelper.onUpgrade(): from " + oldVersion+ " to " + newVersion);

        db.execSQL(CREATE_TABLE);

        db.execSQL("DROP TABLE " + TABLE_NAME_USER);

        db.execSQL(CREATE_TABLE_USER);
    }
}
