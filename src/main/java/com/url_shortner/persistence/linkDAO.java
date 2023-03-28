package com.url_shortner.persistence;

import java.util.List;

public class linkDAO extends DAO {
	private static final String INSERT = "insert into tb_link(url, code, insert_date) values(?,(select substr(to_base64((select count(1) as total from tb_link l)),1,7) ), sysdate());";
	private static final String UPDATE = "update tb_link set custom = 'brunogusmao' where id=1;";
	private static final String FIND_ALL = "select id, url, code, custom from tb_link;";
	public List<LinkBean> findAll()throws Exception{
		List<LinkBean> links = null;
		try {
			open();
			stmt = con.prepareStatement(FIND_ALL);
			rs = stmt.executeQuery();	
			while(rs.next()) {
				links.add(new LinkBean(rs.getInt("id"), rs.getString("url"),
						rs.getString("Code"), rs.getString("custom")));
			}
			//stmt.setString(1, url);
			//return stmt.execute();
		} catch (Exception e) {
			System.out.print(e.getMessage());
			//return false;
		} finally {
			close();
		}
		return links;
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
	
	public boolean update(String custom, int id) throws Exception {
		try {
			open();
			stmt = con.prepareStatement(UPDATE);
			stmt.setString(1, custom);
			stmt.setInt(2, id);
			return stmt.executeUpdate() > 0 ? true : false;
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
			ldao.update("TR", 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	
}
