

// --------------------------------------------- signup
const joinfrm = document.forms.joinfrm;
const joinbtn = document.querySelector('#joinbtn');
const email3 = document.querySelector('#email3');
const userid = document.querySelector('#userid');
const uidmsg = document.querySelector('#uidmsg');
const pwdmsg = document.querySelector('#pwdmsg');
const repasswd = document.querySelector('#repasswd');

let modal = null;

joinbtn?.addEventListener('click', () => {
    if(joinfrm.userid.value == '') alert('아이디를 입력하세요!!');
    else if(joinfrm.name.value == '') alert('이름을 입력하세요!!');
    else if(joinfrm.passwd.value == '') alert('비밀번호를 입력하세요!!');
    else if(joinfrm.repasswd.value == '') alert('비밀번호를 확인을 입력하세요!!');
    else if(joinfrm.repasswd.value != joinfrm.passwd.value) alert('비밀번호가 서로 일치하지 않아요!!');
    else if(joinfrm.email1.value == '' || joinfrm.email2.value == '') alert('이메일을 확인하세요!!');
    else if(joinfrm.tel2.value == '' || joinfrm.tel3.value == '') alert('전화번호를 확인하세요!!');
    //else if(grecaptcha.getResponse() === '') alert('자동가입방지를 확인하세요!!');
    else if(joinfrm.checkuid.value === 'no') alert('아이디 중복 체크하세요!!');
    else{
        joinfrm.email.value = joinfrm.email1.value + '@' + joinfrm.email2.value;
        joinfrm.phone.value = joinfrm.tel1.value + '-' + joinfrm.tel2.value + '-' + joinfrm.tel3.value;

        joinfrm.method = 'post';
        joinfrm.action = '/join/signup';
        joinfrm.submit();
    }
});


email3?.addEventListener('change', () => {
    if (email3.value === '직접입력하기'){
        joinfrm.email2.readOnly = false;
        joinfrm.email2.value = '';
    }else if(email3.value !== '선택하세요'){
        joinfrm.email2.readOnly = true;
        joinfrm.email2.value = email3.value;

    }
});


const styleCheckuid = (chkuid) => {
    let msg = '사용 불가능한 아이디입니다!!';
    uidmsg.style.color = 'red';
    joinfrm.checkuid.value = 'no';

    if(chkuid === '0'){
        msg = '사용 가능한 아이디 입니다!!';
        uidmsg.style.color = 'blue';
        joinfrm.checkuid.value = 'yes';

    }
    uidmsg.innerText = msg;
};

userid?.addEventListener('blur', () =>{
    if(userid.value === ''){
        //alert('중복 검색할 아이디를 입력하세요!!');
        uidmsg.innerText = '6~16 자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다';
        uidmsg.style.color = 'gray';
        joinfrm.checkuid.value = 'no';

        return;
    }
    const url = '/join/checkuid?uid=' + userid.value;
    fetch(url).then(response => response.text())
        .then(text => styleCheckuid(text));

});

repasswd?.addEventListener('blur', () => {
    let pmsg = '비밀번호가 서로 일치하지 않습니다!!';
    pwdmsg.style.color = 'red';
    if(repasswd.value === joinfrm.passwd.value){
        pmsg = '비밀번호는 서로 일치합니다!!';
        pwdmsg.style.color = 'blue';
    }
    pwdmsg.innerText = pmsg;
});

// --------------------------------------------- joinok
const go2index = document.querySelector('#go2index');
go2index?.addEventListener('click', () => {
    location.href = '/';
});