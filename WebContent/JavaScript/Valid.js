
// Function to check Whether both passwords 
// is same or not. 
function checkPassword(form) { 
	password = form.password.value; 
	confirmpassword = form.confirmpassword.value; 
	mobilenumber= form.mobilenumber.value;

	// If password not entered 
	if (password == '') {
		alert ("Please enter Password"); 
		return false;
	}
	//Check the size of password
	else if(password.length <= 6 || password.length >= 18){
        alert ("Password must be 6to18 characters");
        return false;
	}
	else if(mobilenumber.length > 10){
        alert ("Mobilenumber  should contain only 10 digits ");
        return false;
	}
	// If confirm password not entered 
	else if (confirmpassword == '') {
		alert ("Please enter confirm password"); 
		return false;
	}
		
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

