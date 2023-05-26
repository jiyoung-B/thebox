// 결제수단 선택 -> 설명
function showContent(radioId) {
    const kkoinst = document.getElementById('kkoinst');
    const accinst = document.getElementById('accinst');

    if (radioId === 'pwkakao') {
    kkoinst.style.display = 'block';
    accinst.style.display = 'none';
    } else if (radioId === 'pwacc') {
    kkoinst.style.display = 'none';
    accinst.style.display = 'block';
    }
}
