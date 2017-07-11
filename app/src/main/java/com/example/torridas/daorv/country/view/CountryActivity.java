package com.example.torridas.daorv.country.view;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.torridas.daorv.R;
import com.example.torridas.daorv.city.model.City;
import com.example.torridas.daorv.city.model.CityDao;
import com.example.torridas.daorv.city.model.DaoSession;
import com.example.torridas.daorv.city.view.CityFragment;
import com.example.torridas.daorv.country.adapter.CountryAdapter;
import com.example.torridas.daorv.country.model.Country;
import com.example.torridas.daorv.country.model.CountryDao;
import com.example.torridas.daorv.utility.Connections;

import java.util.List;

public class CountryActivity extends AppCompatActivity
implements CountryFragment.OnCountrySelected {

    //views
    private Toolbar bara;
    private Typeface font1;
    private TextView t1;
    private ListView zonaLista;
    private Connections connections;
    private DaoSession daoSession;
    private CountryDao countryDao;
    private CityDao cityDao;

    // database

    //vars
    private List<Country> listaTari;
    private CountryAdapter adaptorT;
    private Intent intentie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        t1 = (TextView)findViewById(R.id.titlu);
        font1 = Typeface.createFromAsset(getAssets(),"Autumn Leaves.ttf");
        t1.setTypeface(font1);

        bara = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(bara);
        getSupportActionBar().setTitle("");

        connections = Connections.getInstance(getApplicationContext());
        daoSession = connections.getDaoSession();

        countryDao = daoSession.getCountryDao();
        cityDao = daoSession.getCityDao();

        putSomeCountries();
        putSomeCities();

       if( savedInstanceState == null ) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.real_root, CountryFragment.newInstance(), "Countries List")
                    .commit();
        }

    }

    private void putSomeCountries(){

        for( int i = 0; i < 5; i++ ){
            Country country = new Country();
            country.setName("random country name " + i);
            countryDao.insertOrReplace(country);
        }
    }

    private void putSomeCities(){

        for( int i = 0; i < 3; i++ ){
            City city =  new City();
            city.setName("random city name " + i);
            city.setCountryOfProvenience(new Long(1));
            cityDao.insertOrReplace(city);
        }

        for( int i = 0; i < 2; i++ ){
            City city =  new City();
            city.setName("random city name " + i + 7);
            city.setCountryOfProvenience(new Long(2));
            cityDao.insertOrReplace(city);
        }
    }

    @Override
    public void onCountrySelected(Long id) {
        final CityFragment cityFragment =  CityFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.real_root, cityFragment, "Lista Orase")
                .addToBackStack(null).commit();
    }
}
