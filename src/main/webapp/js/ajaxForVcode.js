   var xmlHttp;
   var flag=false;
function GetXmlHttpObject(){
		 
		try
		  {
		 
		  xmlHttp=new XMLHttpRequest();
		  }
		catch (e)
		  {
		 
		  try
		    {
		    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }
		  catch (e)
		    {
		    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		    }
		  }
		return xmlHttp;
}
 
  function checkVcode(){
	  
	  var tar=document.getElementById("vcode").value;
	  xmlHttp=GetXmlHttpObject();
		  if (xmlHttp==null)
		  {
		  alert ("您的浏览器不支持AJAX！");
		  return;
		  } 
		
		var url="checkvcode.do?vcode="+tar;
		xmlHttp.onreadystatechange=stateChanged;
		xmlHttp.open("get",url,true);
		xmlHttp.send(null);
		
		
		 
	
}

 function stateChanged(){
 
    if(xmlHttp.readyState==4){
         
          
          if(xmlHttp.responseText=='false'){
        	  alert("验证码错误");
              flag=false;
          }
          
        	 
          flag=true;
           
     
    
    }
    
    
 
 
 }
 
 function canSubmit(){
	 
	 checkVcode();
	  
	  
	 if(flag==false)
		  return false;
	 
	 document.getElementById("password").value=hex_md5(document.getElementById("password").value);
	 return true;
	 
 }
 