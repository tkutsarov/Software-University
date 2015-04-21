function buildATable(input){
    console.log('<table>');
    console.log('<tr><th>Num</th><th>Square</th><th>Fib</th></tr>');
    var start = parseInt(input[0]);
    var end = parseInt(input[1]);
    var line = '<tr><td>';
    var isFibo = 'yes';
    function isPerfectSquare(num)
    {
        var s = Math.floor(Math.sqrt(num));
        return (s*s === num);
    }

    for(var i= start; i <= end; i++){
        var pow = i * i;

        if (isPerfectSquare(5*i*i + 4) || isPerfectSquare(5*i*i - 4)){
            isFibo = 'yes';
        } else {
            isFibo = 'no';
        }
        line += i + '</td><td>' + pow + '</td><td>' + isFibo + '</td></tr>';
        console.log(line);
        line = '<tr><td>';
    };
    console.log('</table>');
}



