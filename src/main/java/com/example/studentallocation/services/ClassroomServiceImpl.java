package com.example.studentallocation.services;

import com.example.studentallocation.models.Classroom;
import com.example.studentallocation.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public ClassroomServiceImpl() {

        classroomRepository = null;
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return (Classroom) classroomRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Classroom not found with id: " + id));

    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom updateClassroom(Long id, Classroom classroom) {
        Classroom existingClassroom = getClassroomById(id);
        existingClassroom.setName(classroom.getName());
        existingClassroom.setCapacity(classroom.getCapacity());
        return classroomRepository.save(existingClassroom);
    }

    @Override
    public void deleteClassroom(Long id) {
        Classroom classroom = getClassroomById(id);
        classroomRepository.delete(classroom);
    }
}
