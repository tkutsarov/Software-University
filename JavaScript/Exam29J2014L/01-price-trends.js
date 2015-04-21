function pricesTrends(input){
    var roundedNums = [];
    for(var i = 0; i < input.length; i++){
        roundedNums[i] = Number(input[i]).toFixed(2);
    }
    for(var i in roundedNums){
        roundedNums[i] = Number(roundedNums[i]);
    }

    console.log("<table>");
    console.log("<tr><th>Price</th><th>Trend</th></tr>");
    for(var i = 0; i < roundedNums.length; i++){
        var priceTrend = "fixed.png";
        if(i !== 0){
            if((roundedNums[i - 1]) > (roundedNums[i])){
                priceTrend = "down.png";
            } else if ((roundedNums[i - 1]) < (roundedNums[i])){
                priceTrend = "up.png";
            }
        }
        var line = '<tr><td>' + roundedNums[i].toFixed(2) + '</td><td><img src="' + priceTrend + '"/></td></td>';
        console.log(line);
    }
    console.log("</table>");
}

pricesTrends([
    1.33,
    1.35,
    2.25,
    13.00,
    0.5,
    0.51,
    0.5,
    0.5,
    0.33,
    1.05,
    1.346,
    20,
    900,
    1500.1,
    1500.10,
    2000
])
