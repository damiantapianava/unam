package mx.unam.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource
{
    private SQLiteDatabase db;

    private MySqliteHelper helper;

    private ContentValues contentValues;

    public UserDataSource(Context context)
    {
        helper = new MySqliteHelper(context);

        db = helper.getWritableDatabase();
    }

    public boolean saveItem(ModelUser user)
    {
        contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_USER_NAME, user.getUserName());
        contentValues.put(MySqliteHelper.COLUMN_USER_PASS, user.getPassword());

        long row_id = db.insert(MySqliteHelper.TABLE_NAME_USER, null, contentValues);

        if(row_id > 0) return true;
        else return false;
    }
}
