package Pojo;

public class Video {
    private int idvideos;
    private String title;//视频标题
    private String cover;//视频封面
    private String src;//视频来源

    public Video(int idvideos, String title, String cover, String src) {
        this.idvideos = idvideos;
        this.title = title;
        this.cover = cover;
        this.src = src;
    }

    public Video() {
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "Video{" +
                "idvideos=" + idvideos +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
