package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.todo.dto.UserInfoDto;
import com.example.todo.entity.MUser;
import com.example.todo.repository.UserMapper;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * UserService
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper mapper;

  private final ModelMapper modelMapper;

  private final PasswordEncoder passwordEncoder;

  @Override
  public void signup(UserInfoDto user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setDepartmentId(1);
    user.setRole("ROLE_GENERAL");
    MUser entity = modelMapper.map(user, MUser.class);
    mapper.insertOne(entity);
  }

  @Override
  public List<UserInfoDto> getUsers() {
    List<MUser> results = mapper.findMany();
    List<UserInfoDto> outDto = new ArrayList<>();
    if (results.size() > 0) {
      for (MUser result : results) {
        UserInfoDto dto = modelMapper.map(result, UserInfoDto.class);
        outDto.add(dto);
      }
    }
    return outDto;
  }

  @Override
  public Optional<UserInfoDto> getUserOne(String userId) {
    MUser result = mapper.findOne(userId);
    UserInfoDto outDto = modelMapper.map(result, UserInfoDto.class);
    return Optional.ofNullable(outDto);
  }

  @Override
  public void updateUserOne(String userId, String password, String userName) {
    mapper.updateOne(userId, password, userName);
  }

  @Override
  public void deleteUserOne(String userId) {
    mapper.deleteOne(userId);
  };

  @Override
  public UserInfoDto getLoginUser(String userId) {
    MUser result = mapper.findLoginUser(userId);
    UserInfoDto outDto = modelMapper.map(result, UserInfoDto.class);
    return outDto;
  }

}