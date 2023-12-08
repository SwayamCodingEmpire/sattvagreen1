package com.medninja.sattvagreen.service;

import com.medninja.sattvagreen.model.LocalRemedies;

import java.util.List;

public interface LocalRemediesService  {
    LocalRemedies saveLocalRemedies(LocalRemedies localRemedies);

    List<LocalRemedies> getAllLocalRemedies();
    LocalRemedies getLocalRemediesById(Long remid);

    boolean deleteLocalRemedies(Long remid);

    LocalRemedies updateLocalRemedies(Long remid, LocalRemedies localRemedies);
}
