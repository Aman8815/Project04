
package com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * JDBC DataSource is a Data Connection Pool.
 * 
 * @author Aman Yashona
 *
 */
public final class JDBCDataSource {

	/**
	 * JDBC Database connection pool ( DCP )
	 */

	private JDBCDataSource() {
	}

	private static JDBCDataSource datasource;

	private ComboPooledDataSource cpds = null;

	/**
	 * Create instance of Connection Pool
	 *
	 * @return
	 */
	public static JDBCDataSource getInstance() {
		if (datasource == null) {

			ResourceBundle rb = ResourceBundle.getBundle("com.rays.System");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();
			try {
				datasource.cpds.setDriverClass(rb.getString("driver"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("username"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setInitialPoolSize(new Integer((String) rb.getString("initialPoolSize")));
			datasource.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
			datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
			datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));
		}
		return datasource;
	}

	/**
	 * Gets the connection from ComboPooledDataSource
	 *
	 * @return connection
	 */
	public static Connection getConnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	/**
	 * Closes a connection
	 *
	 * @param connection
	 * @throws Exception
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
			}
		}
	}

	public static void trnRollback(Connection connection) throws Exception{
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				throw new Exception();
			}
		}
	}
}

