package com.iselab.ise.repository;

import com.iselab.ise.model.POJO.Project;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    @NotNull
    Page<Project> findAll(@NotNull Pageable pageable);

    @NotNull
    List<Project> findAll();
}
