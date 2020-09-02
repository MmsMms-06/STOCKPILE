
// Function to check Whether both passwords 
// is same or not. 
function checkPassword(form) { 
	password = form.password.value; 
	confirmpassword = form.confirmpassword.value; 

	// If password not entered 
	if (password == '') 
		alert ("Please enter Password"); 
		
	// If confirm password not entered 
	else if (confirmpassword == '') 
		alert ("Please enter confirm password"); 
		
	// If Not same return False.	 
	else if (password != confirmpassword) { 
		alert ("\nPassword did not match: Please try again...") 
		return false; 
	} 
	

	// If same return True. 
	else{ 
		
		return true; 
	} 
}