package Pojo;

public class Notice {
    private int id;
    private String title;
    private String content;
    private String createTime;

    public Notice() {
    }

    public Notice(String title, String content, String createTime) {
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Notice(int id, String title, String content, String createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
