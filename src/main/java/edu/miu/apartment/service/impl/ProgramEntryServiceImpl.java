package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.ProgramEntry;
import edu.miu.apartment.repository.ProgramEntryRepository;
import edu.miu.apartment.service.ProgramEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgramEntryServiceImpl implements ProgramEntryService {

    @Autowired
    private ProgramEntryRepository entryRepository;

    @Override
    public ProgramEntry createProgramEntry(ProgramEntry programEntry) throws Exception {
        if(programEntry==null){
            throw  new Exception("Invalid Null Entry");
        }
        //checking status before setting to current
        ProgramEntry pe = entryRepository.findByEntryStatus("Current");
        if(pe==null) {
            programEntry.setEntryStatus("Current");
        }else{
            //checking the date
            pe.setEntryStatus("Past Entry");
            ProgramEntry updatedEntry=entryRepository.save(pe);

        }

        if(programEntry.getEntryEndDate().before(programEntry.getEntryStartDate())){
            throw new Exception("Invalid Entry");
        }
        programEntry.setEntryStatus("Current");
        ProgramEntry entrySaved = entryRepository.save(programEntry);
        return entrySaved;
    }

    @Override
    public List<ProgramEntry> getAllProgramEntry() {
        return (List<ProgramEntry>) entryRepository.findAll();
    }

    @Override
    public ProgramEntry updateProgramEntry(ProgramEntry programEntry) throws Exception {
        ProgramEntry foundEntry = entryRepository.findByEntryId(programEntry.getEntryId());
        if(foundEntry==null){
            throw  new Exception("Invalid Null Entry");
        }
        return entryRepository.save(programEntry);
    }

    @Override
    public ProgramEntry findProgramEntryById(Long id) {
        return entryRepository.findByEntryId(id);
    }

    @Override
    public ProgramEntry getEntryByStatus(String status) {
        return entryRepository.findByEntryStatus(status);
    }
}
