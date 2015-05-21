<!DOCTYPE html>
<html>
    <head>
        <title>Form Data</title>
        <style>
        form{
            width: 160px;
        }
        input{
            width: 150px;       
            margin:4px;
        }
        input.radio{
            width: 20px;
        }
        </style>
        
    </head>   
    <body>
        <form action="07_GetFormData.php" method="get">
            <input type="text" name="name" value="name" id="first-name">
            <input type="text" name="age" value="age" id="age">
            <div><input type="radio" name="sex" value="male"  checked="true" class="radio">Male</div>
            <div><input type="radio" name="sex" value="female" class="radio">Female</div>
            <input type="submit" value="Submit">
        </form>   
        <?php           
            if (!empty($_GET)){
                echo 'My name is '.$_GET['name'].'. I am '.$_GET['age'].
                        ' years old. I am '.$_GET['sex'].'.';                      
            }            
        ?>
    </body>    
</html>


