<script type="text/javascript"> 
	 var mainbody=window.document.body;
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
    var indId=$$('stdIndicatorForm_record_id').value;

    var fDiv=window.document.getElementById('formDiv');
    var bDiv=window.document.getElementById('btnDiv');
    var pDiv=window.document.getElementById('page_ds');
    var btbl=window.document.getElementById('tblForm');

    function goResize(){
       fDiv.style.width=mainbody.offsetWidth-fDiv.offsetLeft*2+"px";
       bDiv.style.width=mainbody.offsetWidth-bDiv.offsetLeft*2+"px";
       fDiv.style.height=mainbody.offsetHeight-bDiv.offsetHeight-fDiv.offsetTop*2+"px";
       bDiv.style.top=fDiv.offsetHeight+fDiv.offsetTop*2+"px";
       btbl.style.width=fDiv.offsetWidth-fDiv.offsetLeft+"px";
       if($$('stdIndicatorForm_btnStatus').value=='1'){
    	   pDiv.style.display='none';
       }    
       else{   
    	   pDiv.style.height=fDiv.offsetHeight-btbl.offsetHeight-10+"px";
    	   window.frames["frameDs"].location.href=contextpath+"meta/stdIndicator.do?action=listDs&ids="+indId;
       }
    }
    goResize();
</script> 