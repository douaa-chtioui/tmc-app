package tmc.ensi.org.tmcapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tmc.ensi.org.tmcapp.R;

public class ChronicDiseaseAdapter  extends BaseAdapter {


    private Context context;
    private ArrayList<Integer> idImages;
    private ArrayList<String> textViewList;


    public ChronicDiseaseAdapter(Context context, ArrayList<Integer> listId, ArrayList<String> textViewList) {
        this.context = context;
        this.idImages = listId;
        this.textViewList = textViewList;
    }

    @Override
    public int getCount() {
        return textViewList.size();
    }

    @Override
    public Object getItem(int i) {
        return textViewList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return idImages.get(i);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = view.inflate(context, R.layout.chronic_disease_list_design, null);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.chronicDiseaseImage);
        TextView textView = (TextView) view.findViewById(R.id.chronicDiseaseText);

        imageView.setImageResource(idImages.get(i));
        textView.setText(textViewList.get(i));

        return view;
    }
}
