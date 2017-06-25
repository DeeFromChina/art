<script type="text/javascript">
	 var mainbody=window.document.body;
    if(window.addEventListener) {
 	     window.addEventListener("resize",goResize,false); 
    }
    else {
 	     window.attachEvent('onresize',goResize);
    }
    
    var fDiv1=window.document.getElementById('div_main');
    var bDiv1=window.document.getElementById('btnDiv');
    
    function goResize(){
       fDiv1.style.width=mainbody.offsetWidth-fDiv1.offsetLeft*2+"px";
       bDiv1.style.width=mainbody.offsetWidth-bDiv1.offsetLeft*2+"px";
       fDiv1.style.height=mainbody.offsetHeight-bDiv1.offsetHeight-fDiv1.offsetTop*2+"px";
       bDiv1.style.top=fDiv1.offsetHeight+fDiv1.offsetTop*2+5+"px";
    }
    goResize();   
</script> 
