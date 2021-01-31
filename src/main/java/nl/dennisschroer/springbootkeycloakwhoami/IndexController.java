package nl.dennisschroer.springbootkeycloakwhoami;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dennis Schroer
 * @since 30 Jan 2021
 */
@Controller
public class IndexController {

    @Value("${keycloak.resource}")
    private String resource;

    @GetMapping("/")
    public ModelAndView index(Principal principal) throws JsonProcessingException {
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken token = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> model = new HashMap<>();
        model.put("authorities", keycloakAuthenticationToken.getAuthorities());
        model.put("token", token);
        model.put("tokenJson", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(token));
        model.put("realmRoles", new ArrayList<>(token.getRealmAccess().getRoles()));
        model.put("clientRoles", new ArrayList<>(token.getResourceAccess().get(resource).getRoles()));

        return new ModelAndView("index", model);
    }
}
