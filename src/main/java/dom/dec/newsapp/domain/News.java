package dom.dec.newsapp.domain;

public class News {

  private long newsId;
  private String title;
  private String url;
  private String summary;

  public News(long newsId, String title, String url, String summary) {
    this.newsId = newsId;
    this.title = title;
    this.url = url;
    this.summary = summary;
  }

  public long getNewsId() {
    return newsId;
  }

  public void setNewsId(long newsId) {
    this.newsId = newsId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

}
