package com.example.studentallocation.services;

import com.example.studentallocation.models.Classroom;

import java.util.List;

public interface ClassroomService {
    List<Classroom> getAllClassrooms();
    Classroom getClassroomById(Long id);
    Classroom createClassroom(Classroom classroom);
    Classroom updateClassroom(Long id, Classroom classroom);
    void deleteClassroom(Long id);
}
