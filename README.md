# Sportplatform
1.It is a Springboot project demo and there are still some models to complete.Front-end and backe-end are seperated. 2.Regarding cross-domain request issues, I use global confiration to handle @Configuration public class WebConfig extends WebMvcConfigurerAdapter {

@Override
public void addCorsMappings(CorsRegistry registry) {
    /*
    1.Access path
    2.Request sources
    3.Methods
    4.Credentials
    5.Maximum response time
     */
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:8083", "null")
            .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE")
            .allowCredentials(true)
            .allowedHeaders("*")
            .maxAge(3600);
}
}
