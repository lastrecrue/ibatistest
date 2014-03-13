package com.howtodoinjava.ibatis.demo.test;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public abstract class AbstractDaoTest {
	private static final String DATABASE_PASSWORD = "";

	private static final String DATABASE_USER = "root";

	private static final String IBATIS_CONFIG = "sql-maps-config.xml";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/demoDB";

	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";

	// Create the SQLMapClient
	private static Reader reader;

	private static Connection conn;
	protected static IDatabaseConnection con;
	static {
		try {
			reader = Resources.getResourceAsReader(IBATIS_CONFIG);
			Class.forName(DATABASE_DRIVER);
			conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			con = new DatabaseConnection(conn); // Create DBUnit Database connection

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient(reader);

}
