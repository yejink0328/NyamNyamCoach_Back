package com.ssafy.user.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.user.model.dto.UserDto;
import com.ssafy.user.util.DBUtil;

public class UserRepositoryImpl implements UserRepository {

    // 싱글턴
    private static final UserRepository repository =
            new UserRepositoryImpl();

    private UserRepositoryImpl() {
    }

    public static UserRepository getInstance() {
        return repository;
    }

    private final DBUtil util = DBUtil.getInstance();

    // 조회 결과 한 행을 DTO로 변환
    private UserDto toDto(ResultSet rs) throws SQLException {
        UserDto user = new UserDto();

        user.setUUID(rs.getInt("UUID"));
        user.setId(rs.getString("ID"));
        user.setUserName(rs.getString("UserName"));
        user.setUserHeight(rs.getInt("UserHeight"));
        user.setUserWeight(rs.getDouble("UserWeight"));

        // 조회 결과와 로그인 세션에 비밀번호를 담지 않음
        return user;
    }

    // 전체 회원 조회
    @Override
    public List<UserDto> selectAll() {
        List<UserDto> list = new ArrayList<>();

        String sql =
                "SELECT UUID, ID, UserName, UserHeight, UserWeight "
                + "FROM `User` ORDER BY UUID";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(toDto(rs));
            }

            return list;
        } catch (SQLException e) {
            throw new IllegalStateException("회원 목록 조회 실패", e);
        } finally {
            util.close(rs, pstmt, conn);
        }
    }

    // 회원 한 명 조회
    @Override
    public UserDto selectOne(int uuid) {
        String sql =
                "SELECT UUID, ID, UserName, UserHeight, UserWeight "
                + "FROM `User` WHERE UUID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uuid);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return toDto(rs);
            }

            return null;
        } catch (SQLException e) {
            throw new IllegalStateException("회원 조회 실패", e);
        } finally {
            util.close(rs, pstmt, conn);
        }
    }

    // 회원가입
    @Override
    public void insertUser(UserDto user) {
        String sql =
                "INSERT INTO `User` "
                + "(ID, PW, UserName, UserHeight, UserWeight) "
                + "VALUES (?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setInt(4, user.getUserHeight());
            pstmt.setDouble(5, user.getUserWeight());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("회원가입 실패", e);
        } finally {
            util.close(pstmt, conn);
        }
    }

    // 회원정보 수정: 이름, 키, 몸무게 변경
    @Override
    public void updateUser(UserDto user) {
        String sql =
                "UPDATE `User` "
                + "SET UserName = ?, UserHeight = ?, UserWeight = ? "
                + "WHERE UUID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserName());
            pstmt.setInt(2, user.getUserHeight());
            pstmt.setDouble(3, user.getUserWeight());
            pstmt.setInt(4, user.getUUID());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("회원정보 수정 실패", e);
        } finally {
            util.close(pstmt, conn);
        }
    }

    // 회원탈퇴
    @Override
    public void deleteUser(int uuid) {
        String sql = "DELETE FROM `User` WHERE UUID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uuid);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("회원탈퇴 실패", e);
        } finally {
            util.close(pstmt, conn);
        }
    }

    // 제공된 평문 테스트 비밀번호를 사용하는 학습용 로그인
    @Override
    public UserDto login(String id, String pw) {
        if (id == null || pw == null) {
            return null;
        }

        String sql =
                "SELECT UUID, ID, PW, UserName, UserHeight, UserWeight "
                + "FROM `User` WHERE ID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = util.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next() && pw.equals(rs.getString("PW"))) {
                return toDto(rs);
            }

            return null;
        } catch (SQLException e) {
            throw new IllegalStateException("로그인 DB 조회 실패", e);
        } finally {
            util.close(rs, pstmt, conn);
        }
    }
}