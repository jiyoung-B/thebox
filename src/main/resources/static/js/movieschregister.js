// 새글쓰기
const schwritebtn = document.querySelector("#schwritebtn");
schwritebtn?.addEventListener('click', () => {
    const schregifrm = document.forms.schregifrm;
    if (schregifrm.movno.value === '') alert('영화를 선택하세요!');
    else if (schregifrm.ciplace.value === '') alert('상영관을 선택하세요!');
    else if (schregifrm.odate.value === '') alert('상영날짜를 입력하세요!');
    else {
        schregifrm.method = 'post';
        schregifrm.submit();
    }
});