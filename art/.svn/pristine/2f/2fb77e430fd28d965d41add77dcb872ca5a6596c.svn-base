<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<script type="text/javascript">
    var cw;
    
    function openWindow(title,urlink,width,height,pw){
    	cw=pw;
 	   var bf=$$('back_frame');
 	   var ul=escape(urlink);
 	   var ln='<%=CONTEXT_PATH%>/common/winDialog.jsp?t='+encodeURI(title)+'&l='+ul+'&w='+width+'&h='+height;
 	   bf.src=ln;
 	   bf.style.display='block';
    }
    
    function closeWin(){
 	      var bf=$$('back_frame');
 	      bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
  	      bf.style.display='none';
    }
   
   function closedialog(ret) {
	   var bf=$$('back_frame');
	   bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
 	   bf.style.display='none';
	   if(cw.name!='main_frame') cw.closedialog(ret);
	}
   
   function closedialog2(ret) {
	   var bf=$$('back_frame');
	   bf.src='<%=CONTEXT_PATH%>/common/blank.jsp';
 	   bf.style.display='none';
	   if(cw.name!='main_frame') cw.closedialog2(ret);
	}  
</script> 
