package com.howtodoinjava.ibatis.demo.test;

import static org.junit.Assert.assertEquals;

import java.io.Reader;

import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.howtodoinjava.ibatis.demo.dao.UserDao;
import com.howtodoinjava.ibatis.demo.dao.UserDaoIbatis;
import com.howtodoinjava.ibatis.demo.dto.UserTEO;
import com.ibatis.common.resources.Resources;

/**
 * Hello world!
 * 
 */
public class UserDAOTest extends AbstractDaoTest {

	private UserDao userDao = new UserDaoIbatis();
	
	private String FILE_DATA_PATH ="data.xml"; 


	@Before
	public void befor() throws Exception {
		Reader resourceAsReader = Resources.getResourceAsReader(FILE_DATA_PATH);
		FlatXmlDataSet dataSet = new FlatXmlDataSet(resourceAsReader);
		DatabaseOperation.INSERT.execute(con, dataSet);
	}

	@Test
	public void userTest() throws Exception {
		// Fetch the user detail
		UserTEO createdUser = userDao.getUserByName("Demo User", sqlmapClient);
		assertEquals("demo-user@howtodoinjava.com", createdUser.getEmail());
	}

	@After
	public void after() throws Exception {
		Reader resourceAsReader = Resources.getResourceAsReader(FILE_DATA_PATH);
		FlatXmlDataSet dataSet = new FlatXmlDataSet(resourceAsReader);
		DatabaseOperation.DELETE.execute(con, dataSet);
		con.close();
	}

}
