function sortLetters(word, isAscending){
    var wordArr = word.split(''),
        resultArr = [],
        output;

    if(isAscending == true){
        resultArr = wordArr.sort(function(a,b){return a.toLowerCase() > b.toLowerCase();});
    } else {
        resultArr = wordArr.sort(function(a,b){return a.toLowerCase() < b.toLowerCase();});
    }

    output = resultArr.join('');
    console.log(output);
}

sortLetters('HelloWorld', true);
sortLetters('HelloWorld', false);