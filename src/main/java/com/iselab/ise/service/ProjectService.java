package com.iselab.ise.service;

import com.iselab.ise.model.POJO.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Page<Project> getAll(Pageable pageable);

    Project getById(Long id);

    Project add(Project project);

    Project update(Project project);

    boolean delete(Long id);

}
