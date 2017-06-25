/**
 * 
 */

function initImgUploadBtn() {
	var img = document.createElement("img"); 
	img.setAttribute("src","../images/add-icon.png");
	$(".imgUploadBtn").prepend(img);
	
	$(".imgUploadBtn input[type=file]").change(function(){
		$(this).siblings("span").html(this.value.substring(this.value.lastIndexOf('\\')+1));
	});
}