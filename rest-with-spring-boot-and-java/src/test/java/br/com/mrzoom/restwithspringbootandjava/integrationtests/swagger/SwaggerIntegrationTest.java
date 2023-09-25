package br.com.mrzoom.restwithspringbootandjava.integrationtests.swagger;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;
import br.com.mrzoom.restwithspringbootandjava.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.mrzoom.restwithspringbootandjava.configs.TestConfigs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Test
	void shouldDisplaySwaggerUiPage() {

		var content = given()
				.basePath("/swagger-ui/index.html")
				.port(TestConfigs.SERVER_PORT)
				.when()
					.get()
				.then()
					.statusCode(200)
				.extract()
					.body()
						.asString();

		assertTrue(content.contains("Swagger UI"));
	}

}
