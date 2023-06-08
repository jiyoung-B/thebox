//  상영스케줄 업데이트
const schupdatebtn = document.querySelector("#schupdatebtn");
schupdatebtn?.addEventListener('click', () => {
    const scheditfrm = document.forms.scheditfrm;
    if (scheditfrm.movno.value === '') alert('영화를 선택하세요!');
    else if (scheditfrm.ciplace.value === '') alert('상영관을 선택하세요!');
    else if (scheditfrm.odate.value === '') alert('상영날짜를 입력하세요!');
    else {
        console.log(scheditfrm.movno.value); // movno 값을 콘솔에 출력
        console.log(scheditfrm.ciplace.value); // movno 값을 콘솔에 출력
        scheditfrm.method = 'post';
        scheditfrm.submit();
    }
});