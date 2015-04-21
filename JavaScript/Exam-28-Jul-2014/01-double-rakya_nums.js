
function rakyaNums(input){
    console.log('<ul>');

    var start = parseInt(input[0]),
        end = parseInt(input[1]),
        isRakya = false,
        i;

    for(i = start; i <= end; i++){
        if(findRakyaNum(i)){
            var line = "<li><span class='rakiya'>" + i + "</span><a href=\"view.php?id=" + i + ">View</a></li>";
        } else{
            var line = "<li><span class='num'>" + i + "</span></li>";
        };
        console.log(line);
    };

    console.log('</ul>');

    function findRakyaNum(num){
        var stringArr = num.toString().split('');
        for(var i1 = 0; i1 < stringArr.length - 3; i1++){
            var firstNum = stringArr[i1] + stringArr[i1+1];
            for(var i2 = i1 + 2; i2 < stringArr.length -1; i2++){
                if(firstNum === stringArr[i2] + stringArr[i2+1]){
                    isRakya = true;
                    return isRakya;
                }
            }
        }
        isRakya = false;
        return isRakya;
    };
}

rakyaNums([
    11210,
    11215
])