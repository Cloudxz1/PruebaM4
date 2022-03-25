package pruebaM4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TitleTypesCRUD {

	
	public static boolean InsertTitle(Connection con, TitleTypes title) {
		PreparedStatement query;
		boolean siInserto = false;
		
		try {
			
			query = con.prepareStatement("INSERT INTO title_types(title) VALUES(default,?)", Statement.RETURN_GENERATED_KEYS);
			
			query.setString(1, title.getTitle());
			query.executeUpdate();		
			ResultSet tableKeys = query.getGeneratedKeys();
			tableKeys.next();
			siInserto = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return siInserto;
	}
	
	public static TitleTypes SelectTitle(Connection con, int title_no) {
		
		PreparedStatement query;
		TitleTypes title  = null;
		try {
			query = con.prepareStatement("SELECT * FROM title_types WHERE title_no= ?");
			query.setInt(1, title_no);
			ResultSet resultado = query.executeQuery();
			resultado.next();
			title = new TitleTypes(resultado.getInt("title_no"),resultado.getString("title"));
			
		}catch(SQLException e) {
	
			e.printStackTrace();
		}
		return title;
	}
	public static boolean DeleteTitle(Connection con, int title_no) {
		PreparedStatement query;
		boolean SiElimino = false;
		try {
			query = con.prepareStatement("DELETE FROM title_types WHERE title_no=?");
			query.setInt(1, title_no);
			query.execute();
			SiElimino=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return SiElimino;
	}
	public static boolean UpdateTitles(Connection con, TitleTypes title) {
		
		PreparedStatement query;
		boolean Mod = false;
		try {
			query = con.prepareStatement("UPDATE title_types SET title=? WHERE title_no='"+title.getTitle_no()+"'");
			query.setString(1, title.getTitle());
			query.executeUpdate();
			Mod = true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Mod;
	}
}

