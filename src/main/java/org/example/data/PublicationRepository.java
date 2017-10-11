package org.example.data;

import org.example.domain.AccessLevel;
import org.example.domain.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

public interface PublicationRepository extends ModelRepository<Publication>
{
  @Query("SELECT"
      + "     a "
      + "FROM "
      + "     Publication a "
      + "WHERE "
      + "     a.accessLevel                      = COALESCE(?1, a.accessLevel) "
      + "AND  UPPER(TRIM(BOTH ' ' FROM a.title)) = UPPER(TRIM(BOTH ' ' FROM COALESCE(?2, '')))")
  Page<Publication> findAllByAccessLevelAndTitle(AccessLevel accessLevel, String title, Pageable pageable);

  default Page<Publication> findAllByAccessLevelAndTitle(AccessLevel accessLevel, String title)
  {
    return findAllByAccessLevelAndTitle(accessLevel, title, new PageRequest(0, 10, new Sort("title")));
  }

  @Query("SELECT"
      + "     a "
      + "FROM "
      + "     Publication a "
      + "WHERE "
      + "     a.accessLevel                      = COALESCE(?1, a.accessLevel) "
      + "AND  UPPER(TRIM(BOTH ' ' FROM a.title)) LIKE CONCAT('%', UPPER(TRIM(BOTH ' ' FROM COALESCE(?2, ''))), '%')")
  Page<Publication> findAllByAccessLevelAndTitleLike(AccessLevel accessLevel, String title, Pageable pageable);

  default Page<Publication> findAllByAccessLevelAndTitleLike(AccessLevel accessLevel, String title)
  {
    return findAllByAccessLevelAndTitleLike(accessLevel, title, new PageRequest(0, 10, new Sort("title")));
  }
}
