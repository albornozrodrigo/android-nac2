package br.com.fiap.trabalho.rm79388;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PizzaDialogAdapter extends BaseAdapter {
    Context context;
    PizzaMenu pizza;

    public PizzaDialogAdapter(Context context, PizzaMenu pizza) {
        this.context = context;
        this.pizza = pizza;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout = LayoutInflater.from(context);
        PizzaMenu p = this.pizza;
        View v = layout.inflate(R.layout.pizza_dialog, null);

        TextView name = v.findViewById(R.id.name);
        TextView price = v.findViewById(R.id.price);
        ImageView img = v.findViewById(R.id.img);
        TextView points = v.findViewById(R.id.points);
        TextView calories = v.findViewById(R.id.calories);
        TextView observations = v.findViewById(R.id.observations);

        name.setText(p.getName());
        price.setText(String.format(context.getString(R.string.real) + p.getPrice()));
        img.setImageResource(R.drawable.pizza);
        points.setText(String.format(context.getString(R.string.avaliacao) + p.getPoints()));
        calories.setText(String.format(context.getString(R.string.calorias) + p.getCalories()));
        observations.setText(p.getObservations());

        return v;
    }
}
