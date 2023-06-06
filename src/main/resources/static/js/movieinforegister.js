// 영화 정보 등록


const movinfowritebtn = document.querySelector("#movinfowritebtn");
movinfowritebtn?.addEventListener('click', () => {
    const movinforegifrm = document.forms.movinforegifrm;
    if (movinforegifrm.movtitle.value === '') alert('제목을 작성하세요!');
    else if (movinforegifrm.movgenre.value === '') alert('장르를 작성하세요!');
    else {
        // 폼의 action과 enctype 설정
        movinforegifrm.action = "/management/movie/movieinforegister";
        movinforegifrm.enctype = "multipart/form-data";
        movinforegifrm.method = "post";
        movinforegifrm.submit();
    }
});