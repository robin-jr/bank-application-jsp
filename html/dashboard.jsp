<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Welcome</title>
</head>

<body class="" style="">
    <script src="html/dashboard.js"></script>
    <div class="container">
        <h3 class="my-5">Welcome ${user.name}</h3>
        <a href="/hello" class="btn btn-danger float-end">Signout</a>
        <h3>Dashboard</h3>

        <div class="row">
            <div class="card col-3 shadow me-4" style="">
                <div class="card-body">
                    <h5>Balance: $${user.balance}</h5>
                </div>
            </div>
            <div class="card col-3 shadow me-4 btn" style="" onclick="hideTransaction()">
                <div class="card-body">
                    <h5>Make Transaction</h5>
                </div>
            </div>
            <div class="card col-3 shadow btn" style="" onclick="hideTransfer()">
                <div class="card-body">
                    <h5>Show Transactions</h5>
                </div>
            </div>
        </div>
        <div class="container mt-5" id="transfer">
            <form action="/hello/send" method="post">
                <div class="mb-3">
                    <label for="" class="form-label">To Account Number:</label>
                    <input type="number" name="to_acc_no" id="" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Amount:</label>
                    <input type="number" name="amount" id="" class="form-control" required>
                </div>
                <input type="submit" value="Send" class="btn btn-primary">
            </form>
        </div>
        <div class="container mt-5" id="transactions">
            <h6>History</h6>
            <div class="card">
                <div class="card-body">
                    <div class="row fw-bold">
                        <div class="col">Timestamp</div>
                        <div class="col">Particulars (From/To) </div>
                        <div class="col">Type</div>
                        <div class="col">Amount</div>
                    </div>
                    <hr />
                    <c:forEach items="${transactions}" var="transaction">
                        <div class="row">
                            <div class="col">${transaction.time}</div>
                            <div class="col">${transaction.toAccNo} / ${transaction.fromAccNo}</div>
                            <div class="col">${transaction.mode}</div>
                            <div class="col">${transaction.amount}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>

</html>