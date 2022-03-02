$(document).ready(function () {
    var i = 1;

    /* 
    * input function when click on button in inputForm
    */
    $("#insert").click(function () {
        var check = true;
        var name = $("#studentName").val();
        var math = $("#mathScore").val();
        var physical = $("#physicalScore").val();
        var chemistry = $("#chemistryScore").val();

        // check name
        if (name == "") {
            $("#nameError").text("Tên không được để trống");
            check = false;
        } else {
            $("#nameError").text("");
        }

        // check math
        var mathSc = parseFloat(math);
        if (mathSc < 0 || mathSc > 10) {
            $("#mathError").text("Điểm số không được < 0 hoặc > 10");
            check = false;
        } else {
            $("#mathError").text("");
        }

        // check physical
        var physicalSc = parseFloat(physical);
        if (physicalSc < 0 || physicalSc > 10) {
            $("#physicalError").text("Điểm số không được < 0 hoặc > 10");
            check = false;
        } else {
            $("#physicalError").text("");
        }

        // check chemistry
        var chemistrySc = parseFloat(chemistry);
        if (chemistrySc < 0 || chemistrySc > 10) {
            $("#chemistryError").text("Điểm số không được < 0 hoặc > 10");
            check = false;
        } else {
            $("#chemistryError").text("");
        }

        // insert student information in scoreTable
        if (check) {
            var row = document.createElement("tr");
            row.innerHTML = "<td>" + i + "</td>" + "<td>" + name + "</td>" + "<td>" + math + "</td>" + "<td>" + physical + "</td>" + "<td>" + chemistry + "</td>" + "<td>?</td>";
            $("#scoreTable").append(row);
            clearInput();
            i++;
        }
    });

    /* 
    * clear input form function
    */
    function clearInput() {
        $("#studentName").val("");
        $("#mathScore").val("");
        $("#physicalScore").val("");
        $("#chemistryScore").val("");
    };

    /* 
    * calculate the average score when click button id calAverage
    */
    $("#calAverage").click(function () {
        $("#scoreTable tr").each(function () {
            var mathText = $(this).children("td").eq(2).text();
            var physicalText = $(this).children("td").eq(3).text();
            var chemistryText = $(this).children("td").eq(4).text();

            var mathSc = parseFloat(mathText);
            var physicalSc = parseFloat(physicalText);
            var chemistrySc = parseFloat(chemistryText);

            var averageSc = (mathSc + physicalSc + chemistrySc) / 3;
            var averageScFix = averageSc.toFixed(1);

            $(this).children("td").eq(5).text(averageScFix);
        });
    });

    /* 
    * highlight student when click button id highlight
    */
    $("#highlight").click(function () {
        $("#scoreTable tr").each(function () {
            var averageText = $(this).children("td").eq(5).text();
            var averageSc = parseFloat(averageText);
            if (averageSc >= 8) {
                $(this).addClass("red");
            }
        });
    });

});