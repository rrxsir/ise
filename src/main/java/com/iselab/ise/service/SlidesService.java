package com.iselab.ise.service;

import com.iselab.ise.model.POJO.Slides;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SlidesService {

    Slides getById(Long id);

    List<Slides> getAll();

    Slides add(Slides slides);

    Slides update(Slides slides);

    boolean delete(Long id);

    Page<Slides> getAll(Pageable pageable);
}
