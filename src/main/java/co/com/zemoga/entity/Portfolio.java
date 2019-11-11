package co.com.zemoga.entity;

import javax.persistence.*;

@Entity
@Table(name="portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idportfolio")
    private int id;

    @Column(name="imageURL")
    private String imageUrl;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="twitterUserName")
    private String twitterUserName;

    public Portfolio(){

    }

    public Portfolio(Portfolio portfolio, int id) {
        this.id = id;
        this.id = portfolio.getId();
        this.imageUrl = portfolio.getImageUrl();
        this.description = portfolio.getDescription();
        this.title = portfolio.getTitle();
        this.twitterUserName = portfolio.getTwitterUserName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }
}
