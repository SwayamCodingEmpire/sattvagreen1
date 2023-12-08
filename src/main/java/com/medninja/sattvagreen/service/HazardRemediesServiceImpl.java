package com.medninja.sattvagreen.service;

import com.medninja.sattvagreen.entity.HazardRemediesEntity;
import com.medninja.sattvagreen.model.HazardRemedies;
import com.medninja.sattvagreen.repository.HazardRemediesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HazardRemediesServiceImpl implements HazardRemediesService {
    @Autowired
    private HazardRemediesRepository hazardRemediesRepository;
    @Override
    public HazardRemedies saveHazardRemedies(HazardRemedies hazardRemedies) {
        HazardRemediesEntity hazardRemediesEntity = new HazardRemediesEntity();
        BeanUtils.copyProperties(hazardRemedies,hazardRemediesEntity);
        hazardRemediesRepository.save(hazardRemediesEntity);
        return hazardRemedies;
    }

    @Override
    public List<HazardRemedies> getAllHazardRemedies() {
        List<HazardRemediesEntity> hazardRemediesEntities = hazardRemediesRepository.findAll();
        List<HazardRemedies> hazardRemedies = hazardRemediesEntities.stream().map(hazardRemediesEntity -> new HazardRemedies(
                        hazardRemediesEntity.getRemid(),
                        hazardRemediesEntity.getRemedy(),
                        hazardRemediesEntity.getRemedySource(),
                        hazardRemediesEntity.getDisease()
                ))
                .collect(Collectors.toList());
        return hazardRemedies;
    }

    @Override
    public HazardRemedies getHazardRemediesById(Long remid) {
        HazardRemediesEntity hazardRemediesEntity = hazardRemediesRepository.findById(remid).get();
        HazardRemedies hazardRemedies = new HazardRemedies();
        BeanUtils.copyProperties(hazardRemediesEntity,hazardRemedies);
        return hazardRemedies;
    }

    @Override
    public boolean deleteHazardRemedies(Long remid) {
        HazardRemediesEntity hazardRemediesEntity = hazardRemediesRepository.findById(remid).get();
        hazardRemediesRepository.delete(hazardRemediesEntity);
        return true;
    }

    @Override
    public HazardRemedies updateHazardRemedies(Long remid, HazardRemedies hazardRemedies) {
        HazardRemediesEntity hazardRemediesEntity = hazardRemediesRepository.findById(remid).get();
        hazardRemediesEntity.setRemedy(hazardRemedies.getRemedy());
        hazardRemediesEntity.setDisease(hazardRemedies.getDisease());
        hazardRemediesEntity.setRemedySource(hazardRemedies.getRemedySource());
        hazardRemediesRepository.save(hazardRemediesEntity);
        return hazardRemedies;
    }


}
