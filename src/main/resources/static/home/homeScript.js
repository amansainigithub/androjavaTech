

function contactForm()
{
		var contactFirstName = document.getElementById("contactFirstName").value;
		var contactLastName = document.getElementById("contactLastName").value;
		var contactEmail = document.getElementById("contactEmail").value;
		var contactMobile = document.getElementById("contactMobile").value;
		
		phone = contactMobile.replace(/[^0-9]/g, '');
		if(phone.length != 10) { 
		   alert("Not a valid mobile valid!");
		   return false;
		}    
		
		
	
 if (!/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(contactEmail.value))
  {
    return false;
  }
    

		
		if(contactFirstName == "" || contactLastName == "" || contactEmail == "" || contactMobile == "")
		{
		return;
		}
		else
		{
			
		swal({
		  title: "AndrojavaTech4u",
		  text: "Thanks for contacting me!!",
		  icon: "success",
		  button: "close",
		});

}

}



function queryForm()
{

		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var question = document.getElementById("question").value;
		
		console.log(name)
		
		if(name == "" || email == "" || question == "")
		{
		return;
		}
		else
		{
		
		
			swal({
  title: "AndrojavaTech4u",
  text: "Thanks for contacting me!!",
  icon: "success",
  button: "close",
});
		
		}

}





//Toggle Siderbar

const toggleSidebar=()=>
{

console.log("thats fine");

if($('#colmd-2').is(":visible"))
	{
		$("#colmd-2").css("display","none");

	}
	else
	{
		$("#colmd-2").css("display","block");
		
	}

}







