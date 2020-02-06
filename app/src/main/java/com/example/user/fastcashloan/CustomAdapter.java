package com.example.user.fastcashloan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] component_image;
    String[] component_name;
    Context context;

    private LayoutInflater layoutInflater;
    CustomAdapter(Context context,String[] component_name,int[]component_image)
    {
        this.context=context;
        this.component_name=component_name;
        this.component_image=component_image;
    }
    @Override
    public int getCount() {
        return component_name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.sampleview,viewGroup,false);
        }
        TextView textView=view.findViewById(R.id.componentID);
        ImageView imageView=view.findViewById(R.id.IconID);
        textView.setText(component_name[i]);
        imageView.setImageResource(component_image[i]);

        return view;

}}
