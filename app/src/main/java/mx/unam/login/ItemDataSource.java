package mx.unam.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ItemDataSource
{
    private SQLiteDatabase db;

    private MySqliteHelper helper;

    private ContentValues contentValues;

    public ItemDataSource(Context context)
    {
        helper = new MySqliteHelper(context);

        db = helper.getWritableDatabase();
    }

    public void saveItem(ModelItem modelItem)
    {
        contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.COLUMN_ITEM_NAME,     modelItem.item);
        contentValues.put(MySqliteHelper.COLUMN_ITEM_DESC,     modelItem.description);
        contentValues.put(MySqliteHelper.COLUMN_ITEM_RESOURCE, modelItem.resource_id);

        db.insert(MySqliteHelper.TABLE_NAME,null,contentValues);
    }

    public void deleteItem(ModelItem modelItem)
    {
        db.delete(MySqliteHelper.TABLE_NAME, MySqliteHelper.COLUMN_ID+"=?", new String[]{String.valueOf(modelItem.id)});
    }

    public List<ModelItem> getAllItems()
    {
        List<ModelItem> modelItemList = new ArrayList<>();

        Cursor cursor = db.query(MySqliteHelper.TABLE_NAME,null,null,null,null,null,null);

        while (cursor.moveToNext())
        {
            int id             = cursor.getInt   (cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ID));
            String itemName    = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ITEM_NAME));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ITEM_DESC));
            int resourceId     = cursor.getInt   (cursor.getColumnIndexOrThrow(MySqliteHelper.COLUMN_ITEM_RESOURCE));

            ModelItem modelItem = new ModelItem();

            modelItem.id = id;
            modelItem.resource_id = resourceId;
            modelItem.description = description;
            modelItem.item = itemName;

            modelItemList.add(modelItem);
        }

        return modelItemList;
    }
}
