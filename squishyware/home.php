<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="layout.css" type="text/css" rel="stylesheet">
        <link href="lib/w3.css" type="text/css" rel="stylesheet">
        <link href="lib/w3-theme-blue.css" type="text/css" rel="stylesheet">
        <title>SquishyWare</title>
        
        
            
    </head>
    <body>
        <div class="mainbar">
            <img src="images/welcome.JPG" >
            <ul class="h-nav w3-theme-d1">
                <li><a href="index.html">Home</a></li> 
                <li><a href="#">Friends</a></li>
                <li><a href="#">Community</a></li>
                <li><a href="#">Market</a></li>
                <li><a href="#">News</a></li>
            </ul>
        </div>
        <div id="signin" class="w3-container w3-blue w3-card-4 w3-animate-top">
            <span class="w3-closebtn" 
                  onclick="this.parentElement.style.display='none'">&times;</span>
            <h3> You are not signed in! 
            </h3>
            
            <a href="login.html">Sign in</a>
        </div>
         
         
        <script>
        var xhttp=new XMLHttpRequest();
        //TODO: Use jQuery
        xhttp.onreadystatechange=function(){
            
            if (xhttp.readyState == 4 && xhttp.status == 200) {
            var obj=document.getElementById("signin").style;
        obj.display=xhttp.responseText; 
        }};
        xhttp.open("GET","notify.php?notify=get","true");
        xhttp.send();
        
        </script>
        <?php 
           
        ?>
        <div class="w3-row-padding">
            <div id="main" class="w3-col w3-twothird">
            <section class="w3-container w3-theme w3-padding-4">
                <header class="w3-container w3-theme-d2">
                    <h3 class="w3-xlarge">SquishyWare</h3>
                    <p class="w3-large" style="text-indent: 30px;">the platform for squishers</p>
                </header> 
                <article>
                <p>SquishyWare was created to fill the gaps left by other platforms.
                We combine different ideas to make the most crucial stuff
                programmers need available with just one account.</p>
                </article> 
            </section>
            <!-- What you can do-->
            <section class="w3-container w3-theme-d4">
                <p>
                    With SquishyWare, you can 
                   
                        <br/>
                        <a href="#collaborate">
                            <em> Collaborate</em>
                        </a> 
                     <br/>
                     <a href="#chat"><em>Chat</em> </a>
                       <br/>
                       <a href="#sell"><em>Sell</em></a>
                    <br/>
                    <a href="#rwarticles"><em>Read and Write Articles</em></a>
                <br/>
                <a href="#build"><em>Build tools for the community</em></a>
                <br/>           
                <a href="#genprojects"><em>Participate in general projects</em></a>
                
                <br/>
                <div style="font-style: italic">
                    And lots more!!!
                </div>
                </p>
                <div>
                    
                </div>
            </section>
            <section id="collaborate">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Collaborate
                </header>  
                <p>
                    We believe that collaboration is the foundation of strong
                    technologies. Many platforms today are being powered by 
                    products of genuine collaboration. The developer community 
                    is all about empowering ourselves. That is why we designed
                    SquishyWare to help programmers collaborate and help make 
                    the world a better place.
                </p>
                <div class="w3-card-2 w3-blue w3-large">
                    Wanna contribute? <a href="#" ><b>Find</b></a> a project  
                </div>
                <p>
                    To enhance collaboration, we decided to create a platform 
                    on SquishyWare where we can teach others the concept of 
                    our projects. <b>Teash</b> is what we came up with.
                    <br/>
                    Do you want people to contribute to your project? Or maybe 
                    you want to contribute to someone else's project. We are here 
                    to make it <i>easy</i> for <b>you</b>.
                </p>
                <div class="w3-card-2 w3-large w3-blue">
                    Start learning with <a href="#"><b>Teash</b></a>
                </div>
            </section>
            <section id="chat">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Chat
                </header>
                <p>
                    In order to bring programmers closer, we decided to add 
                    more functionality to the generic QA community. With 
                    SquishyWare, you can maintain relationship with other developers. 
                    Close relationship build teams, and that is our goal &boxh; 
                    promote co-operation amongst developers.
                </p>
            </section>
            <section id="sell">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Sell
                </header>
                <p>
                    While we do encourage open sourcing projects, you can make 
                    your finished products available for commercial use and earn 
                    some money on the side. You can also use the market platform 
                    to publish free products. You can also publish your products 
                    to the outside world.
                </p>
                <div class="w3-card-2 w3-blue w3-large">
                    <a href="#"><b>Explore</b></a> the market platform  
                </div>
            </section>
            <section id="rwarticles">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Read and Write articles
                </header>
                <p>
                    Information is a crucial part of a programmer's life. 
                    That is what we are all about. SquishyWare encourages sharing of 
                    information. That is why we have provided our own medium to 
                    help share information to our community.
                </p>
                <div class="w3-blue w3-card-2 w3-large">
                    Go to the <a href="#"><b>News</b></a> platform now!
                </div>
            </section>
            <section id="build">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Build tools for the community
                </header>
                <p>
                    As noted earlier, SquishyWare encourages collaboration. 
                    The main reason for building SquishyWare was to have an open 
                    sourced open source community. We allow members to contribute 
                    to our community and make it better for us all as we are of 
                    the opinion that "open source is the right way to do it".
                </p>
            </section>
            <section id="genprojects">
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Participate in General Projects
                </header>
                <p>
                    General Projects are SquishyWare's way of bringing all our 
                    members together to work on a project from scratch. It helps 
                    junior developers gain the team experience they need. What's 
                    more? You get badges after we complete the projects and you can 
                    totally add these projects to your portfolio!
                </p>
            </section>
            <section>
                <header class="w3-text-theme w3-padding-8 w3-xlarge header-font">
                    Explore
                </header>
                <p>
                    All we have listed are just outlines of SquishyWare's main features. 
                    But the best way to find out is to experiment yourself.
                </p>
                <p>Sign up now to get started.</p>
                <a href="register.php">
                <button class="w3-btn w3-theme-d3 w3-hover-blue" onclick="signup()">
                    Sign up
                </button>
                </a>    
            </section>
            </div>
            
            <div id="news" class="w3-rest">
                
            </div>
        </div>
    </body>
</html>
