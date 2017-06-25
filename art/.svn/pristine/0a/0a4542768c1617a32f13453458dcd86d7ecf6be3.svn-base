<script type="text/javascript">
     function openWindow(title,urlink,width,height){
		var fwin=window.parent;
		var found=false;
		while(!found){
		   if(fwin.name=='main_frame'||fwin.name=='back_frame') {
				  var wd=width;
				  var hi=height;
				  if(wd<=1.0)  wd=fwin.document.body.offsetWidth*wd;
				  if(hi<=1.0)  hi=fwin.document.body.offsetHeight*hi;
			  	  var win=fwin.openWindow(title,urlink,wd,hi,this);
		  	      found=true;
		   }
		   else {
			   fwin=fwin.parent;
		   }
		}
    }	 
</script> 