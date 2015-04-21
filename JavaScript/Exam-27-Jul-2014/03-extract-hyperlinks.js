function extractHyperlinks(input){
    var reATag = /(<a.*?>.*?<\/a>)/g;
    var reLink = /href\s*=\s*['"]?\s*([^'" >]+)/g;


    var continuousStr = input.join("");
    //console.log(continuousStr);
    var aTags = continuousStr.match(reATag);
    var stringTags = aTags.join("");
    var hrefData = stringTags.match(reLink);
    console.log(hrefData);
    /*for(var i in hrefData){
        var values = hrefData[i].split(/\s*\=([\s*"']+)/);
        console.log(values);
        var result = values[1];

        console.log(result);
    }*/
}


/*extractHyperlinks([
    '<link href="theme.css" rel="stylesheet" />',
    '<ul><li><a   href="/"  id="home">Home</a></li><li><a',
    '</li><li><a href =',
    '"/forum" >Forum</a></li><li><a class="href"'
])*/

extractHyperlinks([
'<!DOCTYPE html>',
'<html>',
'<head>',
'<title>Hyperlinks</title>',
'<link href="theme.css" rel="stylesheet" />',
'</head>',
'<body>',
'<ul><li><a   href="/"  id="home">Home</a></li><li><a',
'class="selected" href=/courses>Courses</a>',
'</li><li><a href =',
    '"/forum" >Forum</a></li><li><a class="href"',
'onclick="go()" href= "#">Forum</a></li>',
'<li><a id="js" href =',
    '"javascript:alert(\'hi yo\')" class="new">click</a></li>',
'<li><a id="nakov" href =',
    "http://www.nakov.com class='new'>nak</a></li></ul>",
'<a href="#empty"></a>',
"<a id=\"href\">href='fake'<img src='http://abv.bg/i.gif'",
"alt='abv'/></a><a href=\"#\">&lt;a href='hello'&gt;</a>",
'<!-- This code is commented:',
    '<a href="#commented">commentex hyperlink</a> -->',
'</body>'

])