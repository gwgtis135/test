package co.micol.board.comm;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//데이터소스 객체란? db랑 연결할 수 있는 객체를 만들었다는 말임 
//관계적으로 데이터소스를 사용함
public class DataSource {
	private static DataSource dataSource;
	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection conn;
		//싱글톤 만드는법 자신을 스에티익화  생성자를 만들수 없도록 프라이빗으로 막아준다. 
	private DataSource() {
		getProperties();		//외부에 있는 데이터베이스 정보를 가져온다.
	}
	
	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("데이터베이스 연결 실패 !!!!!!!!!");
			e.printStackTrace();
		}
		return conn;
	}
	private void getProperties() {
		String resource = "/db.properties";
		Properties properties = new Properties();
		try {
			InputStream inputStream  = getClass().getClassLoader().getResourceAsStream(resource);
			properties.load(inputStream);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
