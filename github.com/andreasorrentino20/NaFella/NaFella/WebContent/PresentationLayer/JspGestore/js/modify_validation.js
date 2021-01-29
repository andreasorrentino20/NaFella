function modify_formValidation()
{	
	/*Get element product*/
	var product_name = document.modify_product_forms.product_name;
	var size = document.modify_product_forms.size;
	var color = document.modify_product_forms.color;
	var image =  document.modify_product_forms.image;
	var sex = document.modify_product_forms.sex;
	var product_type = document.modify_product_forms.product_type;
	var category = document.modify_product_forms.category;
	var description = document.modify_product_forms.description;
	var price = document.modify_product_forms.price;
	var discount = document.modify_product_forms.discount;
	var availability = document.modify_product_forms.availability;
	
	var action = document.forms["modify_product_forms"]["action"].value;	
	
	//Se si vuole inserire un prodotto 
	if(action=="modify")
	{
		if(insert_validation(product_name,"error1","Product Name",64))
		{
			if(insert_validation(size,"error2","Size",16))
			{
				if(insert_validation(color,"error3","Color",32))
				{
					if(insert_validation(image,"error4","Image",4096))
					{	
							if(sex_validation(sex,"error5","Sex")) 
							{							
								if(product_type_validation(product_type,"error6","Product Type"))
								{
									if(category_validation(category,"error7","Category"))
									{
										if(insert_validation(description,"error8","Description",256))
										{
											if(price_validation(price,"error9","Price"))
											{
												if(discount_validation(discount,"error10","Discount"))
												{
													if(availability_validation(availability,"error11","Availability"))
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
			else
			{
				return false;
			}
	}
} 

function insert_validation(variable,error,stamp,mx)
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

function sex_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;
	if(variable_len > 0)
	{	
		var sex_value = /^[M,F,U]$/;
		
		if(variable.value.match(sex_value))
		{	
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "We expect one of these values ​​M or F or U";
			return false;
		}
	}
	else
	{
		document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";	
		return false;
	}
}

function product_type_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;
	if(variable_len > 0)
	{	
		if(variable.value=="T-Shirts" || variable.value=="Sweatshirts" || variable.value=="Suits" || variable.value=="Shirts" || variable.value=="Cover" || variable.value=="Poster" || variable.value=="Bags")
		{
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "We expect one of these values (T-Shirts,Sweatshirts,Suits,Shirts,Cover,Poster,Bags)";
			return false;
		}
	}
	else
	{
		document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";	
		return false;
	}
}

function category_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;
	if(variable_len > 0)
	{	
		if(variable.value=="Clothing" || variable.value=="Accessories")
		{
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "We expect one of these values (Clothing,Accessories)";
			return false;
		}
	}
	else
	{
		document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";	
		return false;
	}
}

function price_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;
	if(variable_len > 0 && variable_len <= 8)
	{	
		var price_value = /^[\.0-9]+$/;
		
		if(variable.value.match(price_value))
		{	
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "The format of the " + stamp + " must to be ES (29.9) ";
			return false;
		}
	}
	else
	{		
		if(variable_len <= 0)
			document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";
		else
			if(variable_len > 8)
				document.getElementById(error).innerHTML = "The max "+ stamp + " is 8 characters.";
		
		return false;
	}
}

function discount_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;

	if(variable_len > 0 && variable_len <= 8)
	{	
		var price_value = /^[\.0-9]+$/;
		
		if(variable.value.match(price_value))
		{	
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "The format of the " + stamp + " must to be ES (29.9) ";
			return false;
		}
	}
	else
	{	
		if(variable_len > 8)
		{ 
		  document.getElementById(error).innerHTML = "The max "+ stamp + " is 8 characters.";	
		  return false;
		}

		if(variable_len <= 0)
		{	
			document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";	
			return false;
		}			
	}
}

function availability_validation(variable,error,stamp)
{
	var variable_len = variable.value.length;
	if(variable_len > 0 && variable_len < 11)
	{	
		var price_value = /^[0-9]+$/;
		
		if(variable.value.match(price_value))
		{	
			document.getElementById(error).innerHTML = "";
			return true;
		}
		else
		{
			document.getElementById(error).innerHTML = "The " + stamp + " must to be a number ";
			return false;
		}
	}
	else
	{	
		if(variable_len <= 0)
		{ 
		  document.getElementById(error).innerHTML = "You have not insert the "+ stamp + ".";	
		  return false;
		}
		
		if(variable_len >= 11 )
		{ 
		  document.getElementById(error).innerHTML = "The max "+ stamp + " is 10 characters.";	
		  return false;
		}			
	}
}