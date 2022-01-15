package com.sesha.restfulservice.dto.movies;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {
    public Date getMinimum() {
        return minimum;
    }

    public Date getMaximum() {
        return maximum;
    }

    Date minimum;
    Date maximum;

    @Override
    public String toString() {
        return "Dates{" +
                "minimum='" + new SimpleDateFormat("yyyy-MM-dd").format(minimum) + '\'' +
                ", maximum='" + maximum + '\'' +
                '}';
    }
}
