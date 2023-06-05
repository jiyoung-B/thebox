// 이메일 등록 & 변경
const mdemfrm = document.forms.mdemfrm;
const email3 = document.querySelector('#email3');
const flemailbtn = document.querySelector('#flemailbtn');
const ccemailbtn = document.querySelector('#ccemailbtn');

flemailbtn?.addEventListener('click', () => {
    if (mdemfrm.email1.value === '') alert('이메일이 공백입니다');
    else {
        mdemfrm.fillEmail.value = mdemfrm.email1.value + '@' + mdemfrm.email2.value;

        mdemfrm.method = 'post';
        mdemfrm.submit();
    }
})

email3?.addEventListener('change', () => {
    if (email3.value === '직접입력하기') {
        mdemfrm.email2.readOnly = false;
        mdemfrm.email2.value === '';
    } else if (email3.value !== '선택하세요') {
        mdemfrm.email2.readOnly = true;
        mdemfrm.email2.value = email3.value;
    }
})

ccemailbtn?.addEventListener('click', () => {
    mdemfrm.email1.value = '';
    mdemfrm.email2.value = '';
})


// 휴대폰 번호 변경
const mdphfrm = document.forms.mdphfrm;
const udphonebtn = document.querySelector('#udphonebtn');
const ccphonebtn = document.querySelector('#ccphonebtn');

udphonebtn?.addEventListener('click', () => {
    if (mdphfrm.tel2.value === '' || mdphfrm.tel3.value === '') alert('휴대폰 번호가 공백입니다');
    else {
        mdphfrm.changePhnum.value = mdphfrm.tel1.value + '-' + mdphfrm.tel2.value + '-' + mdphfrm.tel3.value;

        mdphfrm.method = 'post';
        mdphfrm.submit();
    }
})

ccphonebtn?.addEventListener('click', () => {
    mdphfrm.tel1.value = '';
    mdphfrm.tel2.value = '';
    mdphfrm.tel3.value = '';
})


// 비밀번호 변경
const mdpwfrm = document.forms.mdpwfrm;
const udpswdbtn = document.querySelector('#udpswdbtn');
const ccpswdbtn = document.querySelector('#ccpswdbtn');
const newPswd2 = document.querySelector('#newPswd2');
const repwdmsg = document.querySelector('#repwdmsg');

udpswdbtn?.addEventListener('click', () => {
    if (mdpwfrm.newPswd1.value === '' || newPswd2.value === '') alert('비밀번호가 공백입니다');
    else if (mdpwfrm.newPswd1.value.length < 6) alert('비밀번호는 6자 이상이어야 합니다');
    else if (mdpwfrm.newPswd1.value.length >= 16) alert('비밀번호는 16자 이하여야 합니다');
    else {
        mdpwfrm.method = 'post';
        mdpwfrm.submit();
    }
})

newPswd2?.addEventListener('blur', () => {
    let pmsg = '비밀번호가 서로 일치하지 않습니다';
    repwdmsg.style.color = 'lightsalmon';

    if(newPswd2.value === mdpwfrm.newPswd1.value) {
        pmsg = '비밀번호가 서로 일치합니다';
        repwdmsg.style.color = '#31708f';
    }
    repwdmsg.innerText = pmsg;
})

ccpswdbtn?.addEventListener('click', () => {
    mdpwfrm.newPswd1.value = '';
    newPswd2.value = '';
    repwdmsg.innerText = '';
})


// 회원 탈퇴
const delmembtn = document.querySelector('#delmembtn');
const chkdel = document.querySelector('#chkdel');
const delokfrm = document.forms.delokfrm;

delmembtn?.addEventListener('click', async () => {
    if (!chkdel.checked) alert("탈퇴하시기 전 유의사항을 확인해 주세요.");
    else {
        alert("탈퇴가 정상적으로 완료되었습니다.");
        location.href = '/logout';

        await (delokfrm.method = 'post');
        await (delokfrm.submit());
    }
})


// 예매 취소 & 취소 내역
const delbkbtn = document.querySelector('#delbkbtn');
const delbkfrm = document.forms.delbkfrm;
delbkbtn?.addEventListener('click', () => {
    delbkfrm.method = 'post';
    delbkfrm.submit();
});


// 프로필 사진
const profilefrm = document.forms.profilefrm;
const udpfbtn = document.querySelector('#udpfbtn');
udpfbtn?.addEventListener('click', () => {
    profilefrm.method = 'post';
    profilefrm.enctype = 'multipart/form-data';
    profilefrm.submit();
});