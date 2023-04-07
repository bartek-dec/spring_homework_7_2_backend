package dom.dec.newsapp.repository;

import dom.dec.newsapp.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsDaoImpl implements NewsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findAll() {
        String sql = "SELECT * FROM news ORDER BY news_id";
        List<News> news = new ArrayList<>();

        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        result.stream().forEach(element -> news.add(new News(
                Long.parseLong(String.valueOf(element.get("news_id"))),
                String.valueOf(element.get("title")),
                String.valueOf(element.get("url")),
                String.valueOf(element.get("summary"))
        )));

        return news;
    }

    @Override
    public void createNews(String title, String url, String summary) {
        String sql = "INSERT INTO news(title, url, summary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, title, url, summary);
    }

    @Override
    public void updateNews(News newNews) {
        String sql = "UPDATE news SET title=?, summary=? WHERE news_id=?";
        jdbcTemplate.update(sql, newNews.getTitle(), newNews.getSummary(), newNews.getNewsId());
    }

    @Override
    public void deleteNews(long id) {
        String sql = "DELETE FROM news WHERE news_id=?";
        jdbcTemplate.update(sql, id);
    }
}
