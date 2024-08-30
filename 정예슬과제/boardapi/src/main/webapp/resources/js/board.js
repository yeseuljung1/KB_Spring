// 삭제 버튼의 click 이벤트 핸들러
//클래스가 delete인 요소를 찾아서 클릭 이벤트에 함수 연결

document.querySelector('.delete').onclick = function() {
    // confirm은 사용자한테  메세지를 주고 확인 여부를 boolean으로 받아온다
    if(!confirm('정말 삭제할까요?')) return;
    document.getElementById('deleteForm').submit();
}