function biggestTableRow(input){
    var re = /[-+]?([0-9]*\.[0-9]+|[0-9]+)/g,
        biggestRowSum = -5000000,
        biggestRow,
        isFound = false;

    if(input.length > 3){
        for(var row = 2; row < input.length - 1; row++) {
            var nums = input[row].match(re);
            var tempSum = 0;
            if (nums != undefined) {
                isFound = true;
                for (var num = 0; num < nums.length; num++) {
                    tempSum += Number(nums[num]);
                }
                if (tempSum > biggestRowSum) {
                    biggestRowSum = tempSum;
                    biggestRow = nums;
                }
            }
        }

        if(isFound){
            var output = biggestRowSum + " = " + biggestRow[0];
            for(var i = 1; i < biggestRow.length; i++){
                output += " + " + biggestRow[i];
            }
            console.log(output);
        } else{
            console.log("no data");
        }
    } else {
        console.log("no data");
    }
}

/*biggestTableRow([
'<table>',
'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
'<tr><td>Sofia</td><td>26.2</td><td>8.20</td><td>-</td></tr>',
'<tr><td>Varna</td><td>11.2</td><td>18.00</td><td>36.10</td></tr>',
'<tr><td>Plovdiv</td><td>17.2</td><td>12.3</td><td>6.4</td></tr>',
'<tr><td>Bourgas</td><td>-</td><td>24.3</td><td>-</td></tr>',
'</table>'
]);*/

/*biggestTableRow([
'<table>',
'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
'<tr><td>Sofia</td><td>1</td><td>1</td><td>1</td></tr>',
'</table>'
])*/

/*biggestTableRow([
'<table>',
'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
'<tr><td>Pleven</td><td>-100</td><td>-200</td><td>-</td></tr>',
'<tr><td>Varna</td><td>-100</td><td>-</td><td>-300</td></tr>',
'<tr><td>Rousse</td><td>-</td><td>-200</td><td>-100</td></tr>',
'</table>'
])*/

biggestTableRow([
'<table>',
'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
'<tr><td>Varna</td><td>-</td><td>18.02</td><td>36.11</td></tr>',
'<tr><td>Pleven</td><td>1</td><td>-</td><td>1</td></tr>',
'<tr><td>Vidin</td><td>12850</td><td>-560</td><td>20833</td></tr>',
'<tr><td>Rousse</td><td>-</td><td>299.999999</td><td>-</td></tr>',
'<tr><td>Bourgas</td><td>-</td><td>25000</td><td>-</td></tr>',
'<tr><td>Yambol</td><td>-</td><td>-</td><td>-</td></tr>',
'<tr><td>Plovdiv</td><td>17.2</td><td>-</td><td>6.4</td></tr>',
'<tr><td>Sofia</td><td>-</td><td>1</td><td>1</td></tr>',
'<tr><td>Blagoevgrad</td><td>-</td><td>150</td><td>-</td></tr>',
'</table>'
])