package com.sesha.restfulservice.dto.movies;

import java.util.List;

public class NowPlaying {
    public Dates getDates() {
        return dates;
    }

    public List<Result> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    Dates dates;
    List<Result> results;
    int total_pages;
    int total_results;

    @Override
    public String toString() {
        return "NowPlaying{" +
                "dates=" + dates +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
