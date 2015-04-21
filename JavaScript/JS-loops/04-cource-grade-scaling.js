var str = [
    {
        'name' : 'Пешо',
        'score' : 91
    },
    {
        'name' : 'Лилия',
        'score' : 290
    },
    {
        'name' : 'Алекс',
        'score' : 343
    },
    {
        'name' : 'Габриела',
        'score' : 400
    },
    {
        'name' : 'Жичка',
        'score' : 70
    }
],
    i,
    hasPassed;

for(i = 0; i < str.length; i += 1){
    var scale = (str[i].score * 1.1).toPrecision(4);
    if(scale % 1 === 0){
        scale = parseInt(scale);
    }
    str[i].score = scale;
    if(str[i].score < 100){
        str[i].hasPassed = false;
    } else {
        str[i].hasPassed = true;
    }
}

var passed = str.filter(function(student){
    if(student.hasPassed === true){
        return student;
    }
});

var passedSorted = passed.sort(function(a,b){
    return ((a.name === b.name) ? 0 : ((a.name > b.name) ? 1 : -1 ));
})

console.log(passedSorted);

