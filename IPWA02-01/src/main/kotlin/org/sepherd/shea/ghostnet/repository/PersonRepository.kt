package org.sepherd.shea.ghostnet.repository

import org.sepherd.shea.ghostnet.db.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>