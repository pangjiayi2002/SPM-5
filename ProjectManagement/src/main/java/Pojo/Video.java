package Pojo;

public class Video {
    private int idvideos;
    private String title;
    private String src;

    public Video() {
    }

    public Video(int idvideos, String title, String src) {
        this.idvideos = idvideos;
        this.title = title;
        this.src = src;
    }

    public int getIdvideos() {
        return idvideos;
    }

    public void setIdvideos(int idvideos) {
        this.idvideos = idvideos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
