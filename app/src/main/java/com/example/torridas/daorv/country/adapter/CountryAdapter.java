package com.example.torridas.daorv.country.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.torridas.daorv.R;
import com.example.torridas.daorv.city.adapter.CityAdapter;
import com.example.torridas.daorv.country.model.Country;
import com.example.torridas.daorv.country.view.CountryFragment;

import java.util.List;

/**
 * Created by Torridas on 10-Jul-17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CostumViewHolder> {

    private Context mycontext;
    private List<Country> countriesList;
    private CountryFragment.OnCountrySelected mListener;

    public CountryAdapter(Context mycontext, List<Country> countriesList, CountryFragment.OnCountrySelected listener ) {
        this.mycontext = mycontext;
        this.countriesList = countriesList;
        this.mListener = listener;
    }

    @Override
    public CostumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tara_item, parent, false );
        CostumViewHolder costumViewHolder = new CostumViewHolder(view);
        return costumViewHolder;
    }

    @Override
    public void onBindViewHolder(CostumViewHolder holder, int position) {
        final Country country = countriesList.get(position);
        holder.textView.setText(country.getId() + " " + country.getName());
        holder.imageView.setImageResource(R.drawable.marea);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCountrySelected(country.getId());
            }
        });
    }


    @Override
    public int getItemCount() {
        if( countriesList != null )
            return countriesList.size();
        else
            return 0;
    }

    public class CostumViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public CostumViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.id);
            this.imageView = (ImageView) itemView.findViewById(R.id.steag);
        }
    }
}
