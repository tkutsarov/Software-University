
function concerts(input){
    var result = {},
        town,
        stadium,
        band,
        i;

    for(i = 0; i < input.length; i++){
        var line = input[i].split("|");
        town = line[1].trim();
        stadium = line[3].trim();
        band = line[0].trim();
        if(!result.hasOwnProperty(town)){
            result[town] = {};
            result[town][stadium] = [band];
        } else{
            if(!result[town].hasOwnProperty(stadium)){
                result[town][stadium] = [];
            }
            if(result[town][stadium].indexOf(band) === -1)
            {
                result[town][stadium].push(band);
            }
        }
    }

    result = sortObjectProp(result);
    for(var town in result){
        result[town] = sortObjectProp(result[town]);
        for(var stadium in result[town]){
            result[town][stadium].sort();
        }
    }

    function sortObjectProp(object){
        var sortedKeys = Object.keys(object).sort();
        var sortedObj = {};

        for(i in sortedKeys){
            sortedObj[sortedKeys[i]] = object[sortedKeys[i]];
        }
        return sortedObj;
    }
    console.log(JSON.stringify(result));
}

concerts([
    'ZZ Top | London | 2-Aug-2014 | Wembley Stadium',
    'Iron Maiden | London | 28-Jul-2014 | Wembley Stadium',
    'Metallica | Sofia | 11-Aug-2014 | Lokomotiv Stadium',
    'Helloween | Sofia | 1-Nov-2014 | Vassil Levski Stadium',
    'Iron Maiden | Sofia | 20-June-2015 | Vassil Levski Stadium',
    'Helloween | Sofia | 30-July-2015 | Vassil Levski Stadium',
    'Iron Maiden | Sofia | 26-Sep-2014 | Lokomotiv Stadium',
    'Helloween | London | 28-Jul-2014 | Wembley Stadium',
    'Twisted Sister | London | 30-Sep-2014 | Wembley Stadium',
    'Metallica | London | 03-Oct-2014 | Olympic Stadium',
    'Iron Maiden | Sofia | 11-Apr-2016 | Lokomotiv Stadium',
    'Iron Maiden | Buenos Aires | 03-Mar-2014 | River Plate Stadium'

])