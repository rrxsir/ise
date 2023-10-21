package com.iselab.ise.service;

import com.iselab.ise.model.POJO.Slides;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SlidesService {

    Slides getSlidesById(Long id);

    List<Slides> getAllSlides();

    Slides addSlides(Slides slides);

    Slides updateSlides(Slides slides);

    boolean deleteSlides(Long id);

    Page<Slides> getAllSlides(Pageable pageable);
}
