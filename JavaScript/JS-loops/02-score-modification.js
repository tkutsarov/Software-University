var arr = [200, 120, 23, 67, 350, 420, 170, 212, 401, 615, -1],
    i;

var scores = arr.filter(function(num){
    if(( num >= 0) && (num <= 400)){
        return num;
    }
});

for(i = 0; i < scores.length; i += 1){
    scores[i] = scores[i] - scores[i] / 5;
}

var scaledScores = scores.sort(function(a,b){
    return a - b;
});

console.log(scaledScores);
