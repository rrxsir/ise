package com.iselab.ise.service.impl;

import com.iselab.ise.model.POJO.Slides;
import com.iselab.ise.repository.SlidesRepository;
import com.iselab.ise.service.SlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlidesServiceImpl implements SlidesService {

    private final SlidesRepository slidesRepository;

    @Autowired
    public SlidesServiceImpl(SlidesRepository slidesRepository) {
        this.slidesRepository = slidesRepository;
    }

    @Override
    public Slides getById(Long id) {
        return slidesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Slides> getAll() {
        return slidesRepository.findAll();
    }

    @Override
    public Page<Slides> getAll(Pageable pageable) {
        return slidesRepository.findAll(pageable);
    }

    @Override
    public Slides add(Slides slides) {
        return slidesRepository.save(slides);
    }

    @Override
    public Slides update(Slides slides) {
        return slidesRepository.save(slides);
    }

    @Override
    public boolean delete(Long id) {
        slidesRepository.deleteById(id);
        return true;
    }

}
