package com.journal.journalApp.repository;

import com.journal.journalApp.entity.ConfigJournalAppEntry;
import com.journal.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntry, ObjectId> {
   
}

// bean will call repo. Then repo will call mongo