package com.iselab.ise.repository;

import com.iselab.ise.model.POJO.Slides;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlidesRepository extends PagingAndSortingRepository<Slides, Long> {

    @NotNull
    Page<Slides> findAll(@NotNull Pageable pageable);

    @NotNull
    List<Slides> findAll();
}
