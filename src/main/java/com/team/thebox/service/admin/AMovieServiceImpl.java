package com.team.thebox.service.admin;

import com.team.thebox.dao.admin.AMovieDAO;
import com.team.thebox.dto.MovieDTO;
import com.team.thebox.dto.MovieRequestDto;
import com.team.thebox.model.Movie;
import com.team.thebox.model.MovieSchedule;
import com.team.thebox.model.MovieStillcut;
import com.team.thebox.model.Movielocation;
import com.team.thebox.utils.MovieUtils;
import com.team.thebox.utils.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service("admmvsrv")
@Transactional
public class AMovieServiceImpl implements AMovieService {
    @Autowired
    AMovieDAO amovdao;
    @Autowired
    MovieUtils movutils;
    @Autowired
    S3Uploader s3Uploader;
    private final String POST_IMAGE_DIR = "static";

    @Value("${image.directory}")
    private String imageDirectory;

    @Value("${video.directory}")
    private String videoDirectory;


    @Override
    public Map<String, Object> newMovies(Movie movie) {

        movie.setUuid(movutils.makeUUID());   // 식별코드 생성
        Long movno = amovdao.insertMovie(movie);    // 폼 데이터 디비에 저장

        // 첨부파일을 시스템에 저장할때 사용할 정보를 Map에 저장
        Map<String, Object> movinfo = new HashMap<>();
        movinfo.put("movno", movno);
        movinfo.put("uuid", movie.getUuid());



        return movinfo;

    }

    @Override
    public boolean newMovies2(Movie movie) {
        boolean result = false;
        if(amovdao.insertMovie(movie) > 0) {result = true;}
        return result;
    }

    @Override
    public boolean newMovieAttach(MultipartFile attach, Map<String, Object> movinfo) {
        // 첨부파일 업로드 처리
        //MovieAttach ma = movutils.processUpload(attach, movinfo);
        // 첨부파일 정보 디비에 저장
        //int movano = amovdao.insertMovieAttach(ma);

        //return (movano > 0) ? true : false;
        return true;
    }

    @Override
    public Object readOneMovie(Long movno) {
        return amovdao.selectOneMovie(movno);
    }

    @Override
    public Map<String, Object> readMovie(Integer cpg) {
        return amovdao.selectMovie(cpg - 1);
    }

    @Override
    public List<String> readMovieTitle(long movno) {
//        return movdao.selectMovieTitle(movno);
        return null;
    }

    @Override
    public List<Movie> readMovnoAndTitle() {
        return amovdao.selectMovnoAndTitle();
    }

    @Override
    public boolean newMovieSchedule(MovieSchedule movsch) {
        boolean result = false;
        if(amovdao.insertMovieSchedule(movsch) > 0) {result = true;}
        return result;
    }

    @Override
    public List<MovieSchedule> readSchedule() {
        return amovdao.selectMovieSchdule();
    }

    @Override
    public List<Integer> readBookedCnt() {
        return amovdao.selectBookedCnt();
    }

    @Override
    public Map<String, Object> readMovieSchedule(Long movno, Long schno) {

        return amovdao.selectScheduleList(movno, schno);
    }



