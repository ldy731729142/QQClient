package com.example.qqclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<String> list=new ArrayList<>();
    Context context;

    public void set(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder holder = new ViewHolder(view1);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) holder.title.getLayoutParams();
        linearParams.width = MainActivity.widthPixels;// 控件的宽强制设置
        holder.title.setLayoutParams(linearParams); //使设置好的布局参数应用到控件
        holder.title.setText(list.get(i));
        holder.tv_shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });
        holder.tv_zhidin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title1=list.get(i);
                list.remove(i);
                list.add(0,title1);

                notifyDataSetChanged();
            }
        });
        return view1;
    }

    public static
    class ViewHolder {
        public View rootView;
        public TextView title;
        public TextView tv_zhidin;
        public TextView tv_shanchu;
        public LinearLayout line0;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.tv_zhidin = (TextView) rootView.findViewById(R.id.tv_zhidin);
            this.tv_shanchu = (TextView) rootView.findViewById(R.id.tv_shanchu);
            this.line0 = (LinearLayout) rootView.findViewById(R.id.line0);
        }

    }
}
