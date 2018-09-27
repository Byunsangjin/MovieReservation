package com.company;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class MovieDAO {
    DAOManager daoManager = AppManager.getInstance().getDAOManager();

    ResultSet rs;

    public MovieDAO(){
        AppManager.getInstance().getDAOManager().setMovieDAO(this);
    }

    // DB에 저장되어 있는 모든 영화를 리턴해주는 메소드
    public ArrayList<Movie> getAll(){
        daoManager.connectDB();
        String sql = "SELECT * FROM movie";

        // 모든 영화를 전달하는 ArrayList
        ArrayList<Movie> movies = new ArrayList<Movie>();

        // 모든 DB를 뒤져 Movies에 저장
        try {
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            rs = daoManager.pstmt.executeQuery();
            while(rs.next()){
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movies.add(movie);
            }
            daoManager.closeDB();
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        //모든 영화 ArrayList 리턴
        return movies;
    }

    // 특정 영화를 제목을 통해 리턴해주는 메소드
    Movie getMovie(String title){
        daoManager.connectDB();

        String sql = "SELECT * FROM movie WHRER title = ?";
        Movie movie = new Movie();

        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, title);
            daoManager.pstmt.executeQuery();
            rs.next();

            movie.setTitle(rs.getString("title"));
            movie.setGenre(rs.getString("genre"));

            rs.close();
            daoManager.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }

        // title이 일치하는 movie객체 리턴
        return movie;
    }

    // 장르에 맞는 영화 하나를 리턴해주는 메소드
    Movie getRecomendMovie(String genre){
        daoManager.connectDB();
        ArrayList<Movie> movies = new ArrayList<Movie>();

        String sql = "SELECT * FROM movie WHERE genre = ?";

        // 받아온 genre의 영화 ArrayList에 담기
        try{
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, genre);
            rs = daoManager.pstmt.executeQuery();
            while (rs.next()){
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movies.add(movie);
            }
            rs.close();
            daoManager.closeDB();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // ArrayList에 있는 영화 중 랜덤으로 하나 뽑아서 리턴
        int random = (int)(Math.random()*movies.size())+1;
        return movies.get(random-1);
    }

    // 특정 장르에 맞는 영화 전부 리턴
    public ArrayList<Movie> getGenreAll(String genre){
        daoManager.connectDB();
        String sql = "SELECT * FROM movie WHERE genre = ?";

        // 모든 영화를 전달하는 ArrayList
        ArrayList<Movie> movies = new ArrayList<Movie>();

        // 모든 DB를 뒤져 Movies에 저장
        try {
            daoManager.pstmt = daoManager.conn.prepareStatement(sql);
            daoManager.pstmt.setString(1, genre);
            rs = daoManager.pstmt.executeQuery();
            while(rs.next()){
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setGenre(rs.getString("genre"));
                movies.add(movie);
            }
            daoManager.closeDB();
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        //모든 영화 ArrayList 리턴
        return movies;
    }


}
