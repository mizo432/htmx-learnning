package org.venuspj.htmx.admin.domain.model.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Projectエンティティを管理するためのリポジトリインターフェースです。
 * <p>
 * このインターフェースは、`JpaRepository`から継承した標準操作を含む、 Projectエンティティに対するCRUD操作を提供します。
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
