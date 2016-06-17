package mx.unam.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ItemDetailActivity extends AppCompatActivity
{
    private ImageView img_view;
    private TextView txt;

    private int img_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_detail);

        img_view = (ImageView) findViewById(R.id.img_item_detail);

        Random random = new Random();

        switch(random.nextInt(4))
        {
            case 1:
                img_id = R.drawable.ic_action_settings_voice;
                break;
            case 2:
                img_id = R.drawable.ic_device_signal_wifi_4_bar;
                break;
            case 3:
                img_id = R.drawable.ic_editor_insert_emoticon;
                break;

            default:
                img_id = R.mipmap.ic_launcher;
                break;
        }

        txt = (TextView) findViewById(R.id.txt_item_detail);

        String item = getIntent().getExtras().getString("item");

        txt.setText(item);

        img_view.setImageResource(img_id);
    }
}
