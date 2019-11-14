package com.example.demo;

import com.zamoga.portafolioweb.entities.ZemogaProfileEntity;
import com.zamoga.portafolioweb.repository.ZemogaProfileRepository;
import com.zamoga.portafolioweb.service.ZemogaProfileService;
import com.zamoga.portafolioweb.twitter.client.ClientTwitter;
import com.zamoga.portafolioweb.vo.ZemogaProfileVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ZamogaProfileServiceTest {

    @Mock
    private ClientTwitter clientTwitter;
    @Mock
    private ZemogaProfileRepository zemogaProfileRepository ;

    private ZemogaProfileService zemogaProfileService;

    @BeforeEach
    void initUseCase() {
        zemogaProfileService = new ZemogaProfileService(zemogaProfileRepository, clientTwitter );
    }

    @Test
    void retrieveTheProfileByUserName() {

        List<String> list = Arrays.asList("tweet 1", "tweet 2");
        List<ZemogaProfileEntity> listEntities = new ArrayList<>();


        ZemogaProfileVO expectedVal = ZemogaProfileVO.builder().id(1l).description("desc").image("img").name("juan").twitterName("juan")
                .build();

        ZemogaProfileEntity zemogaProfileEntity = getEntity(expectedVal);
        listEntities.add(zemogaProfileEntity);


        Mockito.when(clientTwitter.getLatestTweetsByUser("juan"))
                .thenReturn(list);

        Mockito.when(zemogaProfileRepository.findByName("juan"))
                .thenReturn(listEntities);

        ZemogaProfileVO actualVal = zemogaProfileService.findByName("juan");

        assertThat(actualVal.getTwitterName())
                .isEqualTo(expectedVal.getTwitterName());

        assertThat(actualVal.getTwitts())
                .isEqualTo(list);
    }

    private ZemogaProfileEntity getEntity(ZemogaProfileVO user) {
        ModelMapper modelMapper = new ModelMapper();
        ZemogaProfileEntity entity = modelMapper.map(user, ZemogaProfileEntity.class);
        return entity;
    }


}
