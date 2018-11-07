/*
package proyecto.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;


public class DatabaseConfig {
	
	@Bean(name = "bd1")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
	    return DataSourceBuilder.create().build();
	}

	@Bean(name = "bd2")
	@ConfigurationProperties(prefix="spring.secondDatasource")
	public DataSource secondaryDataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "jdbcSlave")
    @Autowired
    public JdbcTemplate slaveJdbcTemplate(@Qualifier("bd2") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }
 
    @Bean(name = "jdbcMaster")
    @Autowired
    public JdbcTemplate masterJdbcTemplate(@Qualifier("bd1") DataSource dsMaster) {
        return new JdbcTemplate(dsMaster);
    }

}
*/
