package mx.unam.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource extends UserDataSourceDMO
{
    public UserDataSource(Context context)
    {
        helper = new MySqliteHelper(context);

        db = helper.getWritableDatabase();
    }

    public boolean persist(ModelUser user)
    {
        contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_USER_NAME, user.getUserName());
        contentValues.put(MySqliteHelper.COLUMN_USER_PASS, user.getPassword());

        long row_id = db.insert(MySqliteHelper.TABLE_NAME_USER, null, contentValues);

        if(row_id > 0)
        {
            return true;

        }  else {

            return false;
        }
    }

    public ModelUser findUserById(Integer userId)
    {
        selection = MySqliteHelper.COLUMN_ID + " = ?";

        selectionArgs = new String[]{userId.toString()};

        cursor = db.query(MySqliteHelper.TABLE_NAME_USER, null, selection, selectionArgs, null, null, null);

        if(cursor.moveToNext())
        {
            Integer id    = cursor.getInt   (cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ID));
            this.username = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_USER_NAME));
            this.password = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_USER_PASS));

            user = new ModelUser();
            user.setId(id);
            user.setUserName(this.username);
            user.setPassword(this.password);

        } else {

            user = null;
        }

        return user;
    }

    public ModelUser findUser(String username, String password)
    {
        modelUserList = new ArrayList<>();

        sb = new StringBuilder();
        sb.append(MySqliteHelper.COLUMN_USER_NAME).append(" =  ? ").append(" AND ");
        sb.append(MySqliteHelper.COLUMN_USER_PASS).append(" =  ? ");

        selection = sb.toString();

        selectionArgs = new String[]{username, password};

        cursor = db.query(MySqliteHelper.TABLE_NAME_USER,null, selection, selectionArgs, null,null,null);

        while (cursor.moveToNext())
        {
            Integer id    = cursor.getInt   (cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ID));
            this.username = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_USER_NAME));
            this.password = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_USER_PASS));

            user = new ModelUser();
            user.setId(id);
            user.setUserName(this.username);
            user.setPassword(this.password);

            modelUserList.add(user);
        }

        if(!modelUserList.isEmpty())
        {
            user = modelUserList.get(0);

        } else {

            user = null;
        }

        return user;
    }
}
