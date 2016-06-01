package com.titinkurniati.pawon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Titin Kurniati on 01-Jun-16.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<DataModel> listData;

    public ListAdapter(Context context, List<DataModel> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            ViewHolder viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.item_list, null);

            viewHolder.title = (TextView) view.findViewById(R.id.title_text);
            viewHolder.title.setText(listData.get(position).getTitle());
        } else {
            view = convertView;
        }
        return view;

    }

    static class ViewHolder {
        TextView title;

    }

}
