<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="module/top2.jsp" />
<h1>Hello, ${name}!</h1>
<button id="btn">클릭</button>
<jsp:include page="module/bottom2.jsp" />
<script>
    $('#btn').click(function() {
        alert("연습");
    });
</script>
</body>
</html>