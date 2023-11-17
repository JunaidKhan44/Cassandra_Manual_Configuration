/**
 * 
 */
package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

/**
 * junaid.khan
 * 
 *
 */

@Configuration
public class ConssandraConfig<CassandraClusterFactoryBean> extends AbstractCassandraConfiguration {

	@Value("${cassandra.database.keyspace-name}")
	private String keySpace;
	@Value("${cassandra.database.contact-points}")
	private String contactPoints;
	@Value("${cassandra.database.port}")
	private int port;
	@Value("${cassandra.database.username}")
	private String userName;
	@Value("${cassandra.database.password}")
	private String password;

	
	@Bean
	public CassandraClusterFactoryBean cluster() {
		//CassandraClusterFactoryBean cluster= new <>();
		
		
	}
	
	
	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Override
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		CassandraMappingContext context= new CassandraMappingContext();
		context.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(),keySpace));
		return super.cassandraMapping();
	}

	
}
