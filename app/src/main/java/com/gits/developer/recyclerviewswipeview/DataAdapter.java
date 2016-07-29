package com.gits.developer.recyclerviewswipeview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sasha Grey on 7/29/2016.
 */

public class DataAdapter extends RecyclerView.Adapter {

    private ArrayList countries;

    public DataAdapter(ArrayList countries) {
        this.countries = countries;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tv_country.setText(countries.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }

    public void removeItem(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_country;
        public ViewHolder(View view) {
            super(view);

            tv_country = (TextView)view.findViewById(R.id.tv_country);
        }
    }
}