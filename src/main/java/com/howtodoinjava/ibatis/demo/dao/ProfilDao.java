package com.howtodoinjava.ibatis.demo.dao;

import com.howtodoinjava.ibatis.demo.dto.ProfilTEO;
import com.ibatis.sqlmap.client.SqlMapClient;

public interface ProfilDao {
	public ProfilTEO addProfil(ProfilTEO user, SqlMapClient sqlmapClient);

	public ProfilTEO getProfilById(Integer id, SqlMapClient sqlmapClient);

	public void deleteProfilById(Integer id, SqlMapClient sqlmapClient);
}
