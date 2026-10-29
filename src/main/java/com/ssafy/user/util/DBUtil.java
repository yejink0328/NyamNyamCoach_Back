package com.ssafy.user.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // DB 연결 정보
    private final String url =
            "jdbc:mysql://localhost:3306/nyamnyam?serverTimezone=UTC";
    private final String user = "ssafy";
    private final String password = "ssafy";

    private final String driverName = "com.mysql.cj.jdbc.Driver";

    // 싱글턴: DBUtil 객체를 하나만 생성
    private static final DBUtil instance = new DBUtil();

    // 외부에서 new DBUtil() 사용 불가
    private DBUtil() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(
                    "MySQL JDBC 드라이버를 찾을 수 없습니다.", e);
        }
    }

    // 생성된 DBUtil 객체 반환
    public static DBUtil getInstance() {
        return instance;
    }

    // 호출할 때마다 새로운 DB 연결 반환
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 전달받은 순서대로 자원 해제
    public void close(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}