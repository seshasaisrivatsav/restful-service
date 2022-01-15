package com.sesha.restfulservice.controller.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sesha.restfulservice.dto.Welcome;
import com.sesha.restfulservice.dto.movies.Movie;
import com.sesha.restfulservice.dto.movies.NowPlaying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
public class MockAPIController {

    private static final Logger log = LoggerFactory.getLogger(MockAPIController.class);

    private static final String API_KEY =  "4f2d1f1b0b040f028fe607fa054b6762";
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    // https://api.themoviedb.org/3/movie/now_playing?api_key=4f2d1f1b0b040f028fe607fa054b6762
    private static final String GET_NOW_PLAYING_URL = BASE_URL + "/movie/now_playing?api_key=" + API_KEY;
    /*
        Response Object:
        {
            dates: {
                maximum: "yyyy-mm-dd",
                minimum: "yyyy-mm-dd"
            },
            results: [
                {
                    adult: boolean,
                    backdrop_path: String,
                    genre_ids: [ int ],
                    id: int,
                    original_language: String,
                    original_title: String,
                    overview: String,
                    popularity: long / decimal,
                    poster_path: String,
                    release_date: "yyyy-mm-dd",
                    title: String,
                    video: boolean,
                    vote_average: decimal,
                    vote_count: decimal
                }
            ]
        }
     */

    @GetMapping("/getNowPlaying")
    public static String getNowPlaying() {
        RestTemplate restTemplate = new RestTemplate();
        NowPlaying res = restTemplate.getForObject(GET_NOW_PLAYING_URL, NowPlaying.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            // @See https://www.baeldung.com/jackson-serialize-dates
            // for date format
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
            mapper.setDateFormat(df);
            return mapper.writeValueAsString(res);
        } catch (JsonProcessingException e) {
            log.error("Unable to parse res withe exception " + e);
        }
        return "404";
    }

    @PostMapping("/responseBodyTest")
    public Movie postMovie(
            @RequestBody Movie movie, HttpServletResponse response) {
        return movie;
    }

    @PostMapping("/postToService")
    public Movie postToService(@RequestBody Movie movie, HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String postMovieUrl = "http://localhost:8081/responseBodyTest";

        return restTemplate.postForObject(postMovieUrl, movie, Movie.class);
    }

    @PostMapping("/postExample")
    public static String postExample(HttpServletRequest request, HttpServletResponse response,
                                   @RequestBody Map<String, Integer> body) {
        /*
            {"number1": 12, "number2": 15 }
         */
        int number1 = body.get("number1");
        int number2 = body.get("number2");
        return "you've entered numbers: " + number1 + " " + number2;
    }

}
