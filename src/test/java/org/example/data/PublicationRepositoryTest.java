package org.example.data;

import org.example.domain.AccessLevel;
import org.example.domain.Publication;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class PublicationRepositoryTest
{
  private PublicationRepository repository = new PublicationRepository();

  @Before
  public void setup()
  {
    for (int i = 0; i < 5; ++i)
    {
      for (final AccessLevel accessLevel : AccessLevel.values())
      {
        final Publication publication = new Publication();
        publication.setAccessLevel(accessLevel);
        publication.setTitle(UUID.randomUUID().toString());

        repository.save(publication);
      }
    }
  }

  @Test
  public void testFindAllByNullAccessLevelAndNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(null, null));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(AccessLevel.PUBLIC, null));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNonNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(null, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNonNullTitle()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitle(AccessLevel.PUBLIC, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(null, null));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(AccessLevel.PRIVATE, null));
  }

  @Test
  public void testFindAllByNullAccessLevelAndNonNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(null, UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAllByNonNullAccessLevelAndNonNullTitleLike()
  {
    assertNotNull(repository.findAllByAccessLevelAndTitleLike(AccessLevel.PRIVATE, UUID.randomUUID().toString()));
  }
}
