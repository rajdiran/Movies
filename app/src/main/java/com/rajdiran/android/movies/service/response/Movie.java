package com.rajdiran.android.movies.service.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/* Sample data

"Title": "Avengers:Age of Ultron ",
"Year": "2015 ",
"Rated": "PG-13 ",
"Released": "01 May 2015 ",
"Runtime": "141 min ",
"Genre": "Action, Adventure, Sci-Fi ",
"Director": "Joss Whedon ",
"Writer": "Joss Whedon, Stan Lee (based on the Marvel comics by), Jack Kirby (based on the Marvel comics by), Joe Simon (character created by: Captain America), Jack Kirby (character created by: Captain America), Jim Starlin (character created by: Thanos) ",
"Actors": "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans ",
"Plot": "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan. ",
"Language": "English, Korean ",
"Country": "USA ",
"Awards": "7 wins & 45 nominations."*/

public class Movie implements Serializable {

    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Released")
    private String releasedOn;

    @SerializedName("Runtime")
    private String runTime;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Director")
    private String director;

    @SerializedName("Writer")
    private String writer;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Plot")
    private String plot;

    @SerializedName("Language")
    private String language;

    @SerializedName("Country")
    private String country;

    @SerializedName("Awards")
    private String awards;

    @SerializedName(value="posterUrl", alternate={"Poster", "Poster "})
    private String posterUrl;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleasedOn() {
        return releasedOn;
    }

    public String getRunTime() {
        return runTime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

}
