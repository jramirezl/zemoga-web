package com.zamoga.portafolioweb.service;


import com.zamoga.portafolioweb.entities.ZemogaProfileEntity;
import com.zamoga.portafolioweb.repository.ZemogaProfileRepository;
import com.zamoga.portafolioweb.twitter.client.ClientTwitter;
import com.zamoga.portafolioweb.vo.ZemogaProfileVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZemogaProfileService {
    private ZemogaProfileRepository zemogaProfileRepository;
    private ClientTwitter clientTwitter;
    @Autowired
    public ZemogaProfileService(ZemogaProfileRepository zemogaProfileRepository, ClientTwitter clientTwitter) {
        this.zemogaProfileRepository = zemogaProfileRepository;
        this.clientTwitter = clientTwitter;
    }


    public ZemogaProfileVO findByName(String name) {
        List<ZemogaProfileEntity> list = zemogaProfileRepository.findByName(name);
        if(list != null && list.size() >0 ){
            ZemogaProfileVO zemogaProfileVO = getDTO(list.get(0));
            List<String> listT = clientTwitter.getLatestTweetsByUser(zemogaProfileVO.getTwitterName());
                 if(listT!= null && listT.size() >0 ){
                zemogaProfileVO.setTwitts(listT);
            }

            return zemogaProfileVO;
        }
        return new ZemogaProfileVO();
    }

    public ZemogaProfileVO save(ZemogaProfileVO zemogaProfileVO) {
        List<ZemogaProfileEntity> list = zemogaProfileRepository.findByName(zemogaProfileVO.getName());
        if(list != null && list.size() >0 ){
            ZemogaProfileEntity zemogaProfileEntity = list.get(0);
            zemogaProfileEntity.setDescription(zemogaProfileVO.getDescription());
            zemogaProfileEntity.setImage(zemogaProfileVO.getImage());
            zemogaProfileEntity.setTwitterName(zemogaProfileVO.getTwitterName());
            zemogaProfileEntity.setName(zemogaProfileVO.getName());

            zemogaProfileRepository.save(zemogaProfileEntity);
            return getDTO(zemogaProfileEntity);
        }

        return zemogaProfileVO;
    }

    private ZemogaProfileVO getDTO(ZemogaProfileEntity zemogaProfileEntity) {
        ModelMapper modelMapper = new ModelMapper();
        ZemogaProfileVO dto = modelMapper.map(zemogaProfileEntity, ZemogaProfileVO.class);
        return dto;
    }

    private ZemogaProfileEntity getEntity(ZemogaProfileVO user) {
        ModelMapper modelMapper = new ModelMapper();
        ZemogaProfileEntity entity = modelMapper.map(user, ZemogaProfileEntity.class);
        return entity;
    }

}
