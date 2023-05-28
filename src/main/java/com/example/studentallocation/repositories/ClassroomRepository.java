package com.example.studentallocation.repositories;

import com.example.studentallocation.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
//    List<Classroom> getAllClassrooms();
//    Classroom getClassroomById(Long id);
//    Classroom createClassroom(Classroom classroom);
//    Classroom updateClassroom(Long id, Classroom classroom);
//    void deleteClassroom(Long id);

    List<Classroom> findAll();

    Optional<Classroom> findById(Long id);

    Classroom save(Classroom classroom);

    void delete(Classroom classroom);
}
