package mx.unam.login;

import android.app.Fragment;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListaFragmentDMO extends Fragment
{
    protected View view;
    protected ListView listView;
    protected ModelItem item;
    protected AdapterItemList adapter_item;
    protected EditText mItemsText;
    protected Intent intent;

    protected List<ModelItem> listModelItem = new ArrayList<>();

    protected int counter;
    protected boolean isWifi;
}
