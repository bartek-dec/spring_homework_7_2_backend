package dom.dec.newsapp.api;

import dom.dec.newsapp.client.NewsClient;
import dom.dec.newsapp.domain.News;
import dom.dec.newsapp.repository.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsApi {

    private NewsDao newsDao;

    @Autowired
    public NewsApi(NewsClient client, NewsDao newsDao) {
        this.newsDao = newsDao;

        client.getNews()
                .forEach(element -> newsDao.createNews(element.getTitle(), element.getUrl(), element.getSummary()));
    }

    @GetMapping
    public ResponseEntity<List<News>> getNews() {
        return new ResponseEntity<>(newsDao.findAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<News> updateNews(@RequestBody News newNews) {
        newsDao.updateNews(newNews);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<News> deleteNews(@PathVariable Long id) {
        newsDao.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
