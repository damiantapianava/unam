package mx.unam.login;

import android.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListaFragmentDMO extends Fragment
        implements AdapterView.OnItemClickListener, View.OnClickListener
{
    protected EditText mItemsText;

    protected View view;
    protected ListView listView;

    protected AdapterItemList adapter_item;

    protected Intent intent;

    protected ItemDataSource itemDataSource;

    protected ModelItem item;

    protected int counter;

    protected boolean isWifi;
}
