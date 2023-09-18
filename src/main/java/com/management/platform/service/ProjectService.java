package com.management.platform.service;

import com.management.platform.entity.Project;
import com.management.platform.exception.NotFoundExepcion;
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
    public Project getProject(Long id){

        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return project.get();
        } else {
            throw new NotFoundExepcion("Project by id " + id + " was not found");
        }
    }

    public void saveOrUpdate(Project project){
        projectRepository.save(project);
    }


    public void delete(Long id){
        projectRepository.deleteById(id);

    }
    
}
