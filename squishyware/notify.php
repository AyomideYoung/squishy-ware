<?php

 $notify= $_REQUEST["notify"];
            if(!empty($notify) && isset($_COOKIE['visited'])){
                echo 'none';
            }else{
                echo 'block';
            }
        ?>