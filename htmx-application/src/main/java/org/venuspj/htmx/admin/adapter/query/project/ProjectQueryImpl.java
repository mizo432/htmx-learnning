package org.venuspj.htmx.admin.adapter.query.project;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.venuspj.htmx.admin.appl.query.project.ProjectQuery;
import org.venuspj.htmx.admin.domain.model.project.Project;
import org.venuspj.htmx.admin.domain.model.project.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectQueryImpl implements ProjectQuery {

  private final ProjectRepository projectRepository;

  @Override
  public Iterable<Project> findAllProjects() {
    return projectRepository.findAll();
  }

  @Override
  public Optional<Project> findById(Long id) {
    return projectRepository.findById(id);

  }

}
