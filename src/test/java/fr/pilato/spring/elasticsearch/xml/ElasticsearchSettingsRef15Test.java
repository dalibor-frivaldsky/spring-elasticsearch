package fr.pilato.spring.elasticsearch.xml;

import static org.junit.Assert.assertNotNull;

import org.elasticsearch.client.Client;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test class for feature request #15 : https://github.com/dadoonet/spring-elasticsearch/issues/15
 * @author David
 *
 */
public class ElasticsearchSettingsRef15Test {
	static protected ConfigurableApplicationContext ctx;
	
	@BeforeClass
	static public void setup() {
		ctx = new ClassPathXmlApplicationContext("fr/pilato/spring/elasticsearch/xml/es15/es-settings15-test-context.xml");
	}
	
	@AfterClass
	static public void tearDown() {
		if (ctx != null) {
			ctx.close();
		}
	}
	
	@Test
	public void test_transport_client() {
		Client client = ctx.getBean("esClient", Client.class);
		assertNotNull("Client must not be null...", client);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
	}
}
