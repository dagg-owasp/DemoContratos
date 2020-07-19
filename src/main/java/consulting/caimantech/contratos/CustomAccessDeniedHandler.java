package consulting.caimantech.contratos;

import java.io.IOException;
import org.owasp.encoder.Encode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler  {
	
	final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,		
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			logger.warn("El Usuario: " + Encode.forJava(auth.getName()) + " Intento acceder la URL protegida: " + Encode.forJava(request.getRequestURI()));
		}

        response.sendRedirect(request.getContextPath() + "/acceso");
	}
	
}
