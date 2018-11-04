/*package proyecto.back.config;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	public LoginFilter(String url,AuthenticationManager authManager) {
		
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	 @Override
	    public Authentication attemptAuthentication(
	            HttpServletRequest req, HttpServletResponse res)
	            throws AuthenticationException, IOException, ServletException {

	        // obtenemos el body de la peticion que asumimos viene en formato JSON
	        InputStream body = req.getInputStream();

	        // Asumimos que el body tendrá el siguiente JSON  {"username":"ask", "password":"123"}
	        // Realizamos un mapeo a nuestra clase User para tener ahi los datos
	        Usy user = new ObjectMapper().readValue(body, User.class);

	        // Finalmente autenticamos
	        // Spring comparará el user/password recibidos
	        // contra el que definimos en la clase SecurityConfig
	        return getAuthenticationManager().authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        user.getUsername(),
	                        user.getPassword(),
	                        Collections.emptyList()
	                )
	        );
	    }

	
	
	
}
*/
