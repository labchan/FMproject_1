package com.example.fmproject_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fmproject_1.Model.workOrder;
import com.example.fmproject_1.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter

{

    Context context;
    ArrayList<workOrder> arrayList;

    public MyAdapter(Context context, ArrayList<workOrder> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.workorderlayout, null);
            //ImageView t_img = (ImageView) convertView.findViewById(R.id.image);
            TextView t_id = (TextView) convertView.findViewById(R.id.id);
            TextView t_location = (TextView) convertView.findViewById(R.id.location);
            TextView t_building = (TextView) convertView.findViewById(R.id.building);
            TextView t_description = (TextView) convertView.findViewById(R.id.description);

            workOrder workorder = arrayList.get(position);

            //t_img.setworkorder.getImg());
            t_id.setText(String.valueOf(workorder.getId()));
            t_location.setText(workorder.getLocation());
            t_building.setText(workorder.getBuilding());
            t_description.setText(workorder.getDescription());

        return convertView;
    }


}
