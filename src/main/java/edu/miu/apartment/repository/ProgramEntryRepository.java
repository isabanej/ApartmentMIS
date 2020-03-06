package edu.miu.apartment.repository;

import edu.miu.apartment.domain.ProgramEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramEntryRepository extends CrudRepository<ProgramEntry,Long> {
    public ProgramEntry findByEntryId(Long id);
    public ProgramEntry findByEntryStatus(String status);
}
