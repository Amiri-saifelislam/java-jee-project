package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categorie;
import model.Livre;

public class CategorieManager {
	public int ajouterCategorie(String cat_name) {
		DBinteraction.connect();
		int nb = DBinteraction.Maj("insert into categorie(nom_cat) values ( '"+cat_name+"')");
		DBinteraction.disconnect();
		return nb;
	}
	public Categorie findCategorieByid(int id) {
		Categorie c = null;
		DBinteraction.connect();
		  ResultSet rs = DBinteraction.select("select * from categorie where id = "+id);
		  try {
			if(rs.next()) {
				  c=new Categorie();
				  c.setId(rs.getInt(1));
				  c.setCat_name(rs.getString(2));
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Categorie> AllCategories(){
		List<Categorie> ca = new ArrayList<Categorie>();
		Categorie c = null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from categorie");
		try {
			while(rs.next()) {
				c = new Categorie();
				c.setId(rs.getInt(1));
				c.setCat_name(rs.getString(2));
				ca.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ca;
	}
}
