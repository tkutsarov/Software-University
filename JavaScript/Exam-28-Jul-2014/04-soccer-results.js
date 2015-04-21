function soccerResults(input){
    var result = {};

    for(var i in input){
        var line = input[i].split(/[\/:-]/g);
        var team1 = line[0].trim();
        var score1 = Number(line[2]);
        var team2 = line[1].trim();
        var score2 = Number(line[3]);
        makeTeamStats(team1,team2,score1,score2);
        makeTeamStats(team2,team1,score2,score1);
    }

    var keys = Object.keys(result);
    keys.sort();
    var sortedResult = {};
    for(var i in keys){
        sortedResult[keys[i]] = result[keys[i]];
        sortedResult[keys[i]]['matchesPlayedWith'].sort();
    }

    console.log(JSON.stringify(sortedResult));

    function makeTeamStats(team1,team2,score1,score2){
        if(!result.hasOwnProperty(team1)){
            result[team1] = {};
        }
        if(!result[team1].hasOwnProperty('goalsScored')){
            result[team1]['goalsScored'] = score1;
        } else{
            result[team1]['goalsScored'] = result[team1]['goalsScored'] + score1;
        }
        if(!result[team1].hasOwnProperty('goalsConceded')){
            result[team1]['goalsConceded'] = score2;
        } else{
            result[team1]['goalsConceded'] = result[team1]['goalsConceded'] + score2;
        }
        if(!result[team1].hasOwnProperty('matchesPlayedWith')){
            result[team1]['matchesPlayedWith'] = [team2];
        } else{
            if(result[team1]['matchesPlayedWith'].indexOf(team2) === -1){
                result[team1]['matchesPlayedWith'].push(team2);
            }
        }
    }
}

soccerResults([
    'Germany / Argentina: 1-0',
    'Brazil / Netherlands: 0-3',
    'Netherlands / Argentina: 0-0',
    'Brazil / Germany: 1-7',
    'Argentina / Belgium: 1-0',
    'Netherlands / Costa Rica: 0-0',
    'France / Germany: 0-1',
    'Brazil / Colombia: 2-1'
])