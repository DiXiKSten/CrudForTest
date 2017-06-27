<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Users</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
        .table1 {
            width: 100%;
            border-collapse: collapse;
        }

        .thead1 {
            background: #f5e8d0;
        }

        .td1, .th1 {
            padding: 5px;
            border: 1px solid #333;
        }

        .container {
            width: 30%;
            margin-left: 5%;
            margin-right: 5%;
            margin-top: 2%;
            height: 95%;
        }

        .button24 {
            display: inline-block;
            color: black;
            font-size: 80%;
            font-weight: 600;
            text-decoration: none;
            user-select: none;
            padding: .25em .5em;
            outline: none;
            border: 1px solid rgb(250, 172, 17);
            border-radius: 7px;
            background: rgb(255, 212, 3) linear-gradient(rgb(255, 212, 3), rgb(248, 157, 23));
            box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0), inset 0 1px 2px rgba(0, 0, 0, 0), inset 0 0 0 60px rgba(255, 255, 0, 0);
        }
    </style>

</head>
<body bgcolor="#fff8dc">

<div class="container">

    <a href="/fill">Add 5 Random User</a> <br>

    <h2>Users</h2>



    <div>
        <table>
            <tr>
                <td>
                    <form:form action="/" method="get"><input class="button24" type="submit" size="XSmall" value="Show All"/>
                    </form:form>
                </td>
                <td width="140">
                </td>
                <td>
                    <form action="/search/">
                        <label for="name">Search by Name</label>
                        <input type="name" id="id" name="name" placeholder=" "/>
                        <input type="submit" value="Search"/>
                    </form>
                </td>
            </tr>
        </table>
    </div>

    <table class="table1">
        <thead class="thead1">
        <tr>
            <th class="th1" width="40px">ID</th>
            <th class="th1" width="40px">Name</th>
            <th class="th1" width="40px">Age</th>
            <th class="th1" width="40px">IsAdmin</th>
            <th class="th1" width="40px">CreatedDate</th>
            <th class="th1" width="80px">&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr bgcolor="#f0ffff">
                <td bgcolor="#f0ffff" class="td1">${user.id}</td>
                <td bgcolor="#f0ffff" class="td1">${user.name}</td>
                <td bgcolor="#f0ffff" class="td1">${user.age}</td>
                <td bgcolor="#f0ffff" class="td1" width="40px">${user.isAdmin}</td>
                <td bgcolor="#f0ffff" class="td1">${user.createdDate}</td>
                <td bgcolor="#f0ffff" class="td1" width="80px">
                    <table>
                        <tr bgcolor="#f0ffff">
                            <td bgcolor="#f0ffff"><form:form action="edit/${user.id}" method="post"><input type="submit"
                                                                                                           size="XSmall"
                                                                                                           value="Edit"/>
                            </form:form></td>
                            <td bgcolor="#f0ffff"><form:form action="remove/${user.id}" method="post"><input
                                    type="submit"
                                    size="XSmall"
                                    value="Delete"/>
                            </form:form></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container">
    <c:if test="${user.id==0}">

        <h2>Add User</h2>

    </c:if>

    <c:if test="${!(user.id==0)}">

        <h2>Edit User</h2>

    </c:if>

    <c:url var="addAction" value="/add"/>

    <form:form action="${addAction}" commandName="user">
        <form:hidden path="id"/>
        <form:label path="isAdmin">

            <spring:message text="Admin:"/>

        </form:label>

        <form:checkbox path="isAdmin"/>
        <br>
        <form:label path="name">Name:</form:label>

        <form:input path="name" placeholder="Name"/>

        <form:label path="age">Age:</form:label>

        <form:input path="age" placeholder="Age"/>
        <br/>
        <c:if test="${user.id==0}">
            <br/>
            <button type="submit" class="button24" size="Small">Add User</button>
        </c:if>
        <c:if test="${!(user.id==0)}">
            <br/>
            <button type="submit" class="button24" size="Small">Edit User</button>
        </c:if>
    </form:form>
</div>
</body>
</html>
