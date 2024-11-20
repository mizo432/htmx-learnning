package org.venuspj.htmx.admin.appl.command.project;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.venuspj.htmx.admin.domain.model.project.Project;
import org.venuspj.htmx.admin.domain.model.project.ProjectRepository;

@Service
@RequiredArgsConstructor
public class CreateProjectCommand {

  private final ProjectRepository projectRepository;

  @Transactional
  public Project execute(@NonNull Project project) {
    validateProject(project);
    try {
      projectRepository.save(project);
    } catch (DataIntegrityViolationException e) {
      // データ整合性違反の処理
      throw new RuntimeException("Data integrity violation: " + e.getMessage(), e);
    } catch (Exception e) {
      // その他の一般的な例外の処理
      throw new RuntimeException("Project could not be saved", e);
    }
    return project;
  }

  private void validateProject(Project project) {
    // プロジェクトのその他のバリデーションを行う
    // ここではnullチェックは不要
    // 例えば
    if (project.getName() == null || project.getName().isEmpty()) {
      throw new IllegalArgumentException("Project name must not be null or empty");
    }
    // その他のバリデーションロジック
  }
}
