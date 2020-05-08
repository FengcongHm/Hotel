package com.example.myhotel.fragemnt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myhotel.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<Hotel> hotels=new ArrayList<>();
    private int itemLayoutId;
    private Context context;

    public MyAdapter(Context context, List<Hotel> hotels, int itemLayoutId){
        this.hotels=hotels;
        this.itemLayoutId=itemLayoutId;
        this.context=context;
    }


    @Override
    public int getCount() {
        if (null != hotels) {
            return hotels.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (null != hotels) {
            return hotels.get(position);
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(null!=convertView){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemLayoutId, null);
        }
        ImageView photo = convertView.findViewById(R.id.hotel_photo);
        TextView adress=convertView.findViewById(R.id.hotel_adress);
        TextView name=convertView.findViewById(R.id.hotel_name);

        photo.setImageResource(hotels.get(position).getPhotoId());
        adress.setText(hotels.get(position).getAdress());
        name.setText(hotels.get(position).getName());

        return convertView;
    }
}
