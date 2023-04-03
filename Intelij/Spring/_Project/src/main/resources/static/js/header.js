var idValue;
var pwValue;


    $(function(){
        $("#login_btn").click(function(){
            $(".modal").fadeIn();
        });

        $("#modal_closebtn").click(function(){
            $(".modal").fadeOut();
        })
    })


//로그인 버튼 클릭시 메소드
function idCheck() {
    idValue = $('#insertId').val();
    pwValue = $('#insertPw').val();


    if(idValue === ""){
        alert("아이디를 입력해주세요.")
        $('#insertId').focus();
        return false;
    } else if(pwValue === "") {
        alert("비밀번호를 입력해주세요.")
        $('#insertPw').focus();
        return false;
    } else {
        $.ajax({
            url:"logincheck.do",
            type:"post",
            data:{"userId":idValue, "userPw":pwValue},
            success: loca,
            error: function() {
                alert('error')
            }
        })
    }
    function loca(data) {
        if(data === "") {
            alert("아이디 또는 비밀번호를 확인해주세요.")
            return false;
        } else {
            window.location.reload();
            alert("로그인 성공")
        }
    }
}



//마이페이지 클릭시 로그인 확인
function mypageCheck() {
    if(user == null) {
        alert('먼저 로그인해주세요.')
        return false;
    } else {
        location.href="/mypage";
        return true;
    }
}