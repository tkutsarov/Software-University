var decimalInput = prompt("Write a decimal number");
isNaN(decimalInput) ? alert("Enter a number!") : alert(DecimalToHexadecimal(decimalInput));
function DecimalToHexadecimal(decimalInput) {
    var result = "";
    while (decimalInput > 0) {
        var temp = decimalInput % 16;
        Math.floor(temp);
        switch (temp) {
            case 10: result = 'A' + result;
                break;
            case 11: result = 'B' + result;
                break;
            case 12: result = 'C' + result;
                break;
            case 13: result = 'D' + result;
                break;
            case 14: result = 'E' + result;
                break;
            case 15: result = 'F' + result;
                break;
            default: result = temp + result;
        }
        decimalInput /= 16;
        decimalInput = parseInt(decimalInput);
    }
    return result;
}