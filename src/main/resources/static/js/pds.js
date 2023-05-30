// 새글쓰기
const writebtn = document.querySelector("#writebtn");
writebtn?.addEventListener('click', () => {
    const pdsfrm = document.forms.pdsfrm;
    if (pdsfrm.movtitle.value === '') alert('제목을 작성하세요!');
    else if (pdsfrm.movdetail.value === '') alert('본문을 작성하세요!');
    else {
        pdsfrm.method = 'post';
        pdsfrm.enctype = "multipart/form-data";
        pdsfrm.submit();
    }
});