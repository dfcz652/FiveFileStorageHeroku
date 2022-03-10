package five.systems.FileStorage.services;

import five.systems.FileStorage.entity.Links;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadRepository extends JpaRepository<Links,Long> {

    @Query(value = "select * from links", nativeQuery = true)
    List<Links> findAll();

    Links save(Links links);

    @Query(value = "INSERT INTO links (id, path) VALUES (id_seq.nextval,'GG');", nativeQuery = true)
    List<Links> insertPath();
}
