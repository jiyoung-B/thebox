package com.team.thebox.service.admin;

import com.team.thebox.dto.MovieScheduleDTO;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface MovieScheduleService {

    List<MovieScheduleDTO> readMovieSchedule();
}
