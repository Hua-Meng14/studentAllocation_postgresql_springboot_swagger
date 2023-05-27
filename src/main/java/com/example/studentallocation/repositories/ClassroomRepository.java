package com.example.studentallocation.repositories;

import com.example.studentallocation.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class ClassroomRepository implements JpaRepository<Classroom, Long> {

}
