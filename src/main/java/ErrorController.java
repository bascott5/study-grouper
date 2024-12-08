import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ErrorController {
    @GetMapping("/error")
    public String error(Model model) {
        try {
            String url = "https://api.chucknorris.io/jokes/random?category=history";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);

            model.addAttribute("quote", root.get("value").asText());

            return "error";
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestController.class.getName()).log(Level.SEVERE,
                    null, ex);

            model.addAttribute("quote", "Chuck Norris broke the joke.");

            return "error";
        }
    }
}
