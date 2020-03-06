package edu.miu.apartment.controller;

import edu.miu.apartment.domain.ProgramEntry;
import edu.miu.apartment.service.ProgramEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class ProgramEntryController {

    @Autowired
    private ProgramEntryService programEntryService;

    @RequestMapping(value="/createEntry", method = RequestMethod.POST)
    public @ResponseBody ProgramEntry createEntry(@Valid @RequestBody ProgramEntry programEntry) throws Exception {
        return  programEntryService.createProgramEntry(programEntry);
    }
}
