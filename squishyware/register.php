<!DOCTYPE html>
<html>
    <head>
        <title>Sign up</title>
        <link href="layout.css" type="text/css" rel="stylesheet">
        <link href="lib/w3.css" type="text/css" rel="stylesheet">
        <link href="lib/w3-theme-blue.css" type="text/css" rel="stylesheet">
        <meta name="author" content="Bakare Ayomide"/>
        <script>
            function validatePassword(){
                
            }
        </script>
    </head>
    <body>
      <div class="mainbar">
            <img src="images/welcome.JPG" >
        </div>
        
        <div class="w3-row">
        <div class="w3-container w3-quarter">
        </div>
            <div class="w3-container w3-half">
           <h1 class="w3-text-theme">This would only take a minute</h1>
            Thank you. We promise that this would be well worth your 
            time. It should only take a minute
            
            <form class="w3-animate-opacity w3-container w3-padding-4" action="<?php echo $_SERVER['SCRIPT_NAME']; ?>">
            <label class="w3-text-theme w3-validate"> First Name</label>
             <br/>
             <input type="text" class="w3-input w3-validate w3-border" placeholder="Enter your firstname"
                    required/>
            <br/>
            <label class="w3-text-theme w3-validate"> Last Name</label>
             <br/>
             <input type="text" class="w3-input w3-border" placeholder="Enter your last name"
                    required/>
             <br/>
             <label class="w3-text-theme w3-validate">Username</label>
             <br/>
             <input type="text" class="w3-input w3-border " placeholder="Username" required/>
             <br/>
             <label class="w3-text-theme w3-validate">Email</label> (not required)
             <br/>
             <input type="email" class="w3-input w3-border " placeholder="Email"/>
             <br/>
             <label class="w3-text-theme w3-validate">Password</label>
             <br/>
             <input type="password" class="w3-input w3-border" placeholder="Password" required/>
             <br/>
             <label class="w3-text-theme w3-validate">Confirm Password</label>
             <br/>
             <input type="password" class="w3-input w3-border" placeholder="Confirm Password" required/>
             <br/>
             <label class="w3-text-red">TODO: Create not equal script</label>
             <br/>
             <label class="w3-text-theme w3-validate">Gender</label>
             <br/>
             <select name="gender" class="w3-select" required>
                 <option value="" disabled selected>Select a gender</option>
                 <option value="1">Male</option>
                 <option value="2">Female</option>
                 <option value="3">Others</option>
             </select>
             <div class="w3-third w3-padding">
                 <label class="w3-text-theme w3-validate">Day</label>
                 <input type="number" min="1" max="31" class="w3-input w3-border"/>
             </div> 
             <div class="w3-third w3-padding">
                 <label class="w3-text-theme w3-validate">Month</label>
                  <input type="number" min="1" max="12" class="w3-input w3-border"/>
             </div>
             <div class="w3-third w3-padding">
                 <label class="w3-text-theme w3-validate">Year</label>
                 <input type="number" min="1900" max="2018" class="w3-input w3-border"/>
             </div>
             <br/>
             <input type="submit" class="w3-btn w3-theme-d3 w3-hover-blue" value="Register"/>
        </form>
        </div>
        </div>    
    </body>
</html>


 <?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
