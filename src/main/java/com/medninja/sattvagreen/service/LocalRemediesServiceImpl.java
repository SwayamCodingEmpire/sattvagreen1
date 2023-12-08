package com.medninja.sattvagreen.service;

import com.medninja.sattvagreen.entity.LocalRemediesEntity;
import com.medninja.sattvagreen.model.LocalRemedies;
import com.medninja.sattvagreen.repository.LocalRemediesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalRemediesServiceImpl implements LocalRemediesService {
    @Autowired
    private LocalRemediesRepository localRemediesRepository;
    @Override
    public LocalRemedies saveLocalRemedies(LocalRemedies localRemedies) {
        LocalRemediesEntity localRemediesEntity = new LocalRemediesEntity();
        BeanUtils.copyProperties(localRemedies,localRemediesEntity);
        localRemediesRepository.save(localRemediesEntity);
        return localRemedies;
    }

    @Override
    public List<LocalRemedies> getAllLocalRemedies() {
        List<LocalRemediesEntity> localRemediesEntities = localRemediesRepository.findAll();
        List<LocalRemedies> localRemedies = localRemediesEntities.stream().map(localRemediesEntity -> new LocalRemedies(
                localRemediesEntity.getRemid(),
                localRemediesEntity.getRemedy(),
                localRemediesEntity.getRemedySource(),
                localRemediesEntity.getDisease()
                ))
                .collect(Collectors.toList());
        return localRemedies;
    }

    @Override
    public LocalRemedies getLocalRemediesById(Long remid) {
        LocalRemediesEntity localRemediesEntity = localRemediesRepository.findById(remid).get();
        LocalRemedies localRemedies = new LocalRemedies();
        BeanUtils.copyProperties(localRemediesEntity,localRemedies);
        return localRemedies;
    }

    @Override
    public boolean deleteLocalRemedies(Long remid) {
        LocalRemediesEntity localRemediesEntity = localRemediesRepository.findById(remid).get();
        localRemediesRepository.delete(localRemediesEntity);
        return true;
    }

    @Override
    public LocalRemedies updateLocalRemedies(Long remid, LocalRemedies localRemedies) {
        LocalRemediesEntity localRemediesEntity = localRemediesRepository.findById(remid).get();
        localRemediesEntity.setRemedy(localRemedies.getRemedy());
        localRemediesEntity.setDisease(localRemedies.getDisease());
        localRemediesEntity.setRemedySource(localRemedies.getRemedySource());
        localRemediesRepository.save(localRemediesEntity);
        return localRemedies;
    }


}