    @Override
    public boolean modifyMovieByMovno(Movie existingmovie) {
        boolean result = false;

        System.out.println("변경내역"+existingmovie);

        if(amovdao.updateMovie(existingmovie) > 0 ){
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeMovieByMovno(Long movno) {
        boolean result = false;

        try{
            amovdao.deleteMovieByMovno(movno);
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
            result = false;
        }
        return result;



    }

    @Override
    public void registerMovieInfo(MovieDTO movieDTO) {
        // Movie 객체를 DTO로부터 생성하고 필요한 데이터 조작을 수행합니다.
        Movie movie = new Movie();
        movie.setMovgenre(movieDTO.getMovgenre());
        movie.setMovtitle(movieDTO.getMovtitle());
        movie.setMovdirector(movieDTO.getMovdirector());
        movie.setMovactor(movieDTO.getMovactor());
        movie.setMovreleasedate(movieDTO.getMovreleasedate());
        movie.setMovcountry(movieDTO.getMovcountry());
        movie.setMovgrade(movieDTO.getMovgrade());
        movie.setMovruntime(movieDTO.getMovruntime());
        movie.setMovdetail(movieDTO.getMovdetail());

        // 이미지 파일 처리
        MultipartFile movieMainPoster = movieDTO.getMovieMainPoster();
        if (movieMainPoster != null && !movieMainPoster.isEmpty()) {
            try {
                byte[] movieMainPosterData = movieMainPoster.getBytes();
                String imageUrl = saveFile(movieMainPosterData, "image");

            } catch (IOException e) {
                // 예외 처리
            }
        }

        MultipartFile[] stillcuts = movieDTO.getStillcuts();
        if (stillcuts != null && stillcuts.length > 0) {
            List<MovieStillcut> stillcutList = new ArrayList<>();
            for (MultipartFile stillcut : stillcuts) {
                if (stillcut != null && !stillcut.isEmpty()) {
                    try {
                        byte[] stillcutData = stillcut.getBytes();
                        String imageUrl = saveFile(stillcutData, "image");
                        MovieStillcut movieStillcut = new MovieStillcut();
                        //movieStillcut.setStillcuturl(imageUrl);
                        stillcutList.add(movieStillcut);
                    } catch (IOException e) {
                        // 예외 처리
                    }
                }
            }
            //movie.se.setStillcuts(stillcutList);
        }

//        MultipartFile[] videos = movieDTO.getVideos();
//        if (videos != null && videos.length > 0) {
//            List<MovieVideo> videoList = new ArrayList<>();
//            for (MultipartFile video : videos) {
//                if (video != null && !video.isEmpty()) {
//                    try {
//                        byte[] videoData = video.getBytes();
//                        String videoUrl = saveFile(videoData, "video");
//                        MovieVideo movieVideo = new MovieVideo();
//                        movieVideo.setVideourl(videoUrl);
//                        movieVideo.setMovie(movie);
//                        videoList.add(movieVideo);
//                    } catch (IOException e) {
//                        // 예외 처리
//                    }
//                }
//            }
//            movie.setVideos(videoList);
//        }

        // 리포지토리를 사용하여 영화를 저장합니다.
        amovdao.insertMovieInfo(movie);
    }
    @Override
    public Long createMovie(MovieRequestDto movieRequestDto) {
        //String movmainposterurl = s3Uploader.upload(movieRequestDto.getMovmainposter(), "mainposter");

        List<MovieStillcut> stillcuts = new ArrayList<>();
        List<MultipartFile> stillcutFiles = movieRequestDto.getStillcutslist();
        if (stillcutFiles != null && !stillcutFiles.isEmpty()) {
            for (MultipartFile stillcutFile : stillcutFiles) {
                String stillcuturl = s3Uploader.upload(stillcutFile, "stillcuts");
                //MovieStillcut stillcut = new MovieStillcut(stillcuturl);
                //stillcut.setMovie(movie); // Movie 객체와 연관시키기 위해 설정
                //stillcuts.add(stillcut);
            }
        }

        Movie movie = Movie.builder()
                .movgenre(movieRequestDto.getMovgenre())
                .movtitle(movieRequestDto.getMovtitle())
                .movdirector(movieRequestDto.getMovdirector())
                .movactor(movieRequestDto.getMovactor())
                .movreleasedate(movieRequestDto.getMovreleasedate())
                .movcountry(movieRequestDto.getMovcountry())
                .movgrade(movieRequestDto.getMovgrade())
                .movruntime(movieRequestDto.getMovruntime())
                .movdetail(movieRequestDto.getMovdetail())
                //.movmainposter(movmainposterurl)
                //.stillcuts(stillcuts)
                .videourl(movieRequestDto.getVideourl())
                .build();

        Long movno = amovdao.insertMovie(movie); // 영화 저장 및 movno 반환

        // Movie 객체의 movno를 사용하여 MovieStillcut의 movno 설정
//        for (MovieStillcut stillcut : stillcuts) {
//            stillcut.setMovie(movie);
//        }

        // MovieStillcut 엔티티 저장
        //amovdao.insertMovieStillcuts(stillcuts);
        return movno;

    }

    @Override
    public List<Movie> getAllMovies() {
        return amovdao.selectAllMovie();
    }

    @Override
    public Map<String, Object> newMovie(Movie movie) {
        movie.setUuid( movutils.makeUUID() );
        Long movno = amovdao.insertMovie(movie);
        Map<String, Object> minfo = new HashMap<>();
        minfo.put("movno", movno);
        minfo.put("uuid", movie.getUuid());

        return minfo;
    }

    @Override
    public boolean newMovieStillcut(List<MultipartFile> stillcuts, Map<String, Object> minfo) {
        // 이미지 파일 저장
        MovieStillcut ms = movutils.processUpload(stillcuts, minfo);
        // 썸내일 이미지 생성
        //movutils.makeThumbnail(ms, minfo.get("uuid"));
        // 첨부정보 디비 저장
        Long id = amovdao.insertMovieStillcut(ms);

        return (id > 0) ? true : false;

    }

    @Override
    public List<Movielocation> readLocation() {
        return amovdao.selectLocation();
    }


    private String saveFile(byte[] fileData, String fileType) throws IOException {
        String directory = fileType.equals("image") ? imageDirectory : videoDirectory;
        String fileName = UUID.randomUUID().toString();
        String filePath = directory + fileName;
        Files.write(Paths.get(filePath), fileData);
        return filePath;
    }

}

