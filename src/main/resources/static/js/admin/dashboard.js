$(document).ready(function () {
    var current = location.pathname;
    $('.menu-item-has-children').each(function () {
        var a = $(this).children();
        if (a.attr("href").indexOf(current) !== -1) {
            $(this).addClass("active").siblings().removeClass("active");
        }
    });

    $('.li-click').each(function () {
        var a = $(this).children();
        var ul = $(this).parent();
        if (a.attr("href").indexOf(current) !== -1) {
            $(this).addClass("active").siblings().removeClass("active");
            ul.removeAttr('aria-expanded').attr('aria-expanded',true);
            ul.style = null;
            ul.addClass("in");
            $(this).parent().parent().addClass("active");
        }
    });

    $.ajax({
        method: "get",
        url: "/admin/getTotalProducts",
        success: function (resp) {
            $('.total-products').text(resp);
        },
        error: function () {
            alert("error");
        }
    });

    $.ajax({
        method: "get",
        url: "/admin/getStatusProducts",
        success: function (resp) {
            $('.active-products').text(resp.active);
            $('.defective-products').text(resp.defective);
        },
        error: function () {
            alert("error");
        }
    });

    $.ajax({
        method: "get",
        url: "/admin/getTotalSales",
        success: function (resp) {
            $('.total-sales').text('$' + resp);
        },
        error: function () {
            alert("error");
        }
    });

    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(function () {
        $.ajax({
            url: '/admin/getStatusOrders',
            method: 'GET',
            success: function (resp) {
                var arr = Object.entries(resp).map(([key, value]) => ({key, value}));
                drawChart_1(arr);
            },
            error: function () {
                swal('error');
            }

        });
    });

    function drawChart_1(chart_data) {
        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['', 0],
            ['', null],
        ]);
        for (var i = 0; i < chart_data.length; i++) {
            data.addRow([chart_data[i].key, Number(chart_data[i].value)]);
        }
        var options = {
            height: 400,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
    };


});