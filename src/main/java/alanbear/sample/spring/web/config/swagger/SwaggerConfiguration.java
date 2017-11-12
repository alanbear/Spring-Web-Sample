package alanbear.sample.spring.web.config.swagger;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket View() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("view")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(ViewPaths())
                .build();
    }

	@Bean
	public Docket ApiView() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(APIPaths())
				.build();
	}

	@Bean
	public Docket TestView() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("test")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(TestPaths())
				.build();
	}

    private Predicate<String> ViewPaths() {
        return regex("^((?!/v[0-9]\\.?[0-9]?/).*)");
    }

    private Predicate<String> APIPaths() {
        return regex("/v[0-9]\\.?[0-9]?/.*");
    }

    private Predicate<String> TestPaths() {
        return regex("/test/.*");
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Web Sample Doc")
				.description("swagger demo")
				.contact(new Contact("alanbear", "https://www.google.tw/", "XXX@gmail.com"))
				.termsOfServiceUrl("Demo Service")
				.version("1.0")
				.build();
	}		
	
}
