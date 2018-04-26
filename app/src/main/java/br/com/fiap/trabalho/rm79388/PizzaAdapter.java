package br.com.fiap.trabalho.rm79388;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    Context context;
    List<PizzaMenu> pizzaList;

    public PizzaAdapter(Context context, List<PizzaMenu> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
    }

    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout = LayoutInflater.from(context);
        PizzaMenu m = pizzaList.get(position);
        View v = layout.inflate(R.layout.listview_pizza, null);

        TextView name = v.findViewById(R.id.name);
        ImageView img = v.findViewById(R.id.img);
        TextView price = v.findViewById(R.id.price);
        TextView observations = v.findViewById(R.id.observations);

        name.setText(m.getName());
        img.setImageResource(R.drawable.pizza);
        price.setText(String.format(context.getString(R.string.real) + m.getPrice()));
        observations.setText(m.getObservations());

        return v;
    }
}
