// header 로고 클릭 이벤트
let logo = document.querySelector('#logo');
logo?.addEventListener('click',  () => {
    location.href = '/';
});


// --------------------------------------------- login
const loginbtn = document.querySelector('#loginbtn');
const lgoutbtn = document.querySelector('#lgoutbtn');
const lgnfrm = document.forms.lgnfrm;
loginbtn?.addEventListener('click', (e) => {
    if(lgnfrm.userid.value === '') alert('아이디를 입력해주세요!!');
    else if(lgnfrm.passwd.value === '') alert('비밀번호를 입력하세요!!');
    else{
        lgnfrm.method = 'post';
        lgnfrm.action = '/login';
        lgnfrm.submit();
    }
})

lgoutbtn?.addEventListener('click', () => {
    location.href = '/logout';
})



// 영상 재생
const indexMoviePlayStop = document.querySelector('#indexMoviePlayStop');
const indexMovie = document.querySelector('#indexMovie');
indexMoviePlayStop?.addEventListener('click', () => {
    if (indexMovie.paused) indexMovie.play();
    else if (indexMovie.played) indexMovie.pause();
})

function showPlayNStop() {
    if (indexMovie.paused) {
        indexMoviePlayStop.innerHTML = '<i class="fa-solid fa-pause" style="color: #343434; margin-left: 9px;"></i>';
    } else if (indexMovie.played) {
        indexMoviePlayStop.innerHTML = '<i class="fa-solid fa-play" style="color: #343434; margin-left: 9px;"></i>';
    }
}


// 영상 소리
const indexMovieSound = document.querySelector('#indexMovieSound');
indexMovieSound?.addEventListener('click', () => {
    if (indexMovie.muted) indexMovie.muted = false;
    else if (indexMovie.muted === false) indexMovie.muted = true;
})

function showMovieSound() {
    if (indexMovie.muted === false) {
        indexMovieSound.innerHTML = '<i class="fa-solid fa-volume-xmark" style="color: #343434; margin-left: 5px;"></i>';
    } else if (indexMovie.muted) {
        indexMovieSound.innerHTML = '<i class="fa-solid fa-volume-high" style="color: #343434; margin-left: 5px;"></i>';
    }
}
=======
let signupbtn = document.querySelector('#signupbtn');
signupbtn?.addEventListener('click', () => {
    location.href = "/join/signup";
});

