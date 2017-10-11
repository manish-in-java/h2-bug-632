package org.example.data;

import org.example.domain.AccessLevel;
import org.example.domain.Publication;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicationRepository extends ModelRepository<Publication>
{
  @Query("SELECT"
      + "     a "
      + "FROM "
      + "     Publication a "
      + "WHERE "
      + "     a.accessLevel                      = COALESCE(?1, a.accessLevel) "
      + "AND  UPPER(TRIM(BOTH ' ' FROM a.title)) = UPPER(TRIM(BOTH ' ' FROM COALESCE(?2, '')))")
  List<Publication> findAllByAccessLevelAndTitle(AccessLevel accessLevel, String title);

  @Query("SELECT"
      + "     a "
      + "FROM "
      + "     Publication a "
      + "WHERE "
      + "     a.accessLevel                      = COALESCE(?1, a.accessLevel) "
      + "AND  UPPER(TRIM(BOTH ' ' FROM a.title)) LIKE CONCAT('%', UPPER(TRIM(BOTH ' ' FROM COALESCE(?2, ''))), '%')")
  List<Publication> findAllByAccessLevelAndTitleLike(AccessLevel accessLevel, String title);
}
