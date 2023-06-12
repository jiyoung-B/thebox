// function showDetail(movno) {
//     let screenWidth = window.innerWidth || document.documentElement.clientWidth||document.body.clientWidth;
//     let screenHeight = window.innerHeight || document.documentElement.clientHeight||document.body.clientHeight;
//
//     let width = Math.round(screenWidth / 2);
//     let height = Math.round(screenHeight / 2);
//     console.log("쇼디테일" + movno);
//     window.open('/management/movieinfo/view?movno=' + movno,
//         '_blank', 'width=' + width + ',height=' + height);
//
// }

function showDetail(movno) {
    let screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    let screenHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;

    let width = 810;
    let height = "auto";
    console.log("쇼디테일" + movno);
    window.open('/management/movieinfo/view?movno=' + movno, '_blank', 'width=' + width + ',height=' + height);
}