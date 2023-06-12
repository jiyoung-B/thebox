package com.team.thebox.utils;

import com.team.thebox.model.MovieStillcut;
import com.team.thebox.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("movutils")
public class MovieUtils {
    @Autowired
    MovieRepository amovdao;

    // 이미지 파일 저장 위치
    @Value("${saveImgDir}")
    private String saveImgDir;

    public String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
        uuid = uuid.replace("-", "")
                .replace(":", "")
                .replace(".", "");

        return uuid;
    }

    public MovieStillcut processUpload(List<MultipartFile> stillcuts, Map<String, Object> minfo) {

        // 이미지 첨부파일명과 사이즈는 먼저, 리스트로 저장한뒤 문자열로 변환
        // 업로드할 파일 정보 취득
        MovieStillcut ms = new MovieStillcut();
        ms.setMovno((Long) minfo.get("movno"));
        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        // 첨부된 파일들에 대한 반복처리
        for (MultipartFile stillcut : stillcuts) {
            String fname = stillcut.getOriginalFilename();

            // 파일 확장자와 크기 추출
            int pos = fname.lastIndexOf(".") + 1;
            String ext = fname.substring(pos);
            String fsize = (stillcut.getSize() / 1024) + "";

            // 저장시 사용할 파일이름 생성
            // 파일이름 형식 : 파일이름UUID.확장자
            String savefname = fname.substring(0, pos - 1);
            String fullname = savefname + minfo.get("uuid") + "." + ext;
            savefname = saveImgDir + fullname;

            try {
                // 첨부파일을 파일시스템에 저장
                stillcut.transferTo(new File(savefname));

                // 첨부파일 정보를 리스트에 저장
                fnames.add(fullname);
                fsizes.add(fsize);
                System.out.println(
                        fullname + "," + fsize + ',' + savefname);
            } catch (Exception ex) {
                System.out.println("업로드중 오류발생!!");
                ex.printStackTrace();
            }
        } // for

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트변수) : 요소1;요소2;요소3
        ms.setFname(String.join(";", fnames));
        ms.setFsize(String.join(";", fsizes));
        System.out.println(ms.getFname() + " " + ms.getFsize());

        return ms;
    }


    public MovieStillcut processUpdate(List<MultipartFile> stillcuts, Map<String, Object> minfo) {
        // 이미지 첨부파일명과 사이즈는 먼저, 리스트로 저장한 뒤 문자열로 변환
        // 업로드할 파일 정보 취득
        MovieStillcut ms = new MovieStillcut();
        ms.setMovno((Long) minfo.get("movno"));
        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        // 첨부된 파일들에 대한 반복 처리
        for (MultipartFile stillcut : stillcuts) {
            // 이미지 파일 업데이트 처리 로직 추가
            if (!stillcut.isEmpty()) {
                // 기존 이미지 파일 삭제
                MovieStillcut existingStillcut = amovdao.getMovieStillcutByMovno((Long) minfo.get("movno"));
                if (existingStillcut != null) {
                    deleteExistingStillcut(existingStillcut);
                }
            }

            String fname = stillcut.getOriginalFilename();
            // 파일 확장자와 크기 추출
            int pos = fname.lastIndexOf(".") + 1;
            String ext = fname.substring(pos);
            String fsize = (stillcut.getSize() / 1024) + "";

            // 저장시 사용할 파일이름 생성
            // 파일이름 형식 : 파일이름UUID.확장자
            String savefname = fname.substring(0, pos - 1);
            String fullname = savefname + minfo.get("uuid") + "." + ext;
            savefname = saveImgDir + fullname;

            try {
                // 첨부파일을 파일시스템에 저장
                stillcut.transferTo(new File(savefname));

                // 첨부파일 정보를 리스트에 저장
                fnames.add(fullname);
                fsizes.add(fsize);
                System.out.println(
                        fullname + "," + fsize + ',' + savefname);
            } catch (Exception ex) {
                System.out.println("업로드중 오류발생!!");
                ex.printStackTrace();
            }
        }

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트변수) : 요소1;요소2;요소3
        ms.setFname(String.join(";", fnames));
        ms.setFsize(String.join(";", fsizes));
        System.out.println(ms.getFname() + " " + ms.getFsize());

        return ms;
    }

    private void deleteExistingStillcut(MovieStillcut stillcut) {
        // 기존 이미지 파일 삭제 로직 구현
        String[] filenames = stillcut.getFname().split(";");
        for (String filename : filenames) {
            String savefname = saveImgDir + filename;
            File file = new File(savefname);
            if (file.exists()) {
                file.delete();
            }
        }
    }


    public void makeThumbnail(MovieStillcut ms, Object uuid) {

    }

    public Long insertGalAttach(MovieStillcut ms) {
        return 0L;
    }

    public MovieStillcut registerNewMovieStillcuts(List<MultipartFile> stillcuts, Map<String, Object> minfo) {
        Long movno = (Long) minfo.get("movno");
        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        for (MultipartFile stillcut : stillcuts) {
            String fname = stillcut.getOriginalFilename();
            int pos = fname.lastIndexOf(".");
            String ext = fname.substring(pos + 1);
            String savefname = fname.substring(0, pos);
            String fullname = savefname + minfo.get("uuid") + "." + ext;
            String savePath = saveImgDir + fullname;

            try {
                stillcut.transferTo(new File(savePath));
                fnames.add(fullname);
                fsizes.add(String.valueOf(stillcut.getSize()));
            } catch (IOException e) {
                // 예외 처리
                System.out.println("업로드중 오류 발생!");
                e.printStackTrace();

            }
        }

        String joinedFnames = String.join(";", fnames);
        String joinedFsizes = String.join(";", fsizes);

        MovieStillcut ms = new MovieStillcut();
        ms.setMovno(movno);
        ms.setFname(joinedFnames);
        ms.setFsize(joinedFsizes);
        return ms;


    }

}
