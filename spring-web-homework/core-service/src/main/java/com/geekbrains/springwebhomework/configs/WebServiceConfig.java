package com.geekbrains.springwebhomework.configs;

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
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/springwebhomework/*");
    }

    // http://localhost:8080/ws/groups.wsdl
//    @Bean(name = "categories")
//    public DefaultWsdl11Definition groupsWsdl11Definition(XsdSchema groupsSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("CategoriesPort");
//        wsdl11Definition.setLocationUri("/springwebhomework");
//        wsdl11Definition.setTargetNamespace("http://www.com/geekbrains/springwebhomework/categories");
//        wsdl11Definition.setSchema(groupsSchema);
//        return wsdl11Definition;
//    }

    // http://localhost:8080/ws/students.wsdl
    @Bean(name = "products")
    public DefaultWsdl11Definition productsWsdl11Definition(XsdSchema productsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductsPort");
        wsdl11Definition.setLocationUri("/springwebhomework");
        wsdl11Definition.setTargetNamespace("http://www.com/geekbrains/springwebhomework/products");
        wsdl11Definition.setSchema(productsSchema);
        return wsdl11Definition;
    }


//    @Bean
//    public XsdSchema categoriesSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("categories.xsd"));
//    }

    @Bean
    public XsdSchema productsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("products.xsd"));
    }
}
