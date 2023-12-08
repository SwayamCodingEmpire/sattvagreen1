package com.medninja.sattvagreen.repository;

import com.medninja.sattvagreen.entity.LocalRemediesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalRemediesRepository extends JpaRepository<LocalRemediesEntity,Long> {

}
