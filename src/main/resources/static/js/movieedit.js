// 등록 영화 업데이트
const movupdatebtn = document.querySelector("#movupdatebtn");
movupdatebtn?.addEventListener('click', () => {
    const moveditfrm = document.forms.moveditfrm;
    if (moveditfrm.movtitle.value === '') alert('영화를 선택하세요!');
    else if (moveditfrm.movgenre.value === '') alert('장르를 입력하세요!');
    else {
        console.log('무비넘버'+moveditfrm.movno.value); // movno 값을 콘솔에 출력
        console.log('어태취'+moveditfrm.stillcuts.value); // movno 값을 콘솔에 출력
        console.log('무비포스터'+moveditfrm.movPosters.value);
        moveditfrm.method = 'post';
        moveditfrm.enctype = "multipart/form-data";
        moveditfrm.submit();
    }
});