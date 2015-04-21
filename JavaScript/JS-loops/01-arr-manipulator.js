var arr = ["Pesho", 2, "Gosho", 12, 2, "true", 9, undefined, 0, "Penka", { bunniesCount : 10}, [10, 20, 30, 40]];

var filteredArr = arr.filter(function(num){
    return !isNaN(parseFloat(num)) && isFinite(num);
});

var sortedArr = filteredArr.sort(function(a,b){
    return b - a;
});

// find the most frequent number /if more than one, gets the first one/ !works only for sorted array

var mostFreqNum = sortedArr[0],
    count = 1,
    maxCount = 1,
    i;

for(i = 1; i < sortedArr.length; i += 1){
    if(sortedArr[i] === sortedArr[i-1]){
        count += 1;
    } else {
        if(count > maxCount){
            maxCount = count;
            mostFreqNum = sortedArr[i-1];
        }
        count = 1;
    }
}

console.log("Min number: " + sortedArr[sortedArr.length - 1]);
console.log("Max number: " + sortedArr[0]);
console.log("Most frequent number: " + mostFreqNum);
console.log(sortedArr);