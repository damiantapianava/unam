package mx.unam.login;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public abstract class UserDataSourceDMO
{
    protected SQLiteDatabase db;

    protected MySqliteHelper helper;

    protected ContentValues contentValues;

    protected Cursor cursor;

    protected StringBuilder sb;

    protected ModelUser user;

    protected List<ModelUser> modelUserList;

    protected String username;
    protected String password;
    protected String last_login_date;
    protected String selection;

    protected String[] selectionArgs;
}
