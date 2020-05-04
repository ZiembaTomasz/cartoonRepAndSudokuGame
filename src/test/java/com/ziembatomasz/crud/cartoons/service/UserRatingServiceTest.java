package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.User;
import com.ziembatomasz.crud.cartoons.domain.UserRating;
import com.ziembatomasz.crud.cartoons.domain.UserRatingDto;
import com.ziembatomasz.crud.cartoons.mapper.UserRatingMapper;
import com.ziembatomasz.crud.cartoons.repository.UserRatingRepository;
import com.ziembatomasz.crud.cartoons.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRatingServiceTest {
    private UserRatingService userRatingService;
    private UserRatingMapper userRatingMapper = new UserRatingMapper();
    @Mock
    private UserRatingRepository userRatingRepository;
    @Mock
    private UserRepository userRepository;
    @Before
    public void createUserRatingServiceObject(){
        userRatingService = new UserRatingService(userRatingRepository, userRatingMapper, userRepository);
    }
    @Test
    public void shouldFindUserRatingServiceById(){
        //Given
        User user= new User(1L, "Jan", "Fiodor", "fiodor@gmail.com");
        UserRating userRating = new UserRating(1L, 10, user, 1L);
        List<UserRating>userRatings = new ArrayList<>();
        userRatings.add(userRating);
        when(userRatingRepository.findUserRatingByCartoonId(1L)).thenReturn(userRatings);
        //When
        List<UserRatingDto>resultList = userRatingService.findByCartoonId(1L);
        //Then
        assertEquals(1, resultList.size());

    }

}