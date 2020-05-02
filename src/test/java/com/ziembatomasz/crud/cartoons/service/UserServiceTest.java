package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.User;
import com.ziembatomasz.crud.cartoons.domain.UserDto;
import com.ziembatomasz.crud.cartoons.mapper.UserMapper;
import com.ziembatomasz.crud.cartoons.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private User user;

    private UserService userService;

    private UserMapper userMapper = new UserMapper();
    @Mock
    private UserRepository userRepository;
    @Before
    public void createUserObject(){
        user = new User(1L, "George", "Pavlovski", "pavlo@gmail.com");
    }
    @Before
    public void createUserServiceObject(){
        userService = new UserService(userRepository, userMapper);
    }
    @Test
    public void gestAllUsersTest(){
        //Given
        List<User>users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);
        //When
        List<UserDto>userDtos = userService.getAllUsers();
        //Then
        assertEquals(1, userDtos.size());
    }
    @Test
    public void getUserById(){
        //Given
        when(userRepository.getOne(1L)).thenReturn(user);
        //When
        UserDto userDto = userService.getUser(1L);
        //Then
        assertThat(userDto.getId(), is(1L));
    }
}