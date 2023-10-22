package com.iselab.ise.service.impl;

import com.iselab.ise.model.POJO.Project;
import com.iselab.ise.repository.ProjectRepository;
import com.iselab.ise.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Page<Project> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
