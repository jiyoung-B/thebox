// 스틸컷 첨부 조건 검사
const checkAttachs = () => {
    let checkOk = true;
    const stillcuts = document.querySelector("#stillcuts");

    // 이미지 첨부파일이 하나 이상이라면
    if ('files' in stillcuts && stillcuts.files.length > 0) {
        // 첨부파일들이 이미지인지 검사
        for (stillcut of stillcuts.files) {
            //console.log(attach.name + ',' + attach.type + ',' + attach.size);
            // 이미지 파일의 MIME 형식
            // image/jpg,image/jpeg,image/png,image/gif
            if (!stillcut.type.startsWith('image')) {
                alert('첨부하려는 파일은 반드시 이미지여야 합니다!');
                checkOk = false;
            }
        }
    } else {
        alert('하나 이상의 이미지를 선택하세요!!');
        checkOk = false;
    }

    return checkOk;
};

const writebtn = document.querySelector("#writebtn");
writebtn?.addEventListener('click', () => {
    const movieinforegifrm = document.forms.movieinforegifrm;
    if (movieinforegifrm.movtitle.value === '') alert('제목을 작성하세요!');
    else if (movieinforegifrm.movgenre.value === '') alert('장르를 작성하세요!');
    else if (movieinforegifrm.stillcuts.value === '') alert('영화포스트를 입력해주세요!');
    else if (!checkAttachs()) alert('이미지를 첨부 조건 불일치!');
    else {
        movieinforegifrm.method = "post";
        movieinforegifrm.enctype = "multipart/form-data";
        movieinforegifrm.submit();
    }
});