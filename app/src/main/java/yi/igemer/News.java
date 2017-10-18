package yi.igemer;

/**
 * Created by yimo on 2017-10-17.
 */

public class News {
    private int newsID;
    private String title;
    private String createdAt;
    private String logo;
    private String description;

    public News(){

    }

    public News(int newsID,String title,String createdAt,String logo){
        this.newsID = newsID;
        this.title=title;
        this.createdAt=createdAt;
        this.logo = logo;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription(){return description;}
    public void setDescription(String description) {this.description = description;}
}
