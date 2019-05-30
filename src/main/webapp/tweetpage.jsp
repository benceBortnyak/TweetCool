<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="utf-8">
    <title>TweetCool</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class ="tweets">
        <table>
            <tr>
                <th>Author</th>
                <th>Content</th>
            </tr>
        <c:forEach items="${listOfTweets}" var="tweet" varStatus="status">
            <tr>
                <td><c:out value="${tweet.author}"></c:out></td>
                <td><c:out value="${tweet.content}"></c:out></td>
            </tr>
        </c:forEach>
        </table>
    </div>
<form method="get" action="index.html">
    <input type="submit" value="Back">
</form>
<div class="inputfileds">
    <form method="get" action="tweetpage">
        Limit(Number of results):<input type="number" name="limit" min="0" value="10" ><br>
        Offset(Results to skip): <input type="number" name="offset" min="0" value="0"><br>
        Poster(Filter to show only one user's tweets)<input type="text" name="poster"><br>
        From(Results posted after the given Time)<input type="date" name="from" value="1900-01-01"><br>
        <button type="submit">Send</button>
    </form>
</div>
</body>
</html>
