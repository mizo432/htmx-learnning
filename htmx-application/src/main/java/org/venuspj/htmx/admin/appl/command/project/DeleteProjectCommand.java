package org.venuspj.htmx.admin.appl.command.project;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venuspj.htmx.admin.domain.model.project.Project;
import org.venuspj.htmx.admin.domain.model.project.ProjectRepository;

@RequiredArgsConstructor
@Service
public class DeleteProjectCommand {

  private final ProjectRepository projectRepository;

  @Transactional
  public void execute(Long id) {
    if (id == null) {
      throw new IllegalArgumentException("Project ID must not be null");
    }

    Optional<Project> po = projectRepository.findById(id);
    if (po.isPresent()) {
      projectRepository.delete(po.get());
      return;
    }

    throw new EmptyResultDataAccessException(
        String.format("Project not found: projectId=%s", id), 1);
  }
}
