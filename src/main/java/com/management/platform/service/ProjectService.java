package com.management.platform.service;

import com.management.platform.entity.Project;
import com.management.platform.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getProjects(){
        return  projectRepository.findAll();
    }
    public Optional<Project> getProject(Long id){
        return  projectRepository.findById(id);
    }

    public void saveOrUpdate(Project student){
        projectRepository.save(student);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);

    }
    
}
