package com.howtodoinjava.ibatis.demo.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.howtodoinjava.ibatis.demo.builder.ProfilBuilder;
import com.howtodoinjava.ibatis.demo.builder.UserBuilder;
import com.howtodoinjava.ibatis.demo.dao.ProfilDao;
import com.howtodoinjava.ibatis.demo.dao.ProfilDaoIbatis;
import com.howtodoinjava.ibatis.demo.dao.UserDao;
import com.howtodoinjava.ibatis.demo.dao.UserDaoIbatis;
import com.howtodoinjava.ibatis.demo.dto.ProfilTEO;
import com.howtodoinjava.ibatis.demo.dto.UserTEO;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * Hello world!
 * 
 */
public class UserTest {

	private UserDao userDao = new UserDaoIbatis();
	private ProfilDao profilDao = new ProfilDaoIbatis();

	// Create the SQLMapClient
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("sql-maps-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
	private ProfilTEO profil;
	private UserTEO user;

	@Before
	public void befor() {
		profil = ProfilBuilder.createProfil();
		profilDao.addProfil(profil, sqlmapClient);
		user = UserBuilder.createUser(profil);
		userDao.addUser(user, sqlmapClient);
	}

	@Test
	public void userTest() throws IOException {

		// Fetch the user detail
		UserTEO createdUser = userDao.getUserByName("Demo User", sqlmapClient);
		assertEquals("demo-user@howtodoinjava.com", createdUser.getEmail());

	}

	@After
	public void after() {
		userDao.deleteUserById(user.getId(), sqlmapClient);
		profilDao.deleteProfilById(profil.getId(), sqlmapClient);
	}

}
