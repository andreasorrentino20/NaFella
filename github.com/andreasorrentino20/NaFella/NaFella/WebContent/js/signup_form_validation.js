function signup_formValidation()
{
	//Get element signup 
	var email = document.signup_forms.email;
	var first_name = document.signup_forms.first_name;
	var last_name = document.signup_forms.last_name;
	var phone_number = document.signup_forms.phone_number;
	var psw = document.signup_forms.psw;
	
	var action = document.forms["signup_forms"]["action"].value;
	
	//Se un utente si vuole registrare 
	if(action=="insert")
	{	
		if(ValidateEmail(email,"error1"))
		{
			if(first_last_name_validation(first_name,"error2","first name"))
			{
				if(first_last_name_validation(last_name,"error3","last name"))
				{
					if(phone_number_validation(phone_number,"error4"))
					{
						if(psw_validation(psw,8,25,"error5"))
			   	    	{
							
			   	    	}
						else
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}

function ValidateEmail(email,error)
{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var email_len = email.value.length;
	if(email_len > 0 && email_len < 65 )
	{
		if(email.value.match(mailformat))
		{	
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "Email not valid. Please insert a valid email.";
			email.focus();
			return false;
		}
	}
	else
	{
		if(email_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the email.";
		else
			if(email_len > 64)
				document.getElementById(error).innerHTML = "The max email is 64 characters.";
		
		return false;
	}
} 

function first_last_name_validation(name,error,stamp)
{
	var letters = /^[\sA-Za-z]+$/;
	var name_len = name.value.length;
	if(name_len > 0 && name_len < 65 )
	{	if(name.value.match(letters))
		{
			document.getElementById(error).innerHTML = "";
			return true;	
		}
		else
		{
			document.getElementById(error).innerHTML = "The "+ stamp + " must have alphabet characters only.";
			return false;
		}
	}
	else
	{
		if(name_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";
		else
			if(name_len > 64)
				document.getElementById(error).innerHTML = "The max "+ stamp + " is 64 characters.";
		
		return false;
	}
}

function phone_number_validation(phone_number,error)
{
	var phoneno = /^\d{10}$/;
	var phone_number_len = phone_number.value.length;
	if(phone_number_len > 0)
	{	if(phone_number.value.match(phoneno))
		{
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "The phone number must have numbers only and ten numbers.";
			return false;
		}
	}
	else
	{
		document.getElementById(error).innerHTML = "You have not insert the phone number.";
		return false;
	}
}

function psw_validation(psw,mx,my,error)
{
	var psw_len = psw.value.length;
	if (psw_len == 0 ||psw_len >= my || psw_len < mx)
	{
		document.getElementById(error).innerHTML = "Password should not be empty / length be between "+mx+" to "+my+".";
		return false;
	}
	else
	{ 
		document.getElementById(error).innerHTML = "";
	    return true;
	}
}