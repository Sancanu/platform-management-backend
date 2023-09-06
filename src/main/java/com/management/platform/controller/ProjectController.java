package com.management.platform.controller;

import com.management.platform.entity.Project;
import com.management.platform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping(path = "projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getAll(){
        return  projectService.getProjects();
    }
    @GetMapping("/{ProjectId}")
    public Optional<Project> getProject(@PathVariable("ProjectId") Long id){
        return  projectService.getProject(id);
    }

    @PostMapping
    public Project createOrUpdateProject(@RequestBody Project Project){
        projectService.saveOrUpdate(Project);
        return Project;
    }

    @DeleteMapping ("/{ProjectId}")
    public void deleteProject(@PathVariable("ProjectId") Long id){
        projectService.delete(id);
    }
    
}
