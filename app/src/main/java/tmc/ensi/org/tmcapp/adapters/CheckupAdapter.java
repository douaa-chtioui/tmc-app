package tmc.ensi.org.tmcapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import tmc.ensi.org.tmcapp.R;
import tmc.ensi.org.tmcapp.model.Checkup;

public class CheckupAdapter extends ArrayAdapter<Checkup> {
    Context context ;
    int ressource ;
    public CheckupAdapter(@NonNull Context context, int resource, @NonNull List<Checkup> objects) {
        super(context, resource, objects);
        this.context = context;
        this.ressource = resource ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(ressource, parent , false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvphone = (TextView)convertView.findViewById(R.id.tv_phone);
        Checkup currentCheckup = getItem(position);
        tvName.setText(currentCheckup.getName());
        tvphone.setText(String.valueOf(currentCheckup.getPhone()));
        return convertView ;
    }
}

