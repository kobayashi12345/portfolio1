package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter2;

public class MutterDAO {
	// TODO 自動生成されたコンストラクター・スタブ
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/data/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Mutter2> findAll(){
		List<Mutter2> mutterList = new ArrayList<>();

		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){

				//SELECT文を準備
				String sql = "SELECT ID,NAME,TEXT,LIKE_,DISLIKE FROM MUTTER2 ORDER BY ID DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				//SELECTを実行し、結果表(ResultSet)を取得
				ResultSet rs = pStmt.executeQuery();

				//結果表に格納されたレコードの内容を
				//Mutterインスタンスに設定し、Arraylistインスタンスに格納
				while(rs.next()) {
					int id = rs.getInt("ID");
					String userName = rs.getString("NAME");
					String text = rs.getString("TEXT");
					int like = rs.getInt("LIKE_");
					int dislike = rs.getInt("DISLIKE_");
					Mutter2 mutter = new Mutter2(id,userName,text,like,dislike);
					mutterList.add(mutter);
				}
			//例外をキャッチ
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
		return mutterList;
	}


	public boolean update (Mutter2 mutter) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){

				//UPDATE文を準備
				String sql = "UPDATE MUTTER2 SET NAME=?, TEXT=?, LIKE_=? DISlIE=? WHERE ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,mutter.getUserName());
				pStmt.setString(2,mutter.getText());
				pStmt.setInt(3,mutter.getLike());
				pStmt.setInt(4,mutter.getDislike());
				pStmt.setInt(5,mutter.getId());

		//UPDATEを実行し、結果表(ResultSet)を取得
				int result = pStmt.executeUpdate();

				if(result !=1){
					return false;
				}
			}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	return true;
	}



	public boolean create(Mutter2 mutter) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(
				JDBC_URL,DB_USER,DB_PASS)){

				//INSERT文を準備
				String sql = "INSERT INTO MUTTER2(ID,NAME,TEXT,LIKE_,DISLIKE) VALUES(?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1,mutter.getUserName());
				pStmt.setString(2,mutter.getText());

				//INSERTを実行し、結果表(ResultSet)を取得
				int result = pStmt.executeUpdate();

				if(result !=1){
					return false;
				}
			//例外をキャッチ
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	return true;
	}


}









