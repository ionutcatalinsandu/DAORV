package com.example.torridas.daorv.country.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Torridas on 10-Jul-17.
 */

@Entity
public class Country {
    @Id(autoincrement = true )
    private Long id;

    private String name;

    @Generated(hash = 1662620089)
    public Country(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 668024697)
    public Country() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
