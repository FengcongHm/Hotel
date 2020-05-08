package com.example.myhotel.fragemnt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myhotel.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Shouye extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List<Hotel> hotels=new ArrayList<>();
        Hotel hotels1=new Hotel(R.drawable.huiyuan,"ahahah","dadaada");
        Hotel hotels2=new Hotel(R.drawable.huiyuan,"ahahah","dadaada");
        Hotel hotels3=new Hotel(R.drawable.huiyuan,"ahahah","dadaada");
        hotels.add(hotels1);
        hotels.add(hotels2);
        hotels.add(hotels3);

        View view=inflater.inflate(R.layout.shouye,container,false);
        ListView listView = (ListView)view. findViewById(R.id.list);
        MyAdapter myAdapter=new MyAdapter(getActivity(),hotels,R.layout.shouye_list_item);
        listView.setAdapter(myAdapter);

        return view;
    }
}
