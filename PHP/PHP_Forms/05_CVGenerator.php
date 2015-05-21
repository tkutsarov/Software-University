<!DOCTYPE HTML>
<html>
    <head>
        <title>CV</title>
        <style>
            form{
                width:600px;
            }
        </style>     
    </head>
    <body>
        <form method="post" action>
            <fieldset>
                <legend>Personal Information</legend>
                <input type="text" name="first-name" placeholder="First Name"><br>
                <input type="text" name="last-name" placeholder="Last Name"><br>
                <input type="email" name="email" placeholder="Email"><br>
                <input type="text" name="phone" placeholder="phone"><br>
                <label>Female</label>
                <input type="radio" name="sex" value='female'>
                <label>Male</label>
                <input type="radio" name="sex" value='male'><br>
                <label>Birth Date</label><br>
                <input type="date" name="date" placeholder="dd/mm/yyyy"><br>
                <label>Nationality</label><br>
                <select name="nationality">
                    <option value="bulgarian">Bulgarian</option>
                    <option value="martian">Martian</option>
                    <option value="reptilian">Reptilian</option>
                </select>
            </fieldset>
            <fieldset>
                <legend>Last Work Position</legend>
                <label>Company Name</label>
                <input type="text" name="company"><br>
                <label>From</label>
                <input type="date" name="from-date" placeholder="dd/mm/yyyy"><br>
                <label>To</label>
                <input type="date" name="to-date" placeholder="dd/mm/yyyy">
            </fieldset>
            <fieldset>
                <legend>Computer Skills</legend>
                <label>Programming Languages</label><br>
                <div id="prog-language">
                    <div>
                        <input type="text" name="prog-language[]" id="programming">
                        <select name="prog-lang-lvl[]" id="prog-level">
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                        </select>
                    </div>
                </div>               
                <input type="button"  onclick="removeProgLanguage()" value="Remove Language"/>
                <input type="button" onclick="addProgLanguage()" value="Add Language"/>
            </fieldset>
            <fieldset>
                <legend>Other Skills</legend>
                <label>Languages</label><br>
                <div id="languageData">
                    <div>
                        <input type="text" name="language[]" id="language">
                        <select name="lang-lvl-comprehension[]" id="comprehension">
                            <option value="" disabled selected>Comprehension</option>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                        </select>
                        <select name="lang-lvl-reading[]" id="reading">
                            <option value="" disabled selected>Reading</option>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                        </select>
                        <select name="lang-lvl-writing[]" id="writing">
                            <option value="" disabled selected>Writing</option>
                            <option value="beginner">Beginner</option>
                            <option value="intermediate">Intermediate</option>
                            <option value="advanced">Advanced</option>
                        </select>
                    </div>
                </div>
                <input type="button" onclick="removeLanguage()" value="Remove Language"/>
                <input type="button" onclick="addLanguage()" value="Add Language"/><br>
                <label>Driver's License</label><br>
                <label>B</label>
                <input type='checkbox' name='drivers-license[]' value='B'/>
                <label>A</label>
                <input type='checkbox' name='drivers-license[]' value='A'/>
                <label>C</label>
                <input type='checkbox' name='drivers-license[]' value='C'/>
            </fieldset>
            <input type='submit' name='submit' value="Generate CV"/>
        </form>
        <?php            
           if(isset($_POST['submit']) && isset($_POST['first-name']) &&
                  isset($_POST['last-name']) && isset($_POST['email']) && 
                  isset($_POST['phone']) && isset($_POST['sex']) && 
                  isset($_POST['date']) && isset($_POST['nationality']) && 
                  isset($_POST['company']) && isset($_POST['from-date']) &&
                  isset($_POST['to-date']) && isset($_POST['prog-language']) &&
                  isset($_POST['language']) && isset($_POST['drivers-license'])){
               
               $firstName = $_POST['first-name'];             
               $lastName = $_POST['last-name'];
               $email = $_POST['email'];
               $phone = $_POST['phone'];
               $gender = $_POST['sex'];
               $birthDate = $_POST['date'];
               $nationality = $_POST['nationality'];
               $companyName = $_POST['company'];
               $dateFrom = $_POST['from-date'];
               $dateTo = $_POST['to-date'];
               $progrLangs = count($_POST["prog-language"]);           
               $progrLangsArr = $_POST["prog-language"];
               $progrLangsLvlArr = $_POST["prog-lang-lvl"];
               $languagesArr = $_POST['language'];
               $languagesCount = count($languagesArr);
               $languageComprehension = $_POST['lang-lvl-comprehension'];
               $languageReading = $_POST['lang-lvl-reading'];
               $languageWriting = $_POST['lang-lvl-writing'];
               $driversLicenseArr = $_POST['drivers-license'];
               $drLicenceCount = count($driversLicenseArr);
               
               if (preg_match('/[^A-Za-z]/', $firstName) || 
                       (preg_match('/[^A-Za-z]/', $lastName)) ||
                       (strlen($firstName) < 3) || (strlen($firstName) > 19) ||
                       (strlen($lastName) < 3) || (strlen($lastName) > 19)) {
                   echo 'Your names must contain only letters and be between 2 and 20 letters!!!';       
               } else if(preg_match('/[^A-Za-z0-9]/', $companyName) ||
                       ((strlen($companyName) < 3) || (strlen($companyName) > 19))){
                   echo 'Your company name must contain between 2 and 20 only letters and numbers!!!'; 
               } else if(preg_match('/[^0-9+-]/', $phone)){
                   echo 'Your phone number must contain only numbers and +,-';
               } else {
                   //personal info
                    echo '<h1>CV</h1>';
                    echo '<table style="width:350px;" border="1px solid black"><tr><th colspan="2">Personal Information</th></tr>' .
                     '<tr><td>First Name</td><td>' . $firstName . '</td></tr>' .
                     '<tr><td>Last Name</td><td>' . $lastName . '</td></tr>' .
                     '<tr><td>Email</td><td>' . $email . '</td></tr>' .
                     '<tr><td>Phone Number</td><td>' . $phone . '</td></tr>' .
                     '<tr><td>Gender</td><td>' . $gender . '</td></tr>' .
                     '<tr><td>Birth Date</td><td>' . $birthDate . '</td></tr>' .
                     '<tr><td>Nationality</td><td>' . $nationality . '</td></tr></table><br><br>';

                    //job

                    echo '<table style="width:350px;" border="1px solid black"><tr><th colspan="2">Last Work Position</th></tr>' .
                     '<tr><td>Company Name</td><td>' . $companyName . '</td></tr>' .
                     '<tr><td>From</td><td>' . $dateFrom . '</td></tr>' .
                     '<tr><td>To</td><td>' . $dateTo . '</td></tr></table><br><br>';

                    //skills
                     $cols = $progrLangs + 1;
                     echo '<table style="width:350px;" border="1px solid black"><tr><th colspan="3">Computer Skills</th></tr>'.
                        '<tr><td rowspan="' . $cols . '">Programming Languages</td><td>Language</td><td>Skill Level</td>';
                        for ($i = 0; $i < $progrLangs; $i++){
                            echo '<tr><td>' . $progrLangsArr[$i] . '</td><td>' .
                                $progrLangsLvlArr[$i] . '</td></tr>';
                        }
                     echo '</table><br><br>';

                     // other
                     $cols = $languagesCount + 1;
                     echo '<table style="width:600px;" border="1px solid black"><tr><th colspan="5">Other Skills</th></tr>'.
                        '<tr><td rowspan="' . $cols . '">Languages</td><td>Language</td><td>Comprehension</td><td>Reading</td><td>Writing</td></tr>';
                        for ($i = 0; $i < $languagesCount; $i++){
                            echo '<tr><td>' . $languagesArr[$i] . '</td><td>' .
                                $languageComprehension[$i] . '</td><td>' .
                                $languageReading[$i] . '</td><td>' .
                                $languageWriting[$i] . '</td></tr>';
                        }
                     echo "<tr><td>Driver's license</td><td colspan=\"4\">";
                     for($i = 0; $i < $drLicenceCount; $i++){
                         if($i != $drLicenceCount - 1){
                             echo "$driversLicenseArr[$i], ";
                         } else {
                             echo $driversLicenseArr[$i] . '</td></tr>';
                         }                   
                     }
                     echo '</table>';
               }                                     
           } else {
               echo 'You have to fill in all fields!';
           }           
        ?>
        <script>
            
            var lang = 2;
            
            function addProgLanguage(){
                var div = document.createElement('div');
                var select = document.createElement('select');
                var element = document.getElementById("prog-language");
                var input = document.createElement('input');
                input.setAttribute("type", "text");
                input.setAttribute("name", "prog-language[]");
                input.setAttribute("id", "programming");
                                
                var option1 = document.createElement('option');
                var text = document.createTextNode("Begginer");
                option1.appendChild(text);
                option1.setAttribute("value", "beginner");
                
                var option2 = document.createElement('option');
                text = document.createTextNode("Intermdiate");
                option2.appendChild(text);
                option2.setAttribute("value", "intermediate");
                
                var option3 = document.createElement('option');
                text = document.createTextNode("Advanced");
                option3.appendChild(text);
                option3.setAttribute("value","advanced");
                
                select.appendChild(option1);
                select.appendChild(option2);
                select.appendChild(option3);
                select.setAttribute("name", "prog-lang-lvl[]");
                select.setAttribute("id", "prog-level");
                               
                div.appendChild(input);
                div.appendChild(select);
                element.appendChild(div);            
                
            }
            
            function removeProgLanguage(){
                var element = document.getElementById("prog-language").lastChild;
                document.getElementById("prog-language").removeChild(element);
                
            }
            
            function addLanguage(){
                var div = document.createElement('div');
                div.innerHTML = '<input type="text" name="language[]" id="language">'  +
                        '<select name="lang-lvl-comprehension[]" id="comprehension">' +
                            '<option value="" disabled selected>Comprehension</option>'+
                            '<option value="beginner">Beginner</option>'+
                            '<option value="intermediate">Intermediate</option>'+
                            '<option value="advanced">Advanced</option>'+
                        '</select>'+
                        '<select name="lang-lvl-reading[]" id="reading">' +
                            '<option value="" disabled selected>Reading</option>'+
                            '<option value="beginner">Beginner</option>'+
                            '<option value="intermediate">Intermediate</option>'+
                            '<option value="advanced">Advanced</option>'+
                        '</select>'+
                        '<select name="lang-lvl-writing[]" id="writing">' +
                            '<option value="" disabled selected>Writing</option>' +
                            '<option value="beginner">Beginner</option>' +
                            '<option value="intermediate">Intermediate</option>'+
                            '<option value="advanced">Advanced</option>' +
                        '</select>';
                
                var element = document.getElementById("languageData");
                element.appendChild(div);
                lang++;
            }
            
            function removeLanguage(){
                var element = document.getElementById("language").lastChild;
                document.getElementById("language").removeChild(element);
                lang--;
            }
        </script>
    </body>
    
</html>