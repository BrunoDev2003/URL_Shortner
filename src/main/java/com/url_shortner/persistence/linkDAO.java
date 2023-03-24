package com.url_shortner.persistence;

public class linkDAO extends DAO {
	private static final String INSERT = "insert into tb_link(url, code, insert_date) values(?,(select substr(to_base64((select count(1) as total from tb_link l)),1,7) ), sysdate());";
	private static final String FIND_ALL = "select id, url, code, custom from tb_link;";
	public void findAll()throws Exception{
		try {
			open();
			stmt = con.prepareStatement(FIND_ALL);
			rs = stmt.executeQuery();	
			while(rs.next()) {
				System.out.print("++++++++++++++");
				System.out.print("Id = "+rs.getInt("id"));
				System.out.print("URL = "+rs.getInt("url"));
				System.out.print("Code= "+rs.getInt("code"));
				System.out.print("Custom = "+rs.getInt("custom"));
				System.out.print("++++++++++++++");
			}
			//stmt.setString(1, url);
			//return stmt.execute();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return false;
		} finally {
			close();
		}
	}
	
	private boolean create(String url) throws Exception {
		try {
			open();
			stmt = con.prepareStatement(INSERT);
			stmt.setString(1, url);
			return stmt.execute();
		} catch (Exception err) {
			return false;
		} finally {
			close();
		}
		
		
	}
	
	public static void main(String[] args) {
		try {
			linkDAO ldao = new linkDAO();
			ldao.create("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_sidenav_push");
			ldao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
}
