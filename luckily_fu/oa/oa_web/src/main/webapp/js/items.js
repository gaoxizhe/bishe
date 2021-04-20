$(document).ready(function () {
    builderIndex();
    calculateMoney();
    $("#addItemButton").click(
        function () {
            $("#items").children("div").last().after($("#items").children("div").first().clone());
            $("#items").children("div").find("button").click(
                function () {
                    $(this).parent().parent().remove();
                    if ($("#items").children("div").size() == 1) {
                        $("#items").find("button").attr("disabled", true);
                    }
                    builderIndex();
                    calculateMoney();
                }
            );
            $("#items").find("button").attr("disabled", false);
            builderIndex();
            $("#money").change(
                function () {
                    calculateMoney();
                }
            );
            calculateMoney();
        }
    );
    $("#amount").change(
        function () {
            calculateMoney();
        }
    );
});// JavaScript Document

function builderIndex() {
    $.each($("#items").children(), function (i, val) {
        $("#items").children("div").eq(i).children().eq(0).find("select").attr("name", "items[" + i + "].item");
        $("#items").children("div").eq(i).children().eq(1).find("input").attr("name", "items[" + i + "].amount");
        $("#items").children("div").eq(i).children().eq(2).find("input").attr("name", "items[" + i + "].comment");
        $("#items").children("div").eq(i).children().eq(1).find("input").change(function () {
            calculateMoney();
        })
    });
}

function calculateMoney() {
    var totalMoney = 0;

    $.each($("#items").children(), function (i, val) {
        let find = $("#items").children("div").eq(i).children().eq(1).find("input[name='items[" + i + "].amount']");
        console.info(find);
        if (parseFloat(find.val())) {
            totalMoney += parseFloat(find.val());
        }
    });


    // $.each($("#amount"), function (i, val) {
    //     console.info(i);
    //     console.info(val);
    //     if (parseFloat($("#amount").eq(i).val())) {
    //         totalMoney += parseFloat($("#amount").eq(i).val());
    //     }
    // });

    $("#totalMoney").attr("value", totalMoney);
}