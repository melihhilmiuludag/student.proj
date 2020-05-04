package tr.com.melihhilmiuludag.student.proj;

import com.google.common.collect.ImmutableMap;
import com.sun.faces.config.ConfigureListener;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.webapp.filter.FileUploadFilter;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

//@SpringBootApplication(scanBasePackages = "tr.com.melihhilmiuludag.student.proj.*")
@SpringBootApplication
@Configuration
@ComponentScan("tr.com.melihhilmiuludag.student.proj.*")
@EnableJpaRepositories("tr.com.melihhilmiuludag.student.proj.repository")
@EntityScan("tr.com.melihhilmiuludag.student.proj.domain.entities")
@EnableTransactionManagement
@EnableAsync
@Slf4j
public class StudentCrudWithPrimefacesUiApplication implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudWithPrimefacesUiApplication.class, args);
	}

	@Bean
	public static CustomScopeConfigurer viewScope() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.setScopes(new ImmutableMap.Builder<String, Object>().put("view-screen", new ViewScope()).build());
		return configurer;
	}

	//JSF Config
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletServletRegistrationBean() {
		//servlet
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean(new FacesServlet(), "*.xhtml");
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);
		return registration;
	}



	@Bean
	public DataSource dataSource() {
		//jdbc:hsqldb:mem:testdb
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("sql/v1.1.1/initializer.sql").addScript("sql/v1.1.1/dml/insert.sql")
				.build();

		log.debug("insert script");
		return db;
	}


	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

//	@Bean
//	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
//		ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
//				new FacesServlet(), "*.xhtml");
//		servletRegistrationBean.setLoadOnStartup(1);
//		return servletRegistrationBean;
//	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		//contextParams
		// http://stackoverflow.com/a/25509937/1199132 for look detail,
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.THEME", "blitzer");
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
//		servletContext.setInitParameter("primefaces.UPLOADER","commons");
		servletContext.setInitParameter("primefaces.UPLOADER","auto");
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX", ".xhtml");
		servletContext.setInitParameter("javax.faces.FACELETS_REFRESH_PERIOD", "1");//0?
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING_METHOD", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "server");
		servletContext.setInitParameter("primefaces.TRANSFORM_METADA", Boolean.TRUE.toString());
//		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
		servletContext.setInitParameter("facelets.DEVELOPMENT", Boolean.TRUE.toString());

	}
}
