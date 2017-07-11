package com.example.torridas.daorv.city.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.torridas.daorv.R;
import com.example.torridas.daorv.city.adapter.CityAdapter;
import com.example.torridas.daorv.city.model.City;
import com.example.torridas.daorv.city.model.CityDao;
import com.example.torridas.daorv.city.model.DaoSession;
import com.example.torridas.daorv.country.adapter.CountryAdapter;
import com.example.torridas.daorv.country.model.Country;
import com.example.torridas.daorv.country.model.CountryDao;
import com.example.torridas.daorv.utility.Connections;
import com.example.torridas.daorv.utility.Strings;

import java.util.List;

/**
 * Created by Torridas on 10-Jul-17.
 */

public class CityFragment extends Fragment {
    public static CityFragment newInstance(Long x){
        Bundle args = new Bundle();
        args.putLong(Strings.INTENT_ID, x );
        final CityFragment cityFragment = new CityFragment();
        cityFragment.setArguments(args);
        return cityFragment;
    }

    private DaoSession daoSession;
    private CityDao cityDao;
    private List<City> citiesList;
    private CityAdapter cityAdapter;
    private RecyclerView recyclerView;
    private Long x;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false );

        final Activity activity = getActivity();

        recyclerView = (RecyclerView)view.findViewById(R.id.listaMea2);
        daoSession = Connections.getInstance().getDaoSession();
        cityDao = daoSession.getCityDao();

        final Bundle bundle = getArguments();
        x = bundle.getLong(Strings.INTENT_ID);

        citiesList = cityDao.queryBuilder().where(CityDao.Properties.CountryOfProvenience.eq(x)).list();
        cityAdapter = new CityAdapter(activity, citiesList);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 3));
        recyclerView.setAdapter(cityAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
