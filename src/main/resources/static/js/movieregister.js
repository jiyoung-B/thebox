// 상영 스케줄 업데이트
const movwritebtn = document.querySelector("#movwritebtn");
movwritebtn?.addEventListener('click', () => {
    const movregifrm = document.forms.movregifrm;
    if (movregifrm.movtitle.value === '') alert('제목을 작성하세요!');
    else if (movregifrm.movgenre.value === '') alert('장르를 작성하세요!');
    else {
        // movregifrm.action = "/management/movie/register";
        // movregifrm.method = "post";
        // movregifrm.submit();
        movregifrm.method = 'post';
        movregifrm.enctype = "multipart/form-data";
        movregifrm.submit();
    }
});