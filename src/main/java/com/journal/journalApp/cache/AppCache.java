package com.journal.journalApp.cache;

import com.journal.journalApp.entity.ConfigJournalAppEntry;
import com.journal.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AppCache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    private Map<String, String> appCache;

    @PostConstruct
    public void init() {
//check
        List<ConfigJournalAppEntry> all = configJournalAppRepository.findAll();
        appCache = null;
    }
}
