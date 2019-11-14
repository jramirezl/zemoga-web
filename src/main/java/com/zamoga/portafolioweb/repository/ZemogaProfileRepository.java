package com.zamoga.portafolioweb.repository;


import com.zamoga.portafolioweb.entities.ZemogaProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ZemogaProfileRepository extends JpaRepository<ZemogaProfileEntity, Long> {
    List<ZemogaProfileEntity> findByName(
            String name
    );
}
