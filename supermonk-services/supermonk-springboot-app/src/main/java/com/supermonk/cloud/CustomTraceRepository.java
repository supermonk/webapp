package com.supermonk.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomTraceRepository extends InMemoryAuditEventRepository {

    private static final Logger log = LoggerFactory.getLogger(CustomTraceRepository.class);

    public CustomTraceRepository() {
    	log.info("200");
        super.setCapacity(200);
    }

   
}