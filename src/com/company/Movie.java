package com.company;

public class Movie {
    private String title;
    private String genre;

    Movie(){
        AppManager.getInstance().getDataManager().setMovie(this);
    }

    // get 메소드
    public String  getTitle(){
        return title;
    }
    public String  getGenre(){
        return genre;
    }

    // set 메소드
    public void setTitle(String title){
        this.title = title;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
}
