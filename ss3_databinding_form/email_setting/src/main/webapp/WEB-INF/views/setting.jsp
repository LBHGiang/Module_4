<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Email Settings</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3 style="color: green">${message}</h3>
<form:form method="POST" action="update" modelAttribute="setting">
    <fieldset>
        <legend>Email Settings
            <table>
                <tr>
                    <td><form:label path="language">Language: </form:label></td>
                    <td><form:select path="language" items="${languages}"/>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="pageSize">Page Size: </form:label></td>
                    <td>Show <form:select path="pageSize" items="${pageSizes}"/> emails per page</td>
                </tr>
                <tr>
                    <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
                    <td><form:checkbox path="spamsFilter" value="1"/>Enable spams filter</td>
                </tr>
                <tr>
                    <td><form:label path="signature">Signature: </form:label></td>
                    <td><form:textarea path="signature"/></td>
                </tr>
                <tr>
                    <td></td>       
                    <td><form:button type="submit">Update</form:button>
                        <a href="/setting">Cancel</a>
                    </td>
                </tr>
            </table>
        </legend>
    </fieldset>
</form:form>
</body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</html>