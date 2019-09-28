package com.example.pbhackathon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("Abhishek Nath")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Abhishek Nath");
                    intent.putExtra("contentTv", "Product ID:PR1511003040091\n\nName:Abhishek Nath\n\nContact Number:9939877777\n\nOrder Value:Rs.100/-");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Arundhati Raj")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Arundhati Raj");
                    intent.putExtra("contentTv", "Product ID:PR1711003040018\n\nName:Arundhati Raj\n\nContact Number:9162616666\n\nOrder Value:Rs.1000/-");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Vishal Balaji")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Vishal Balaji");
                    intent.putExtra("contentTv", "Product ID:PR1411003040067\n\nName:Vishal Balaji\n\nContact Number:9431017776\n\nOrder Value:Rs.225/-");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Purushotamman")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Purushotamman");
                    intent.putExtra("contentTv", "Product ID:PR161103040078\n\nName:Purushotamman\n\nContact Number:962717777\n\nOrder Value:Rs.1200/-");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Rohit M.")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Rohit M.");
                    intent.putExtra("contentTv", "Product ID:PR1911003040105\n\nName:Rohit M.\n\nContact Number:9263030129\n\nOrder Value:Rs.3560/-");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}