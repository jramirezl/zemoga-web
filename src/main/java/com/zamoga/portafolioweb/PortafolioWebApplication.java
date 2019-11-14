package com.zamoga.portafolioweb;


import com.zamoga.portafolioweb.twitter.util.Twitter4jProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication
@EnableConfigurationProperties(Twitter4jProperties.class)
public class PortafolioWebApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PortafolioWebApplication.class, args);
	}
	private static Log log = LogFactory.getLog(PortafolioWebApplication.class);

	@Autowired
	private Twitter4jProperties properties;

	@Bean
	public TwitterFactory twitterFactory(){

		if (this.properties.getOauth().getConsumerKey() == null
				|| this.properties.getOauth().getConsumerSecret() == null
				|| this.properties.getOauth().getAccessToken() == null
				|| this.properties.getOauth().getAccessTokenSecret() == null)
		{
			log.error("Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
			throw new RuntimeException("Twitter4j properties not configured properly. Please check twitter4j.* properties settings in configuration file.");
		}

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(properties.isDebug())
				.setOAuthConsumerKey(properties.getOauth().getConsumerKey())
				.setOAuthConsumerSecret(properties.getOauth().getConsumerSecret())
				.setOAuthAccessToken(properties.getOauth().getAccessToken())
				.setOAuthAccessTokenSecret(properties.getOauth().getAccessTokenSecret());
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf;
	}

	@Bean
	public Twitter twitter(TwitterFactory twitterFactory){
		return twitterFactory.getInstance();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PortafolioWebApplication.class);
	}

}
