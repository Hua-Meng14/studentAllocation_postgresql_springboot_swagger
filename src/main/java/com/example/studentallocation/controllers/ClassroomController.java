package com.example.studentallocation.controllers;

import com.example.studentallocation.models.Classroom;
import com.example.studentallocation.services.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/")
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @PostMapping("/")
    public Classroom createClassroom(@RequestBody Classroom classroom) {
        return classroomService.createClassroom(classroom);
    }

    @PutMapping("/{classroomId}")
    public Classroom updateClassroom(@PathVariable Long classroomId, @RequestBody Classroom updatedClassroom) {
        return classroomService.updateClassroom(classroomId,updatedClassroom);
    }

    @DeleteMapping("/{classroomId}")
    public void deleteClassroom(@PathVariable Long classroomId) {
        classroomService.deleteClassroom(classroomId);
    }


}
