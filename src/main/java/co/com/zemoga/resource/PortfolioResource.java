package co.com.zemoga.resource;

import co.com.zemoga.entity.Portfolio;
import org.springframework.hateoas.ResourceSupport;

public class PortfolioResource extends ResourceSupport {

    private int idPortfolio;
    private String imageUrl;
    private String title;
    private String description;
    private String twitterUserName;

    public PortfolioResource(){
        super();
    }

    public PortfolioResource(int id, String imageUrl, String title, String description, String twitterUserName) {
        this.idPortfolio = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.twitterUserName = twitterUserName;
    }

    public PortfolioResource(Portfolio entity){
        this.idPortfolio = entity.getId();
        this.imageUrl = entity.getImageUrl();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.twitterUserName = entity.getTwitterUserName();
    }

    public int getIdPortfolio() {
        return idPortfolio;
    }

    public void setIdPortfolio(int idPortfolio) {
        this.idPortfolio = idPortfolio;
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
