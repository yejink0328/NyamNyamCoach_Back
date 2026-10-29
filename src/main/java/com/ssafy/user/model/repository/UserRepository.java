package com.ssafy.user.model.repository;

import java.util.List;

import com.ssafy.user.model.dto.UserDto;

public interface UserRepository {

    // 전체 회원 조회
    List<UserDto> selectAll();

    // 회원 번호로 한 명 조회
    UserDto selectOne(int uuid);

    // 회원 등록
    void insertUser(UserDto user);

    // 회원정보 수정
    void updateUser(UserDto user);

    // 회원 삭제
    void deleteUser(int uuid);

    // 로그인: 일치하는 회원이 없으면 null 반환
    UserDto login(String id, String pw);
}