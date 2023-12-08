package com.medninja.sattvagreen.service;

import com.medninja.sattvagreen.model.HazardRemedies;
import com.medninja.sattvagreen.model.HazardRemedies;

import java.util.List;

public interface HazardRemediesService {
    HazardRemedies saveHazardRemedies(HazardRemedies hazardRemedies);

    List<HazardRemedies> getAllHazardRemedies();
    HazardRemedies getHazardRemediesById(Long remid);

    boolean deleteHazardRemedies(Long remid);

    HazardRemedies updateHazardRemedies(Long remid, HazardRemedies hazardRemedies);
}
