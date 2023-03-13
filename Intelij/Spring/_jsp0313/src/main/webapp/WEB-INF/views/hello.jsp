<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-03-13 0013
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<jsp:include page="module/top2.jsp" />
    <%--<h1>Hello, <%= request.getParameter("name") %>!</h1>--%>
    <h1>Hello, ${name}!</h1>
    <input type="button" value="별점주기" class="btn btn-primary">
<jsp:include page="module/bottom2.jsp" />
<script>
    const modal = new bootstrap.Modal(document.querySelector(".modal"));
    var grade = 0;
    $('.starrr').starrr({
        rating: grade,
        change: function (e, value) {
            if(value) {
                console.log(value);
                grade = value;
            }
        }
    })

    $('.savBtn').click(function () {
        var idVal = 1000;
        var contVal = '연습';
        var data = {id : idVal, grade : grade, content : contVal};
        $.ajax({
            url:'/review',
            type: "POST",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            success: function(result) {
                console.log("result: " + result);
                //self.location.reload();
            },
            error: function (e) {
                console.log(e);
            }
        });
        modal.hide();
    })

    $('.btn').click(function () {
        modal.show();
    })


    // document.querySelector(".savBtn").addEventListener("click", function(e) {
    //     console.log("savBtn");
    // });
</script>
</body>
</html>

