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

//댓글 수정 모달 띄우기
let modal = null;
const showComment =  (rpno,reply,star) => {
    const frpno = document.querySelector("#rpno");
    const freply = document.querySelector("#comment");
    const modModal = document.querySelector("#modModal");
    const fstar = modModal.querySelector(`input[name="star"][value="${star}"]`);


    frpno.value = rpno;
    freply.value = reply;
    fstar.checked = true;

    let mymodal = null; // 대댓글 모달창 띄우기
    try{
        mymodal = new bootstrap.Modal(modModal,{});
        modal = mymodal;
    } catch (e){}

    mymodal.show();
};

//댓글 수정
const modbtn = document.querySelector("#modbtn");
modbtn?.addEventListener('click', () => {
    const modfrm = document.forms.modfrm;
    if (modfrm.reply.value === '') alert('댓글을 작성하세요!');
    else if (modfrm.userid.value === '') alert('작성자 없어요!');
    else if (modfrm.movno.value === '') alert('본문글번호 없어요!');
    else if (modfrm.star.value === '') alert('별점을 선택해주세요!');
    else {
        modfrm.method = 'post';
        modfrm.action = '/movie/modify';
        modfrm.submit();
    }
});

//댓글 삭제
function deleteComment(rpno,movno){
    if (confirm('삭제할까??')== true)
        location.href="/movie/delete?rpno=" + rpno + "&movno=" + movno;
    else return;
}


const upup = document.querySelector("#upup");
upup?.addEventListener('click', () => {
    location.href="/movie/readStar?";
});

function showCurrentMovies() {
    // 모든 영화 요소를 가져옵니다.
    var movies = document.getElementsByClassName('col-sm-3');

    // 오늘 날짜를 가져옵니다.
    var today = new Date();

    // 각 영화 요소에 대하여 반복합니다.
    for (var i = 0; i < movies.length; i++) {
        var movie = movies[i];

        // 영화의 개봉일을 가져옵니다.
        var releaseDate = new Date(movie.getAttribute('data-release-date'));

        // 개봉일이 오늘보다 이전인 경우에만 보여줍니다.
        if (releaseDate < today) {
            movie.style.display = 'block';
        } else {
            movie.style.display = 'none';
        }
    }
}