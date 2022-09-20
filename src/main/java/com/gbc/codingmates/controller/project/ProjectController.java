package com.gbc.codingmates.controller.project;

import com.gbc.codingmates.domain.project.Project;
import com.gbc.codingmates.domain.project.ProjectRepository;
import com.gbc.codingmates.dto.project.ProjectDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProjectController {
    private ProjectRepository projectRepository;

    @PostMapping("/project")
    public void createPost(@RequestBody ProjectDto projectDto) {
        projectRepository.save(projectDto.toEntity());
    }
}
