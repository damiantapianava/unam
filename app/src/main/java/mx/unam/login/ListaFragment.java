package mx.unam.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListaFragment extends ListaFragmentDMO
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.lista_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.listItems);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                adapter_item = (AdapterItemList) parent.getAdapter();

                item = adapter_item.getItem(position);
                item = listModelItem.get(position);

                Toast.makeText(getActivity(), item.item, Toast.LENGTH_SHORT).show();

                intent = new Intent(getActivity().getApplicationContext(), ItemDetailActivity.class);
                intent.putExtra("item", item.item);

                getActivity().startActivity(intent);
            }
        });

        mItemsText = (EditText) view.findViewById(R.id.mItemText);

        view.findViewById(R.id.btnAddItem).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String item_data = mItemsText.getText().toString();

                if(!TextUtils.isEmpty(item_data))
                {
                    item = new ModelItem();
                    item.item = item_data;
                    item.id   = "Description " + counter;
                    item.resource_id = isWifi ? R.drawable.ic_editor_insert_emoticon : R.drawable.ic_editor_insert_emoticon;

                    listModelItem.add(item);

                    listView.setAdapter(new AdapterItemList(getActivity(), listModelItem));

                    isWifi=!isWifi;
                    counter++;
                    mItemsText.setText("");
                }
            }
        });

        return view;
    }
}
