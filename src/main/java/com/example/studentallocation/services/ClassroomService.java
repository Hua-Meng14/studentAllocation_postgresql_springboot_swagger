package com.example.studentallocation.services;

import com.example.studentallocation.models.Classroom;
import com.example.studentallocation.repositories.ClassroomRepository;

import java.util.List;
import java.util.Optional;

public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Classroom updateClassroom(Long classroomId, Classroom updatedClassroom) {
        Classroom classroom = getClassroomById(classroomId);
        classroom.setName(updatedClassroom.getName());
        classroom.setCapacity(updatedClassroom.getCapacity());
        return classroomRepository.save(classroom);
    }

    private Classroom getClassroomById(Long classroomId) {
        Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
        return classroomOptional.orElseThrow(() -> new IllegalArgumentException("Classroom not found"));
    }

    public void deleteClassroom(Long classroomId) {
        classroomRepository.deleteById(classroomId);
    }
}
