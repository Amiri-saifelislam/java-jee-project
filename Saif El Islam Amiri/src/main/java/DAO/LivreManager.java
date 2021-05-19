package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livre;

public class LivreManager {
	public int ajouterLivre(String nomLivre,String auteur,int cat_id) {
		DBinteraction.connect();
		int nb = DBinteraction.Maj("insert into livre(nomLivre,auteur,cat_id) values ( '"+nomLivre+"' , '"+auteur+"' , "+cat_id+")");
		DBinteraction.disconnect();
		return nb;
	}
	
	public List<Livre> AllLivres(){
		List<Livre> lv = new ArrayList<Livre>();
		CategorieManager m = new CategorieManager();
		Livre l = null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from livre");
		try {
			while(rs.next()) {
				l = new Livre();
				l.setId(rs.getInt(1));
				l.setNom_livre(rs.getString(2));
				l.setAuteur(rs.getString(3));
				int id = rs.getInt(4);
				l.setC(m.findCategorieByid(id));
				lv.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
	public List<Livre> livresParCategorie(int id_cat){
		List<Livre> lv = new ArrayList<Livre>();
		CategorieManager m = new CategorieManager();
		Livre l = null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from livre where cat_id = "+id_cat);
		try {
			while(rs.next()) {
				l = new Livre();
				l.setId(rs.getInt(1));
				l.setNom_livre(rs.getString(2));
				l.setAuteur(rs.getString(3));
				int id = rs.getInt(4);
				l.setC(m.findCategorieByid(id));
				lv.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lv;
	}
}
