/**
*=================================================================
*Name:			JavaScript��ҳ
*RCSfile:		Pager.js
*Revision:		1.0
*Author:		liushengye
*Released:		2009-06-24 23:00:15
Copyright:	    liushengye-20090706
*Description:	JavaScriptȫ���ս���ҳ
*Contact:		QQ:361583817
*=================================================================
pageWrapper
<div id="pageBasicTemplate" style="display:none">
��#{recordCount}��¼
ҳ��#{pageIndex}/#{pageCount}
ÿҳ#{pageSize}��
ÿҳ��ʾ#{pageSizeSelect}��
#{pageFrist}
#{pagePrevious}
#{pageText}
#{pageNext}
#{pageLast}
#{pageSelect}
#{pageInput}
#{pageGo}
</div>
var myPager = new Web.Pager();//��ʼ����ҳ
myPager.setDataText();//���÷�ҳ����ģ��
myPager.setDataInfo(1,10,10);//���÷�ҳ����
myPager.setDataInfo({"pageIndex":1,"pageSize":10,"recordCount":10});
myPager.write();//�����ҳ
*/
var Web = Web||{};
Web.Pager =function()
{
	this.initialize.apply(this,arguments);
};
Web.Pager.prototype=
{
	initialize: function(sName,inputPageMode,outputPageMode,sPageUrl,sHtml){
		this.sName = sName;//��������
		this.inputPageMode=inputPageMode;//��ҳ��������ģʽ[1-���������������ҳ���ַ|Content.html?pageIndex=1&pageSize=10,2-�����������JavaScriptα����]
		this.outputPageMode=outputPageMode;//��ת��ʽ:[1-ˢ��ҳ����ת,2-ִ��JavaScriptα����]
		this.pageIndexArg = "pageIndex";//���ò�ѯ�ַ�����Ĭ��pageIndex|����������
		this.pageSizeArg = "pageSize";//���ò�ѯ�ַ�����Ĭ��pageSize
this.defaultHtml = "#{recordCount}#{pageIndex}#{pageSize}#{pageSizeSelect}#{pageCount}#{pageFrist}#{pagePrevious}#{pageText}#{pageNext}#{pageLast}#{pageSelect}#{pageInput}#{pageGo}";
		this.setUrl(sPageUrl);//���÷�ҳ��ת��ִ�е��¼�
		this.setHtml(sHtml);//���÷�ҳ���ģ��
	},
	setDataInfo:function(){
		//���÷�ҳ����
		var iPageIndex,iPageSize,iRecordCount;
		if(arguments.length==1)
		{
			//���õ�һ������ʱ���ҳ���ݶ���
			iPageIndex=arguments[0].pageIndex||this.pageIndex;
			iPageSize=arguments[0].pageSize||this.pageSize;
			iRecordCount=arguments[0].recordCount||this.recordCount;
		}
		else
		{
			iPageIndex=arguments[0]||this.pageIndex;
			iPageSize=arguments[1]||this.pageSize;
			iRecordCount =arguments[2]||this.recordCount;
		}
		switch(this.inputPageMode)
		{
			default:
			case 3 :
				this.inputPageMode = 2;//��һ�μ��شӲ�ѯ������ȡֵ
			case 1 ://[1-���������������ҳ���ַ|Content.html?pageIndex=1&pageSize=10]
				_iPageIndex=this.getQuery(this.pageIndexArg);
				_iPageSize=this.getQuery(this.pageSizeArg);
				_iPageIndex=(!!_iPageIndex) ? _iPageIndex:iPageIndex;
				_iPageSize=(!!_iPageSize) ? _iPageSize:iPageSize;
				break;
			case 2 ://[2-�����������JavaScriptα����]
				_iPageIndex=iPageIndex;
				_iPageSize=iPageSize;
				break;
			case 4 : //֧��ģʽLink:2005042155_1.html,2005042155_2.html...2005042155_10.html
				var _pageStr = this.pageUrl.split("#{pageIndex}");
				var _url = document.location.href;
				var start = _url.indexOf(_pageStr[0])+_pageStr[0].length;
				var end = _url.indexOf(_pageStr[1]);
				_iPageIndex =  _url.substring(start,end);
				_iPageSize=iPageSize;
				break;
		}
		this.recordCount =this.formatNum(iRecordCount,1,0,0,0);//�ܼ�¼����:recordCount>=0;
		this.pageSize = this.formatNum(_iPageSize,1,0,1,0);//ҳ���С:pageSize>=0;
		this.getPageCount();//ҳ������
		this.pageIndex = this.formatNum(_iPageIndex,1,1,1,this.pageCount);//��ǰҳ��:pageIndex>=1&&pageIndex<=pageCount
	},
	getPageCount:function(){
		//���ҳ������
		this.recordCount =this.formatNum(this.recordCount,1,0,0,0);//�ܼ�¼����:recordCount>=0;
		this.pageSize = this.formatNum(this.pageSize,1,0,1,0);//ҳ���С:pageSize>=0;
		var iRC=this.recordCount,iPS=this.pageSize;
		var i=(iRC%iPS==0)?(iRC/iPS):(this.formatNum((iRC/iPS),1,0,0,0)+1);
		this.pageCount = i;
		return (i);
	},
	//���÷�ҳ��ʾ��Htmlģ��
	setHtml:function(sHtml){
		this.Html=(!sHtml) ? this.defaultHtml:sHtml;
	},	
	setDataText:function(sPageTextMode,sPageText,sPageFrist,sPagePrevious,sPageNext,sPageLast,sPageSelect,sPageGo){
		//���÷�ҳ����ģ��
		this.pageTextMode = sPageTextMode;//��ҳҳ���㷨(1|2|3)
		this.pageText = sPageText;//ҳ��[��ǰҳ��|����ҳ��]
		this.pageFrist = sPageFrist;//[��ҳ����|��ҳ����]
		this.pagePrevious = sPagePrevious;//[��һҳ����|��һҳ����]
		this.pageNext = sPageNext;//[��һҳ����|��һҳ����]
		this.pageLast = sPageLast;//[βҳ����|βҳ����]		
		this.pageSelect = sPageSelect;//[ҳ����ת��ǰҳ|ҳ����ת������ҳ]	
		this.pageGo = sPageGo;//ҳ����ת�İ�ť�ı���
	},
	setUrl:function(sUrl){
		//���÷�ҳUrl��ģ��
		this.pageUrl=sUrl;
	},
	getUrl:function(iPageIndex){
		//����ҳ���ģ��������ҳUrl
		var sUrl = this.pageUrl;
		sUrl = sUrl.replace(/#{pageIndex}/ig,iPageIndex);
		sUrl = sUrl.replace(/#{pageSize}/ig,this.pageSize);
		return sUrl;
	},
	setActive:function(text,title,className,iPageIndex)
	{
		//����
		var s="<a href=\""+this.getUrl(iPageIndex)+"\" class=\""+className+"\" title=\""+title+"\">"+text+"</a>";
		return s;
	},
	setDisable:function(text,title,className)
	{
		//����
		var s="<span class=\""+className+"\" title=\""+title+"\">"+text+"</span>";
		return s;
	},
	toPage:function(iPageIndex,iPageSize){ 
		//��ҳ����ת
		var strStript="";
		if(!!iPageSize)
		{
			this.pageSize = this.formatNum(iPageSize,1,0,1,0);//ҳ���С:pageSize>=0;
			this.pageCount = this.getPageCount();//ҳ������
		}
		this.pageIndex = this.formatNum(iPageIndex,1,1,1,this.pageCount);//��ǰҳ��:pageIndex>=1&&pageIndex<=pageCount
		var _url = this.getUrl(this.pageIndex);
		switch(this.outputPageMode)
		{
			default:
			case 1://[1-��ת����ҳ���ַ|Content.html?pageIndex=1&pageSize=10]
				strStript="javascript:self.location.href='"+_url+"'";
				break;
			case 2 ://[2-ִ�д�������JavaScriptα����]				
				strStript=_url;
				break;
		}
		eval(strStript);
	},
	write:function(id,mode,html){
		//�����ҳ
		if(this.getPageCount()<=0){
			temp="";
		}
		else{
			var sN = this.sName;
			var temp = this.Html;
			var pageTextMode = this.pageTextMode;	
			var recordCount = this.recordCount;
			var pageIndex = this.pageIndex;
			var prevPage = pageIndex - 1; 
			var nextPage = pageIndex + 1;
			var pageSize = this.pageSize;
			var pageCount = this.pageCount;		
			var pageGo = this.pageGo;
			var pageSelect = this.pageSelect;		
			var pageFrist = this.pageFrist;
			var pagePrevious = this.pagePrevious;
			var pageNext = this.pageNext;
			var pageLast = this.pageLast;
			var pageText = this.pageText;		
			if (!!mode){pageTextMode = mode;}
			if (!!html)	{temp = html;}		
			var sRecordCount =recordCount;//��¼��
			var sPageIndex =pageIndex;//��ǰҳ��
			var sPageSize =pageSize;//ҳ���С
			var sPageCount =pageCount;//ҳ������	   
			var sPageFrist="";
			var sPagePrevious="";
			var sPageNext="";
			var sPageLast="";
			var sPageInput="";
			var sPageGo="";
			var sPageSelect="";
			var sPageSizeSelect="";
			var sPageText ="";
			
			var isPageFrist=!!(temp.indexOf("#{pageFrist}")!=-1);
			var isPagePrevious=!!(temp.indexOf("#{pagePrevious}")!=-1);
			var isPageNext=!!(temp.indexOf("#{pageNext}")!=-1);
			var isPageLast=!!(temp.indexOf("#{pageLast}")!=-1);
			var isPageInput=!!(temp.indexOf("#{pageInput}")!=-1);
			var isPageSizeSelect=!!(temp.indexOf("#{pageSizeSelect}")!=-1);
			var isPageSelect=!!(temp.indexOf("#{pageSelect}")!=-1);
			var isPageInput=!!(temp.indexOf("#{pageInput}")!=-1);
			var isPageText =!!(temp.indexOf("#{pageText}")!=-1);
			
			if(isPageFrist)
			sPageFrist = (pageIndex>1&&pageIndex<=pageCount) ? this.setActive(pageFrist[0],"��ҳ-Frist","pageFrist",1):this.setDisable(pageFrist[1],"��ҳ-Frist","dispageFrist");
			if(isPagePrevious)
			sPagePrevious =(pageIndex>1&&pageIndex<=pageCount) ? this.setActive(pagePrevious[0],"��һҳ-Previous","pagePrevious",prevPage):this.setDisable(pagePrevious[1],"��һҳ-pagePrevious","dispagePrevious");
			if(isPageNext)
			sPageNext = (pageIndex>0&&pageIndex<pageCount) ? this.setActive(pageNext[0],"��һҳ-Next","pageNext",nextPage):this.setDisable(pageNext[1],"��һҳ-Next","dispageNext");
			if(isPageLast)
			sPageLast = (pageIndex>0&&pageIndex<pageCount) ? this.setActive(pageLast[0],"βҳ-Last","pageLast",pageCount):this.setDisable(pageLast[1],"βҳ-Last","dispageLast");
			if(isPageInput)
			{
				sPageInput ="";//"<input class=\"pageInput\" type=\"text\" id=\""+id+"pageInput\" size=\"6\" maxlength=\"6\" onmouseover=\"this.focus()\" onfocus=\"this.select()\" onkeydown=\"if (event.keyCode==13) "+sN+".toPage(this.value)\" value=\""+pageIndex+"\" />";
				sPageGo ="";//"<input class=\"pageGo\" type=\"button\" id=\""+id+"pageGo\" onClick=\""+sN+".toPage(document.getElementById('"+id+"pageInput').value)\" value=\""+pageGo[0]+"\" />";
			}
			if(isPageSizeSelect)
			{
				if(pageCount==0)
				{
					sPageSizeSelect ="<select class=\"pageSizeSelect\" id=\""+id+"pageSizeSelect\" disabled=\"disabled\">";
					sPageSizeSelect+="<option value=\""+0+"\">0</Option>";
				}
				else
				{
					sPageSizeSelect ="<select class=\"pageSizeSelect\" id=\""+id+"pageSizeSelect\" onChange=\""+sN+".toPage(1,this.value)\">";
					var minPg = 5;
					if(pageSize <= 5)minPg = 1;
					for(var i=minPg;i<10;i++)
					{
						if (pageSize==i) 
						{
							sPageSizeSelect+="<option selected=\"selected\" value=\""+pageSize+"\">"+pageSize+"</Option>";
						}
						else{
							sPageSizeSelect+="<option value=\""+i+"\">"+i+"</Option>";
						}
					}
					for (var i=1;i<=10;i++){
						var _bps =10*(i-1);
						var _eps =10*(i);
						if (pageSize==_eps) 
						{
							sPageSizeSelect+="<option selected=\"selected\" value=\""+pageSize+"\">"+pageSize+"</Option>";
						}
						else if(_bps<pageSize&&pageSize<_eps&&pageSize>10){
							sPageSizeSelect+="<option selected=\"selected\" value=\""+pageSize+"\">"+pageSize+"</Option>";
							sPageSizeSelect+="<option value=\""+_eps+"\">"+_eps+"</Option>";
						}
						else{
							sPageSizeSelect+="<option value=\""+_eps+"\">"+_eps+"</Option>";
						}
					}
				}
				sPageSizeSelect+="</select>";
			}
			if(isPageSelect)
			{
				if(pageCount==0)
				{
					sPageSelect ="<select class=\"pageSelect\" id=\""+id+"pageSelect\" disabled=\"disabled\">";
					sPageSelect+="<option value=\""+0+"\" disabled=\"disabled\">0</Option>";
				}
				else
				{
					sPageSelect ="<select class=\"pageSelect\" id=\""+id+"pageSelect\" onChange=\""+sN+".toPage(this.value)\">";
					for (var i=1;i<=pageCount;i++) {
						if (i!=pageIndex) {
						   var t =pageSelect[1];
						   t = t.replace(/#{pageIndex}/ig,i);
						   t = t.replace(/#{pageCount}/ig,sPageCount);			   
						   sPageSelect+="<option value=\""+i+"\">"+t+"</Option>";
						}
						else{		
							   var t =pageSelect[0];
							   t = t.replace(/#{pageIndex}/ig,i);
							   t = t.replace(/#{pageCount}/ig,sPageCount);
							   sPageSelect+="<option selected=\"selected\" value=\""+i+"\">"+t+"</Option>";
						}
					}
				}
				sPageSelect+="</select>";		
			}	
			if(isPageText)
			{
				switch(pageTextMode)
				{
					//ʮҳ���ַ�ҳЧ��һ��
					default:
					case 1:////0-100ҳ���ҳ��ģʽ
						var bPage = pageIndex-2,ePage =pageIndex+2;
						if (bPage<1) {
							bPage=1;
						}
						if (pageCount<ePage){
							ePage=pageCount;
						}
						if (pageIndex>1&&bPage>1)
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,1);
							sPageText +=this.setActive(_t,"ҳ��-"+1,"pageNum",1);
						}
						if (pageIndex>2&&bPage>2)
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,2);
							sPageText +=this.setActive(_t,"ҳ��-"+2,"pageNum",2);
						}
						if (pageIndex > 5) sPageText += '<span class="pageDot">...</span>';					
						for (var i =bPage ; i <= ePage; i++) {
							if(i==pageIndex) {
								var _t = pageText[0].replace(/#{pageIndex}/ig,i);
								sPageText += this.setDisable(_t,"ҳ��-"+i,"pageIndex");
							}else {
								var _t = pageText[1].replace(/#{pageIndex}/ig,i);
								sPageText +=this.setActive(_t,"ҳ��-"+i,"pageNum",i);
							}
						}
						if (pageIndex + 4<pageCount)sPageText += '<span class="pageDot">...</span>';
						if (pageIndex <(pageCount-1)&&ePage<(pageCount-1))
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,pageCount-1);
							sPageText +=this.setActive(_t,"ҳ��-"+(pageCount-1),"pageNum",pageCount-1);
						}
						if (pageIndex <pageCount&&ePage<pageCount)
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,pageCount);
							sPageText +=this.setActive(_t,"ҳ��-"+pageCount,"pageNum",pageCount);
						}
						break;
					case 2://50-10000ҳ���ҳ��ģʽ
						var bPage =0;					
						if (pageIndex%10==0) {
							bPage = pageIndex - 9;
						} else {
							bPage = pageIndex - pageIndex % 10 + 1;
						}
						var ePage=bPage+10;
						if (pageIndex>1&&bPage>1)
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,1);
							sPageText +=this.setActive(_t,"ҳ��-"+1,"pageNum",1);
						}
						if (bPage>10)
						{
							sPageText +=this.setActive("...","��ʮҳ-Prev 10 Pages","pageDot",(bPage-1));
						}
						for (var i = bPage; i < ePage; i++) {
							if (i<0||i >pageCount) break;
							if(i==pageIndex) {
								var _t = pageText[0].replace(/#{pageIndex}/ig,i);
								sPageText += this.setDisable(_t,"ҳ��-"+i,"pageIndex");
							} else {
								var _t = pageText[1].replace(/#{pageIndex}/ig,i);
								sPageText +=this.setActive(_t,"ҳ��-"+i,"pageNum",i);
							}
						}
						if (pageCount >= bPage + 10)
						{
							sPageText +=this.setActive("...","��ʮҳ-Next 10 Pages","pageDot",(bPage + 10));	
						}
						if (pageIndex<pageCount&&ePage<pageCount)
						{
							var _t = pageText[1].replace(/#{pageIndex}/ig,pageCount);
							sPageText +=this.setActive(_t,"ҳ��-"+pageCount,"pageNum",pageCount);
						}
						break;
					case 3://����:�������ҳ��ģʽ
						for (var i = 1; i <= pageCount; i++) {
							if(i==pageIndex) {
								var _t = pageText[0].replace(/#{pageIndex}/ig,i);
								sPageText += this.setDisable(_t,"ҳ��-"+i,"pageIndex");
							} else {
								var _t = pageText[1].replace(/#{pageIndex}/ig,i);
								sPageText +=this.setActive(_t,"ҳ��-"+i,"pageNum",i);
							}
						}
						break;
					
				}
			}
			temp = temp.replace(/#{recordCount}/ig,sRecordCount);
			temp = temp.replace(/#{pageIndex}/ig,sPageIndex);
			temp = temp.replace(/#{pageSize}/ig,sPageSize);
			temp = temp.replace(/#{pageCount}/ig,sPageCount);
			temp = temp.replace(/#{pageFrist}/ig,sPageFrist);
			temp = temp.replace(/#{pagePrevious}/ig,sPagePrevious);
			temp = temp.replace(/#{pageText}/ig,sPageText);
			temp = temp.replace(/#{pageNext}/ig,sPageNext);
			temp = temp.replace(/#{pageLast}/ig,sPageLast);
			temp = temp.replace(/#{pageInput}/ig,sPageInput);
			temp = temp.replace(/#{pageGo}/ig,sPageGo);
			temp = temp.replace(/#{pageSelect}/ig,sPageSelect);	
			temp = temp.replace(/#{pageSizeSelect}/ig,sPageSizeSelect);	
		}
		if(!id)
		{
			document.getElementById(this.sName).innerHTML=temp;
		}
		else if(!!document.getElementById(id))
		{
			document.getElementById(id).innerHTML=temp;
		}
		else
		{
			document.writeln("<div id=\""+id+"\">"+temp+"</div>");
		}
		return temp;
	},
	getQuery:function(key,url)
	{
		 url = url || window.location.href;
		 var rts = [],rt;
		 queryReg = new RegExp( '(^|\\?|&)' + key + '=([^&]*)(?=&|#|$)','g');
		 while ( ( rt = queryReg.exec( url ) ) != null )
		 {
			rts.push(decodeURIComponent( rt[ 2 ]) );
		 }
		 if ( rts.length == 0 ) return null;
		 if ( rts.length == 1 ) return rts[ 0 ];
		 return rts;
	},
	formatNum:function(sNum,bMin,bMax,iMinNum,iMaxNum){
		var i,iN,sN=""+sNum,iMin=iMinNum,iMax=iMaxNum;
		if (sN.length>0) {
			iN=parseInt(sN,10);
			i=(isNaN(iN))?iMin:iN;
			i=(i<iMin&&bMin==1)?iMin:i;
			i=(i>iMax&&bMax==1)?iMax:i;
		}
		else {
			i=iMin;
		}
		return (i);
	}
}
//Ajax�б�ͨ�÷�ҳ����
var CommonPager = new Web.Pager("CommonPager",3,2,'',"<span class='pageSizeSelectW'>ÿҳ��ʾ#{pageSizeSelect}��</span>#{pageFrist}#{pagePrevious} #{pageText}#{pageNext}#{pageLast}<span class='pageinputgo'>#{pageInput}/#{pageCount}&nbsp;#{pageGo}</span>");CommonPager.setDataText(2,["#{pageIndex}","#{pageIndex}"],["",""],["<img src='/images/lts/prevPage.gif'>",""],["<img src='/images/lts/nextpager.gif'>",""],["",""],["Pages:#{pageIndex}/#{pageCount}","Pages:#{pageIndex}/#{pageCount}"],["Go"]);
//CommonPager.setDataInfo(pageData);
//CommonPager.write("Pager");