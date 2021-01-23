package com.github.samuelpacezar.citiesapi.cities.entity;

import com.github.samuelpacezar.citiesapi.states.entity.State;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity(name = "City")
@Table(name = "cidade")
@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State state;

    @Column(name = "ibge")
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "cod_tom")
    private Integer cod_tom;

    public City() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public State getState() {
        return state;
    }

    public Integer getIbge() {
        return ibge;
    }

    public Point getLocation() {
        return location;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Integer getCod_tom() {
        return cod_tom;
    }
}
