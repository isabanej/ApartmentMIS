package edu.miu.apartment.service;

import edu.miu.apartment.domain.ProgramEntry;

import java.util.List;

public interface ProgramEntryService {
    public ProgramEntry createProgramEntry(ProgramEntry programEntry) throws Exception;
    public List<ProgramEntry> getAllProgramEntry();
    public ProgramEntry updateProgramEntry(ProgramEntry programEntry) throws Exception;
    public ProgramEntry findProgramEntryById(Long id);
    public ProgramEntry getEntryByStatus(String status);
}
