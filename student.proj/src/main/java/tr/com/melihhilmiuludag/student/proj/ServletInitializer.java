package tr.com.melihhilmiuludag.student.proj;

import lombok.SneakyThrows;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//@WebServlet("Faces Servlet")
public class ServletInitializer extends SpringBootServletInitializer implements ServletContextAware {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentCrudWithPrimefacesUiApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "0");
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.UPLOADER", "commons");
		servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
		servletContext.setInitParameter("primefaces.THEME", "bootstrap");
	}

	@SneakyThrows
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.onStartup(servletContext);
	}
}
