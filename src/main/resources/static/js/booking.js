// 카카오 페이
paybtn = document.querySelector('#paybtn');
paybtn?.addEventListener('click', () => {
    // 날짜 관련 번호
    today = new Date();

    var year = (today.getFullYear()).toString();
    var yearnum = year[2] + year[3];

    var month = ('0' + (today.getMonth() + 1)).slice(-2);

    var day = ('0' + today.getDate()).slice(-2);

    var dateString = year + '-' + month  + '-' + day;

    fstnum = yearnum + month;

    // cinematype 관련 번호
    cinum = 0;
    cinematype = "롯데시네마";
    if (cinematype = "CGV") cinum = 716;
    else if (cinematype = "메가박스") cinum = 768;
    else if (cinematype = "롯데시네마") cinum = 694;

    // 고유 랜덤 번호
    ranuniqnum = Math.trunc(Math.random() * 89) + 10;

    lstnum = day + ranuniqnum;
    
    console.log("예매번호 : " + fstnum + "-" + cinum + "-" + lstnum);
})


const mkbknumbtn = () => {
    // 날짜 관련 번호
    today = new Date();

    var year = (today.getFullYear()).toString();
    var yearnum = year[2] + year[3];

    var month = ('0' + (today.getMonth() + 1)).slice(-2);

    var day = ('0' + today.getDate()).slice(-2);

    var dateString = year + '-' + month  + '-' + day;

    fstnum = yearnum + month;

    // cinematype 관련 번호
    cinum = 0;
    cinematype = "롯데시네마";
    if (cinematype = "CGV") cinum = 716;
    else if (cinematype = "메가박스") cinum = 768;
    else if (cinematype = "롯데시네마") cinum = 694;

    // 고유 랜덤 번호
    ranuniqnum = Math.trunc(Math.random() * 89) + 10;

    lstnum = day + ranuniqnum;

    console.log("예매번호 : " + fstnum + "-" + cinum + "-" + lstnum);
}