package mx.unam.login;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterItemList extends ArrayAdapter<ModelItem>
{
    private TextView txt_item;
    private TextView txt_item_desc;
    private ImageView img;
    private ModelItem model;

    public AdapterItemList(Context context, List<ModelItem> list)
    {
        super(context, 0, list);
    }

    @Nullable
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        }

        txt_item      = (TextView)  convertView.findViewById(R.id.txt_item);
        txt_item_desc = (TextView)  convertView.findViewById(R.id.txt_item_description);
        img           = (ImageView) convertView.findViewById(R.id.row_img_view);

        model = getItem(position);

        txt_item.setText     (model.item);
        txt_item_desc.setText(model.id);
        img.setImageResource (model.resource_id);

        return convertView;
    }
}
