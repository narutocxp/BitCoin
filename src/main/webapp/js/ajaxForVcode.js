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
        	  flag=false;
        	  alert("验证码错误");
              return;
          }
          
        	 
          flag=true;
           
     
    
    }
    
    
 
 
 }
 
 function canSubmit(){
	 
	 var pwd=document.getElementById("password");
	 var cfmPwd=document.getElementById("confimPassword");
	 if(pwd.value.trim()!=cfmPwd.value.trim()){
		 
		 alert("前后密码不一致");
		 return false;
		 
		 
	 }
   
	 if(flag==false){
		 alert("验证码错误");
		 return false;
     
	 }
	  pwd.value=hex_md5(pwd.value);
	 cfmPwd.value=hex_md5(cfmPwd.value);
	 return true;
	 
 }
 