package dom.dec.newsapp.repository;

import dom.dec.newsapp.domain.News;

import java.util.List;

public interface NewsDao {

    List<News> findAll();

    void createNews(String title, String url, String summary);

    void updateNews(News newNews);

    void deleteNews(long id);
}
