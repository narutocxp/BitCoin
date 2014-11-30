   var xmlHttp;
   var userName="";
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
 
   

 function stateChanged(){
 
    if(xmlHttp.readyState==4){
         
          
          if(xmlHttp.responseText=='false'){
        	  document.getElementById("userName").value="不存在该钱包地址";
          }
          else{
        	  document.getElementById("userName").value=xmlHttp.responseText;
          }
    
    }
    
 }
 
 function checkAddress(){
	
	  var tar=document.getElementById("toAddress").value;
	  xmlHttp=GetXmlHttpObject();
		  if (xmlHttp==null)
		  {
		  alert ("您的浏览器不支持AJAX！");
		  return;
		  } 
		
		var url="checkwalletaddress.do?toAddress="+tar;
		xmlHttp.onreadystatechange=stateChanged;
		xmlHttp.open("get",url,true);
		xmlHttp.send(null);
		
	 
	 
 }
 