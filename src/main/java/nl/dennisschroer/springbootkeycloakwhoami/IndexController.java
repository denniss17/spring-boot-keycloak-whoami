package nl.dennisschroer.springbootkeycloakwhoami;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author Dennis Schroer
 * @since 30 Jan 2021
 */
@Controller
public class IndexController {
    @GetMapping("/")
    @ResponseBody
    public Object index(Principal principal){
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;

        AccessToken token = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();

        return token;
    }
}
