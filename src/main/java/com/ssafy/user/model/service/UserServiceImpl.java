package com.ssafy.user.model.service;

import java.util.List;

import com.ssafy.user.model.dto.UserDto;
import com.ssafy.user.model.repository.UserRepository;
import com.ssafy.user.model.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

    // 싱글턴
    private static final UserService service = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return service;
    }

    // DB 작업은 Repository에 위임
    private final UserRepository repository =
            UserRepositoryImpl.getInstance();

    @Override
    public List<UserDto> getList() {
        return repository.selectAll();
    }

    @Override
    public UserDto getUser(int uuid) {
        return repository.selectOne(uuid);
    }

    //회원가입
    @Override
    public void signup(UserDto user) {
        if (user == null) {
            throw new IllegalArgumentException("회원 정보를 입력하세요.");
        }

        String id = user.getId();
        String pw = user.getPw();
        String name = user.getUserName();

        if (id == null || !id.matches("[A-Za-z0-9_]{4,50}")) {
            throw new IllegalArgumentException(
                    "아이디는 영문, 숫자, 밑줄로 4~50자 입력하세요.");
        }

        if (pw == null || pw.isBlank()
                || pw.length() < 8 || pw.length() > 128) {
            throw new IllegalArgumentException(
                    "비밀번호는 8~128자로 입력하세요.");
        }

        if (name == null || name.isBlank()
                || name.trim().length() > 100) {
            throw new IllegalArgumentException(
                    "이름은 1~100자로 입력하세요.");
        }

        if (user.getUserHeight() <= 0 || user.getUserHeight() > 300) {
            throw new IllegalArgumentException(
                    "키는 1~300cm 범위로 입력하세요.");
        }

        double weight = user.getUserWeight();

        if (!Double.isFinite(weight) || weight <= 0 || weight > 1000) {
            throw new IllegalArgumentException(
                    "몸무게는 0 초과, 1000kg 이하로 입력하세요.");
        }

        user.setUserName(name.trim());

        repository.insertUser(user);
    }
    
    
    

    @Override
    public void modifyUser(UserDto user) {
        repository.updateUser(user);
    }

    @Override
    public void removeUser(int uuid) {
        repository.deleteUser(uuid);
    }

    @Override
    public UserDto login(String id, String pw) {
        // 입력이 없으면 로그인 실패
        if (id == null || id.isBlank()
                || pw == null || pw.isBlank()) {
            return null;
        }

        return repository.login(id, pw);
    }
}