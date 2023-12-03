package Pojo;

public class Resource {
    private int id;
    private String name;
    private String src;//链接
    private String resource_type;

    public Resource(){
    }
    public Resource(int id, String name, String src, String resource_type) {
        this.id = id;
        this.name = name;
        this.src = src;
        this.resource_type = resource_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getResource_type() {
        return resource_type;
    }

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }
}
