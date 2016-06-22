package mx.unam.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ListaFragment extends ListaFragmentAMO
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        itemDataSource = new ItemDataSource(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.lista_fragment, container, false);

        mItemsText = (EditText) view.findViewById(R.id.mItemText);

        listView   = (ListView) view.findViewById(R.id.listItems);
        listView.setOnItemClickListener(this);

        List<ModelItem> modelItemList = itemDataSource.getAllItems();
        isWifi = !(modelItemList.size()%2==0);
        counter = modelItemList.size();
        listView.setAdapter(new AdapterItemList(getActivity(),modelItemList));

        view.findViewById(R.id.btnAddItem).setOnClickListener(this);

        return view;
    }
}
