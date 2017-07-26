package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ApplicationConfig extends WsConfigurerAdapter {

	private static final String SCHEMA_LOCATION = "xsd/countries.xsd";
	private static final String PORTTYPE_NAME = "Cities";

	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(false);
		return new ServletRegistrationBean(servlet, "/services/*");
	}

	@Bean(name = "cities")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema getSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName(PORTTYPE_NAME);
		wsdl11Definition.setLocationUri("/cities");
		wsdl11Definition.setTargetNamespace("http://giorgoch.com/playground/schema/cities/");
		wsdl11Definition.setSchema(getSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema getSchema() {
		return new SimpleXsdSchema(new ClassPathResource(SCHEMA_LOCATION));
	}

}
