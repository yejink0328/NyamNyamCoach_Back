package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.model.dto.UserDto;

public interface UserService {

    // 전체 회원 조회
    List<UserDto> getList();

    // 회원 한 명 조회: 회원 번호(UUID) 사용
    UserDto getUser(int uuid);

    // 회원가입
    void signup(UserDto user);

    // 회원정보 수정
    void modifyUser(UserDto user);

    // 회원탈퇴
    void removeUser(int uuid);

    // 로그인: 성공하면 회원 정보, 실패하면 null 반환
    UserDto login(String id, String pw);
}