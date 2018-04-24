package br.com.fiap.trabalho.rm79388;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends BaseAdapter {
    Context context;
    List<Menu> menu;

    public MenuAdapter(Context context, List<Menu> menu) {
        this.context = context;
        this.menu = menu;
    }

    @Override
    public int getCount() {
        return menu.size();
    }

    @Override
    public Object getItem(int position) {
        return menu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout = LayoutInflater.from(context);
        Menu m = menu.get(position);
        View v = layout.inflate(R.layout.listview_pizza, null);

        //ImageView img = v.findViewById(R.id.img);
        TextView name = v.findViewById(R.id.name);
        TextView price = v.findViewById(R.id.price);

        //img.setImageResource(m.getImg());
        name.setText(m.getName());
        price.setText(String.format("R$ " + m.getPrice()));

        return v;
    }
}
