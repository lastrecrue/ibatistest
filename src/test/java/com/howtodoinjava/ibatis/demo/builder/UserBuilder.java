package com.howtodoinjava.ibatis.demo.builder;

import com.howtodoinjava.ibatis.demo.dto.ProfilTEO;
import com.howtodoinjava.ibatis.demo.dto.UserTEO;

public class UserBuilder {
	public static UserTEO createUser(ProfilTEO profil) {
		UserTEO user = new UserTEO();
		user.setName("Demo User");
		user.setPassword("password");
		user.setEmail("demo-user@howtodoinjava.com");
		user.setIdProfil(profil.getId());
		user.setStatus(1);
		return user;
	}
}
