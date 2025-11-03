public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration; // in minutes

    public Movie(int id, String title, String genere, int duration){
        this.id = id;
        this.title = title;
        this.genre = genere;
        this.duration = duration;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public int getDuration(){
        return duration;
    }

    @Override
    public String toString(){
        return id + ". " + title + " (" + genre + ", " + duration + "min)";
    }
}
