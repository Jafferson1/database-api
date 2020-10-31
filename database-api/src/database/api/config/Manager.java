package database.api.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Manager {

	static Logger logger = LoggerFactory.getLogger(Manager.class);
	private static HikariDataSource ds;

    static {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/{your_database}?useSSL=false");
        config.setUsername("{your_user}");
        config.setPassword("{your_password}");  
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        config.setMaximumPoolSize(10);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }
}
