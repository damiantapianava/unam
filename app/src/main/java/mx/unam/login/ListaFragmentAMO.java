package mx.unam.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public abstract class ListaFragmentAMO extends ListaFragmentDMO
{
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        adapter_item = (AdapterItemList) parent.getAdapter();

        item = adapter_item.getItem(position);

        Toast.makeText(getActivity(), item.item, Toast.LENGTH_SHORT).show();

        intent = new Intent(getActivity().getApplicationContext(), ItemDetailActivity.class);
        intent.putExtra("item", item.item);

        getActivity().startActivity(intent);
    }

    @Override
    public void onClick(View v)
    {
        String item_data = mItemsText.getText().toString();

        if(!TextUtils.isEmpty(item_data))
        {
            item = new ModelItem();
            item.item = item_data;
            item.description = "Description " + counter;
            item.resource_id = isWifi ? R.drawable.ic_editor_insert_emoticon : R.drawable.ic_action_settings_voice;

            itemDataSource.saveItem(item);

            listView.setAdapter(new AdapterItemList(getActivity(), itemDataSource.getAllItems()));

            isWifi = !isWifi;
            counter++;
            mItemsText.setText("");
        }
    }
}
