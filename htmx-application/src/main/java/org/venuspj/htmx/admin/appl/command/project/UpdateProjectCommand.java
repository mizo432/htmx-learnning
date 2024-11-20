package org.venuspj.htmx.admin.appl.command.project;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.domain.model.project.Project;
import org.venuspj.htmx.admin.domain.model.project.ProjectRepository;

@Service
@RequiredArgsConstructor
public class UpdateProjectCommand {

  private final ProjectRepository projectRepository;


  @Transactional
  public Project execute(Project project) {
    if (projectRepository.findById(project.getId()).isPresent()) {
      return projectRepository.save(project);
    }
    throw new EntityNotFoundException(
        String.format("Project not found projectId: %s", project.getId()));

  }
}
