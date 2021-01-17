<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Final Project</title>
    <style><%@include file="../css/style.css"%></style>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
        </script>
</head>
<body>
<h1> Welcome to the COVID API! </h1>
<h2> Please choose a state from the list below. </h2>
<h4> After state is chosen, please pick a date. </h4>
<form method="get" action="/get/">
    <label>Select State: </label>
    <select name="state">
        <option value="AL">Alabama</option>
        <option value="AK">Alaska</option>
        <option value="AZ">Arizona</option>
        <option value="AR">Arkansas</option>
        <option value="CA">California</option>
        <option value="CO">Colorado</option>
        <OPTION VALUE="CT">Connecticut</OPTION>
        <option value="DE">Delaware</option>
        <option value="FL">Florida</option>
        <option value="GA">Georgia</option>
        <option value="HI">Hawaii</option>
        <option value="ID">Idaho</option>
        <option value="IL">Illinois</option>
        <option value="IN">Indiana</option>
        <option value="IA">Iowa</option>
        <option value="KS">Kansas</option>
        <option value="KY">Kentucky</option>
        <option value="LA">Louisiana</option>
        <option value="ME">Maine</option>
        <option value="MD">Maryland</option>
        <option value="MA">Massachusetts</option>
        <option value="MI">Michigan</option>
        <option value="MN">Minnesota</option>
        <option value="MS">Mississippi</option>
        <option value="MO">Missouri</option>
        <option value="MT">Montana</option>
        <option value="NE">Nebraska</option>
        <option value="NV">Nevada</option>
        <option value="NH">New Hampshire</option>
        <option value="NJ">New Jersey</option>
        <option value="NM">New Mexico</option>
        <option value="NY">New York</option>
        <option value="NC">North Carolina</option>
        <option value="ND">North Dakota</option>
        <option value="OH">Ohio</option>
        <option value="OK">Oklahoma</option>
        <option value="OR">Oregon</option>
        <option value="PA">Pennsylvania</option>
        <option value="RI">Rhode Island</option>
        <option value="SC">South Carolina</option>
        <option value="SD">South Dakota</option>
        <option value="TN">Tennessee</option>
        <option value="TX">Texas</option>
        <option value="UT">Utah</option>
        <option value="VT">Vermont</option>
        <option value="VA">Virginia</option>
        <option value="WA">Washington</option>
        <option value="DC">Washington D.C.</option>
        <option value="WV">West Virginia</option>
        <option value="WI">Wisconsin</option>
        <option value="WY">Wyoming</option>
    </select>
    <label>Select Date:</label>
    <input name="date" type="text" id="datepicker">
    <input type="submit" value = "Submit">
</form>
<br><br>
<form name="save" method="post" action="/save">
    <input type="hidden" name="id" value="">
    <input type="hidden" name="state" value= "<%=request.getParameter("state")%>">
    <input type="hidden" name="date" value="<%=request.getParameter("date")%>">
    <input type="hidden" name="positive" value="<%=request.getParameter("cases")%>">
    <input type="hidden" name="death" value="<%=request.getParameter("deaths")%>">
    <input type="hidden" name="increasedby" value="<%=request.getParameter("newcases")%>">
    <input type="submit" value="Saves Data">
</form>
<br><br>
<a href="/chart">View Selected Data in Chart</a>
<br><br>
<table>
    <tr>
        <th>State</th>
        <th>Date</th>
        <th>Total Cases</th>
        <th>Total Deaths</th>
        <th>New Cases</th>
    </tr>
    <c:forEach var ="covidstats" items = "${covidstats}">
    <tr>
        <td>${covidstats.getState()}</td>
        <td>${covidstats.getDate()}</td>
        <td>${covidstats.getPositive()}</td>
        <td>${covidstats.getDeath()}</td>
        <td>${covidstats.getIncreasedby()}</td>
    </tr>
    </c:forEach>
</table>
<div>
    <h3>State</h3> <h4><%=request.getParameter("state")%></h4>
    <h3>Date Picked</h3> <h4><%=request.getParameter("date")%></h4>
    <h3>Cases</h3> <h4><%=request.getParameter("cases")%></h4>
    <h3>Deaths</h3> <h4><%=request.getParameter("deaths")%></h4>
    <h3>New Cases</h3> <h4><%=request.getParameter("newcases")%></h4>
</div>
<a href="/">Return to Login Page</a>
</body>
</html>