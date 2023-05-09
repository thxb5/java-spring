document.addEventListener('DOMContentLoaded', function() {
    // 전체 선택 체크박스
    const checkAll = document.querySelector('.checkbox_all');

    // 게시물 체크박스들
    const checkItems = document.querySelectorAll('.checkbox_item');

    // 전체 선택 체크박스 클릭 이벤트 리스너 추가
    checkAll.addEventListener('click', function () {
        checkItems.forEach((item) => {
            item.checked = checkAll.checked;
        });
    });
});