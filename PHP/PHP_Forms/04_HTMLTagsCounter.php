<?php session_start(); ?>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Tags Counter</title>
    </head>
    <body>
        <form method="get" action>
            <label>Enter HTML tags:</label>
            <input type="text" name="tag"/>           
            <input type="submit" name="submit" value="Submit"/>
        </form>
        <?php            
           
            $_SESSION['tagsArr'] = [];
            
           
            if(isset($_GET['submit'])){
                $input = $_GET['tag'];
                $tags = array("a", "abbr", "address", "area", "article", "aside", 
                    "audio", "b", "base", "bdi", "bdo", "blockquote", "body", "br", 
                    "button", "canvas", "caption", "cite", "code", "col", "colgroup", 
                    "command", "datalist", "dd", "del", "details", "dfn", "div", "dl", 
                    "dt", "em", "embed", "fieldset", "figcaption", "figure",
                    "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "head", 
                    "header", "hgroup", "hr", "html", "i", "iframe", "img", "input", 
                    "ins", "kbd", "keygen", "label", "legend", "li", "link", "map", 
                    "mark", "menu", "meta", "meter", "nav", "noscript", "object", 
                    "ol", "optgroup", "option", "output", "p", "param", "pre", 
                    "progress", "q", "rp", "rt", "ruby", "s", "samp", "script", 
                    "section", "select", "small", "source", "span", "strong", 
                    "style", "sub", "summary", "sup", "table", "tbody", "td",
                    "textarea", "tfoot", "th", "thead", "time", "title", "tr", 
                    "track", "u", "ul", "var", "video", "wbr");
               
                
                
                if(array_search($input, $tags)) {
                    if(isset($_SESSION['counter'])){
                        $_SESSION['counter'] += 1;
                    } else{
                        $_SESSION['counter'] = 1;
                    }
                    if(isset($_SESSION['tagsArr'])){
                        $_SESSION['tagsArr'] = $input;
                    } else{
                        $_SESSION['tagsArr'] = [];
                    }
                    echo 'Valid HTML tag!<br>Score: ' . $_SESSION['counter'];
                } else{
                    echo 'Invalid HTML tag!<br>Score: ' . $_SESSION['counter'];
                }
            }
          
        ?>
    </body>
    
</html>



