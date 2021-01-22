function address_form_Validation()
{		
	/*Get element modify or insert address*/
	var street = document.address_form.street;
	var city = document.address_form.city;
	var postalCode = document.address_form.postalCode;
	var province = document.address_form.province;
	var country = document.address_form.country;
	
	var action = document.forms["address_form"]["action"].value;
	
	if(action=="insert_address" || action=="modify") 
			{
				
				if(action=="insert_address") 
				{
					var error1 = "error1";
					var error2 = "error2";
					var error3 = "error3";
					var error4 = "error4";
					var error5 = "error5";
				}
				else
					if(action=="modify")
					{
						var error1 = "error1_1";
						var error2 = "error1_2";
						var error3 = "error1_3";
						var error4 = "error1_4";
						var error5 = "error1_5";
					}
				
				if(street_validation(street,error1))
				{    
					if(city_province_country_validation(city,error2,"City",64))
					{
						if(postalCode_validation(postalCode,error3))
			   	    	{
							if(city_province_country_validation(province,error4,"Province",16))
							{
								if(city_province_country_validation(country,error5,"Country",32))
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

function ad_form_Validation()
{		
	/*Get element modify or insert address*/
	var street = document.ad_form.street;
	var city = document.ad_form.city;
	var postalCode = document.ad_form.postalCode;
	var province = document.ad_form.province;
	var country = document.ad_form.country;
	
	var action = document.forms["ad_form"]["action"].value;
	
	if(action=="modify") 
	{
				
		var error1 = "error1_1";
		var error2 = "error1_2";
		var error3 = "error1_3";
		var error4 = "error1_4";
		var error5 = "error1_5";				
				
				if(street_validation(street,error1))
				{    
					if(city_province_country_validation(city,error2,"City",64))
					{
						if(postalCode_validation(postalCode,error3))
			   	    	{
							if(city_province_country_validation(province,error4,"Province",16))
							{
								if(city_province_country_validation(country,error5,"Country",32))
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

function street_validation(street,error)
{
	var letters = /^[\s\,A-Za-z0-9]+$/;
	var street_len = street.value.length;
	
	if(street_len > 0 && street_len < 128 )
	{	if(street.value.match(letters))
		{
			document.getElementById(error).innerHTML = "";
			return true;	
		}
		else
		{
			document.getElementById(error).innerHTML = "The street must have alphabet characters only.";
			return false;
		}
	}
	else
	{
		if(street_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the street.";
		else
			if(street_len > 128)
				document.getElementById(error).innerHTML = "The max street is 128 characters.";
		
		return false;
	}
}

function city_province_country_validation(variable,error,stamp,mx)
{
	var variable_len = variable.value.length;
	if(variable_len > 0 && variable_len < mx )
	{	
		document.getElementById(error).innerHTML = "";
		return true;	
	}
	else
	{
		if(variable_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";
		else
			if(variable_len > mx)
				document.getElementById(error).innerHTML = "The max "+ stamp + " is "+mx+" characters.";
		
		return false;
	}
}

function postalCode_validation(postalCode,error)
{ 
	var numbers = /^[0-9]+$/;
	var postalCode_len = postalCode.value.length;
	if(postalCode_len > 0 && postalCode_len < 16 )
	{
		if(postalCode.value.match(numbers))
		{
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "Postal Code must have numeric characters only.";
			return false;
		}
	}
	else
	{
		if(postalCode_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the postal code.";
		else
			if(postalCode_len > 16)
				document.getElementById(error).innerHTML = "The max postal code is 16 characters.";
		
		return false;
	}
}