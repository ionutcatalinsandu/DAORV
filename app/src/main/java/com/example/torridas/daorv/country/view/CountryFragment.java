package com.example.torridas.daorv.country.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.torridas.daorv.R;
import com.example.torridas.daorv.city.model.DaoSession;
import com.example.torridas.daorv.country.adapter.CountryAdapter;
import com.example.torridas.daorv.country.model.Country;
import com.example.torridas.daorv.country.model.CountryDao;
import com.example.torridas.daorv.utility.Connections;

import java.util.List;

/**
 * Created by Torridas on 10-Jul-17.
 */

public class CountryFragment extends Fragment {

    private DaoSession daoSession;
    private CountryDao countryDao;
    private List<Country> countriesList;
    private CountryAdapter countryAdapter;
    private RecyclerView recyclerView;
    private OnCountrySelected onCountrySelected;

    public interface OnCountrySelected{
        void onCountrySelected(Long id);
    }

    public static CountryFragment newInstance() {
        return new CountryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_country, container, false);

        final Activity activity = getActivity();

        daoSession = (Connections.getInstance()).getDaoSession();
        countryDao = daoSession.getCountryDao();
        countriesList = countryDao.queryBuilder().list();

        countryAdapter = new CountryAdapter(activity, countriesList, onCountrySelected );
        recyclerView = (RecyclerView) view.findViewById(R.id.listaMea);
        recyclerView.setLayoutManager(new GridLayoutManager(activity,2));
        recyclerView.setAdapter(countryAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if( context instanceof OnCountrySelected ){
            onCountrySelected = (OnCountrySelected)context;
        }
        else{
            Log.d("PROBLEMA", "NU E IMPLEMENTATA METODA!!");
        }
    }

}
