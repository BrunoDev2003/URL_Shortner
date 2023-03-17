package com.url_shortner.persistence;

public class linkDAO extends DAO {
	private static final String INSERT = "insert into tb_link(url, code, insert_date) values(?,(select substr(to_base64((select count(1) as total from tb_link l)),1,7) ), sysdate());";
	public boolean create(String url)throws Exception{
		try {
			open();
			stmt = con.prepareStatement(INSERT);
			stmt.setString(1, url);
			return stmt.execute();
		} catch (Exception e) {
			return false;
		} finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		try {
			linkDAO ldao = new linkDAO();
			ldao.create("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_sidenav_push");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
