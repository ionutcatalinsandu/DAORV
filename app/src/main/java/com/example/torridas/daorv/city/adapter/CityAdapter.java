package com.example.torridas.daorv.city.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.torridas.daorv.R;
import com.example.torridas.daorv.city.model.City;

import java.util.List;

/**
 * Created by Torridas on 10-Jul-17.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CostumViewHolder>
{

    private Context context;
    private List<City> citiesList;

    public CityAdapter(Context context, List<City> citiesList) {
        this.context = context;
        this.citiesList = citiesList;
    }

    @Override
    public CostumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.oras_item, parent, false);
        CostumViewHolder viewHolder = new CostumViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CostumViewHolder holder, int position) {
        City city = citiesList.get(position);
        holder.nume.setText(city.getName());

    }

    @Override
    public int getItemCount() {
        if( citiesList != null )
            return citiesList.size();
        else
            return 0;
    }

    public class CostumViewHolder extends RecyclerView.ViewHolder {

        private TextView nume;

        public CostumViewHolder(View itemView) {
            super(itemView);
            this.nume = (TextView)itemView.findViewById(R.id.nume_oras);
        }
    }
}
