package com.howtodoinjava.ibatis.demo.dao;

import com.howtodoinjava.ibatis.demo.dto.ProfilTEO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ProfilDaoIbatis implements ProfilDao {
	public ProfilTEO addProfil(ProfilTEO profil, SqlMapClient sqlmapClient) {
		try {
			Integer id = (Integer) sqlmapClient.queryForObject("profil.getMaxId");
			id = id == null ? 1 : id + 1;
			profil.setId(id);
			profil.setStatus(1);
			sqlmapClient.insert("profil.addProfil", profil);
			profil = getProfilById(id, sqlmapClient);
			return profil;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProfilTEO getProfilById(Integer id, SqlMapClient sqlmapClient) {
		try {
			ProfilTEO profil = (ProfilTEO) sqlmapClient.queryForObject("profil.getProfilById", id);
			return profil;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteProfilById(Integer id, SqlMapClient sqlmapClient) {
		try {
			sqlmapClient.delete("profil.deleteProfilById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}