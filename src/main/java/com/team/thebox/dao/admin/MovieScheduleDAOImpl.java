package com.team.thebox.dao.admin;

import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieAttach;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.repository.BookedRepository;
import com.team.thebox.repository.MovieAttachRepository;
import com.team.thebox.repository.MovieRepository;
import com.team.thebox.repository.MovieScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository("movschdao")
//public class MovieScheduleDAOImpl implements MovieScheduleDAO {
//    @Autowired
//    MovieScheduleRepository movieScheduleRepository;
//
//
//
//}
