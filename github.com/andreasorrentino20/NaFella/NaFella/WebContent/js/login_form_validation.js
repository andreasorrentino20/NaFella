function login_Validation()
{	
	/*Get element login*/
	var email = document.forms_login.email;
	var psw = document.forms_login.psw;
	
	var action = document.forms["forms_login"]["action"].value;
	
	if(action=="login" || action=="login_admin") //Login da customer oppure login da admin
		{
			if(ValidateEmail(email,"error1"))
			{
				if(psw_validation(psw,8,25,"error2"))
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
} 

function login_up_Validation()
{	
	/*Get element login from header*/
	var email = document.forms_login_up.email;
	var psw = document.forms_login_up.psw;
	
	var action = document.forms["forms_login_up"]["action"].value;
	
	if(action=="login") //Login customer from header
		{
			if(ValidateEmail(email,"error_up_1"))
			{
				if(psw_validation(psw,8,25,"error_up_2"))
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