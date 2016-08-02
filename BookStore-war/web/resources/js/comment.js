/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function writeReview() {
    if(document.getElementById("addReviewDiv").style.display == "block"){
      document.getElementById("addReviewDiv").style.display = "none";  
    }else{
        document.getElementById("addReviewDiv").style.display = "block";
    }
    
}
function initSubmit() {
    document.getElementById("submitDiv").style.display = "block";
    if (document.getElementById("form1:reviewField").value == "") {
        document.getElementById("submitDiv").style.display = "none";
    }else{
        document.getElementById("submitDiv").style.display = "block";
    }
}
