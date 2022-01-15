package com.sesha.restfulservice.dto.movies;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    @JsonProperty("name")
    String name;

    @JsonProperty("description")
    String description;



    public String getDescription() {
        return description;
    }

    public Movie(){}
    public Movie(String movie, String description) {
        this.name = movie;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
