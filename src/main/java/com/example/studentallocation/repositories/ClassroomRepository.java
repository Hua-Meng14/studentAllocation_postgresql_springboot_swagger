package com.example.studentallocation.repositories;

import com.example.studentallocation.models.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepository {
    List<Classroom> getAllClassrooms();
    Classroom getClassroomById(Long id);
    Classroom createClassroom(Classroom classroom);
    Classroom updateClassroom(Long id, Classroom classroom);
    void deleteClassroom(Long id);

    List<Classroom> findAll();

    Optional<Object> findById(Long id);

    Classroom save(Classroom classroom);

    void delete(Classroom classroom);
}
