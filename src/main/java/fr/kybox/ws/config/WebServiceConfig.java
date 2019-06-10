package fr.kybox.ws.config;

import org.apache.ws.commons.schema.resolver.DefaultURIResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.soap.security.wss4j2.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    private final SecurityConfig securityConfig;

    public WebServiceConfig(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext appContext) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(appContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/*");
    }

    @Bean
    public XsdSchemaCollection xsdSchemaCollection() {
        CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection();
        collection.setXsds(
                new ClassPathResource("xsd/model.xsd"),
                new ClassPathResource("xsd/msg.xsd"));
        collection.setUriResolver(new DefaultURIResolver());
        collection.setInline(true);
        return collection;
    }

    @Bean(name = "contract")
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("Port");
        wsdl11Definition.setLocationUri("/");
        wsdl11Definition.setTargetNamespace("http://kybox.fr");
        wsdl11Definition.setSchemaCollection(xsdSchemaCollection());
        wsdl11Definition.setRequestSuffix("Req");
        wsdl11Definition.setResponseSuffix("Resp");
        return wsdl11Definition;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {

        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        validatingInterceptor.setXsdSchemaCollection(xsdSchemaCollection());
        validatingInterceptor.setAddValidationErrorDetail(true);

        interceptors.add(validatingInterceptor);
        interceptors.add(securityInterceptor());
    }

    @Bean
    public Wss4jSecurityInterceptor securityInterceptor() {

        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setValidationActions("UsernameToken");
        securityInterceptor.setValidationCallbackHandler(securityCallbackHandler());
        securityInterceptor.setSecurementUsernameTokenNonce(true);
        return securityInterceptor;
    }

    @Bean
    public SimplePasswordValidationCallbackHandler securityCallbackHandler() {

        SimplePasswordValidationCallbackHandler callbackHandler = new SimplePasswordValidationCallbackHandler();
        callbackHandler.setUsersMap(securityConfig.getCredentials());
        return callbackHandler;
    }
}
