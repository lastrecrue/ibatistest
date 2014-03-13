package com.howtodoinjava.ibatis.demo.builder;

import com.howtodoinjava.ibatis.demo.dto.ProfilTEO;

public class ProfilBuilder {
	public static ProfilTEO createProfil() {
		ProfilTEO profil = new ProfilTEO();
		profil.setName("Demo Profil");
		profil.setPassword("password");
		profil.setEmail("demo-profil@howtodoinjava.com");
		profil.setStatus(1);
		return profil;
	}
}
