//댓글쓰기
const rpnewbtn = document.querySelector("#rpnewbtn");
rpnewbtn?.addEventListener('click', () => {
    const rpfrm = document.forms.rpfrm;
    if (rpfrm.reply.value === '') alert('댓글을 작성하세요!');
    else if (rpfrm.userid.value === '') alert('작성자 없어요!');
    else if (rpfrm.movno.value === '') alert('본문글번호 없어요!');
    else if (rpfrm.star.value === '') alert('별점을 선택해주세요!');
    else {
        rpfrm.method = 'post';
        rpfrm.action = '/movie/replyok';
        rpfrm.submit();
    }
});