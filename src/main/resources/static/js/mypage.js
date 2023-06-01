// 이메일 변경
udemailbtn = document.querySelector('#udemailbtn');
udemailbtn?.addEventListener('click', () => {
    const mdemfrm = document.forms.mdemfrm;
    if (mdemfrm.newEmail.value === '') alert('이메일이 공백입니다');
    else {
        mdemfrm.method = 'post';
        mdemfrm.submit();
    }
})

// 휴대폰 번호 변경
udphonebtn = document.querySelector('#udphonebtn');
udphonebtn?.addEventListener('click', () => {
    const mdphfrm = document.forms.mdphfrm;
    if (mdphfrm.newPhnum.value === '') alert('휴대폰 번호가 공백입니다');
    else {
        mdphfrm.method = 'post';
        mdphfrm.submit();
    }
})

// 비밀번호 변경
udpswdbtn = document.querySelector('#udpswdbtn');
udpswdbtn?.addEventListener('click', () => {
    const mdpwfrm = document.forms.mdpwfrm;
    if (mdpwfrm.newPswd.value === '') alert('비밀번호가 공백입니다');
    else if (mdpwfrm.newPswd.value.length < 6) alert('비밀번호는 6자 이상이어야 합니다');
    else if (mdpwfrm.newPswd.value.length >= 16) alert('비밀번호는 16자 이하여야 합니다');
    else {
        mdpwfrm.method = 'post';
        mdpwfrm.submit();
    }
})

// 회원 탈퇴
delmembtn = document.querySelector('#delmembtn');
delmembtn.addEventListener('click', () => {
    alert("정말로?");
})