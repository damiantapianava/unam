package mx.unam.login;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public abstract class MySqliteHelperDMO extends SQLiteOpenHelper
{
    protected final static String DATABASE_NAME ="unamsqlite";

    protected final static int DATABASE_VERSION = 5;

    public static final String TABLE_NAME = "item_table";
    public static final String TABLE_NAME_USER = "user_table";

    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_ITEM_NAME = "name";
    public static final String COLUMN_ITEM_DESC = "description";
    public static final String COLUMN_ITEM_RESOURCE = "resource_id";

    public static final String COLUMN_USER_NAME = "username";
    public static final String COLUMN_USER_PASS = "password";

    protected static final String CREATE_TABLE  = "create table IF NOT EXISTS " + TABLE_NAME + " ( " +
            COLUMN_ID + " integer primary key autoincrement,"+
            COLUMN_ITEM_NAME + " text not null,"+
            COLUMN_ITEM_DESC + " text not null,"+
            COLUMN_ITEM_RESOURCE + " integer not null)";

    protected static final String CREATE_TABLE_USER  = "create table IF NOT EXISTS " + TABLE_NAME_USER + " ( " +
            COLUMN_ID + " integer primary key autoincrement,"+
            COLUMN_USER_NAME + " text not null,"+
            COLUMN_USER_PASS + " text not null)";

    public MySqliteHelperDMO(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
