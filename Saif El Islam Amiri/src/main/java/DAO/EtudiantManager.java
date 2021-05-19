package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Etudiant;

public class EtudiantManager {
	public int inscription(String nom,String prenom,String log,String pass) {
		DBinteraction.connect();
		int nb = DBinteraction.Maj("insert into etudiant(nom,prenom,log,password) values ( '"+nom+"' , '"+prenom+"' , '"+log+"' , '"+pass+"' )");
		DBinteraction.disconnect();
		return nb;
	}
	
	public Etudiant authentification(String log,String pass) {
		Etudiant e = null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from etudiant where log = '"+log+"' and password = '"+pass+"'");
		try {
			if(rs.next()) {
				e = new Etudiant();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getString(3));
				e.setLog(rs.getString(4));
				e.setPass(rs.getString(5));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DBinteraction.disconnect();
		return e;
	}
}
