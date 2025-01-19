package atl.academy.coursemanagementsystem.service;

import atl.academy.coursemanagementsystem.dto.SemesterDTO;
import atl.academy.coursemanagementsystem.dto.SemesterSaveDTO;
import atl.academy.coursemanagementsystem.dto.SemesterUpdateDTO;

import java.util.List;

public interface SemesterService {
    String addSemester(SemesterSaveDTO semesterSaveDTO);

    List<SemesterDTO> getAllSemesters();

    String updateSemester(SemesterUpdateDTO semesterUpdateDTO);

    boolean deleteSemester(int id);
}
