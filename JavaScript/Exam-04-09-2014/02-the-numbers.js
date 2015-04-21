function extractNumbers(input){
    var re = /[0-9]+/g,
        output = "";

    if(input.length > 1){
        input = input.join("\n");
    }

    var nums = input.toString().match(re);
    var hexaNums = [];
    for(var i in nums){
        hexaNums[i] = convertToHexa(nums[i]);
    }

    for(var i in hexaNums){
        output += hexaNums[i] + "-";
    }
    console.log(output.substring(0,output.length-1));

    function convertToHexa(num){
        var number = Number(num);
        var hexa = '';
        while(number > 0){
            var mod = number % 16;
            if(mod > 9){
                switch (mod){
                    case 10: hexa = "A" + hexa;
                        break;
                    case 11: hexa = "B" + hexa;
                        break;
                    case 12: hexa = "C" + hexa;
                        break;
                    case 13: hexa = "D" + hexa;
                        break;
                    case 14: hexa = "E" + hexa;
                        break;
                    case 15: hexa = "F" + hexa;
                        break;
                    default : console.log("Check the switch statement in convertToHexa()!!!");
                        break;
                }
            } else{
                hexa = mod + hexa;
            }
            number = Math.floor(number / 16);
        }
        hexa = "0x" + padWithZeros(hexa);
        return hexa;
    }

    function padWithZeros(str, size){
        while(str.length < 4){
            str = "0" + str;
        }
        return str;
    }
}

extractNumbers([
    '5tffwj(//*7837xzc2---34rlxXP%$”.'
])
