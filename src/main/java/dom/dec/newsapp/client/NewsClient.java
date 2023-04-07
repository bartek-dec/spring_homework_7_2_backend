package dom.dec.newsapp.client;

import dom.dec.newsapp.api.model.Response;
import dom.dec.newsapp.api.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Controller
public class NewsClient {
    private RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String baseUrl;

    private LocalDate dayBefore = LocalDate.now().minusDays(1);

    public NewsClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<Result> getNews() {
        String url = baseUrl + dayBefore;

        Response response = restTemplate.getForObject(url, Response.class);

        return response.getResults();
    }
}
