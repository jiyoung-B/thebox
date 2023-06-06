// 영화 정보 등록


const movinfowritebtn = document.querySelector("#movinfowritebtn");
movinfowritebtn?.addEventListener('click', () => {
    const movieinforegifrm = document.forms.movieinforegifrm;
    if (movieinforegifrm.movtitle.value === '') alert('제목을 작성하세요!');
    else if (movieinforegifrm.movgenre.value === '') alert('장르를 작성하세요!');
    else if (movieinforegifrm.movmainposter.value === '') alert('영화포스트를 입력해주세요!');
    else {
        // 폼의 action과 enctype 설정
        movieinforegifrm.action = "/management/movieinfo/register";
        movieinforegifrm.enctype = "multipart/form-data";
        movieinforegifrm.method = "post";
        movieinforegifrm.submit();
    }
});