(function(w){
	 w.upload_n = 0;// IE下面解决_upLoad函数执行两次
	 w.test_count=0;
	 w.UPLOAD=function(options){
		this.loadTimer=null;
		this.options={
			oldHtml:'',
			srcId:'',
			targetId:'',
			width:100,
			height:30,
			selfName:'',
			path:path+'/ftpOper/upload.html',
			maxLength:'45',// 标注显示路径的长度>30
			type:'1',// 1：图片文件 2：其它文件
			filePath:'',
			filePatharea:'',
			filePathBtn:'',
			newFileName:'fileName',
			parentId:'',
			fileNameBack:'uploadFile',
			callback:null,
			typep:30,
			subType:303,
			maxSize:5,// M
			/*
			 * 正则表达式表示允许类型
			 */
			uploadType:new RegExp('\.(jpg|gif|png|bmp|jpeg)$','i')
		};
		
		for(var p in options){
			this.options[p]=options[p];
		}
		if(!this.options['srcId']){
			alert('父元素未定义，无法使用上传');
		}
		if(!this.options['targetId']){
			alert('目标元素未定义，无法使用上传');
		}
		if(!this.options.path)
			this.options.path = $('#'+this.options.srcId).attr('path-data');
		if(!this.options.filePath)
			this.options.filePath = $('#'+this.options.srcId).attr('file-data');
	};
	UPLOAD.prototype={
		_init:function(){
			var srcPos = $('#'+this.options.srcId).offset();
			this.options.oldHtml = $('#'+this.options.srcId)[0].outerHTML;
			if (this.options.parentId) {
	    		var html ='<div id="'+this.options.srcId+'upload" class="upload-info" style="position:absolute;left:0px;top:0px;height:'+this.options.height+'px;width:100%;">'
						  +'<form id="'+this.options.srcId+'form" action="'+this.options.path+'" target="'+this.options.srcId+'Frame"'
	    				  +'style="position:absolute;top:0;left:0;width:'+this.options.width+'px;height:'+this.options.height+'px;" '
	    				  +'enctype="multipart/form-data" method="post"><input type="hidden" name="type1" value="'+this.options.type+'" />'
						  +'<input type="hidden" name="newFileName" id="newFileName" value="'+this.options.fileName+'" />'
						  +'<input type="hidden" name="type" id="newFileName" value="'+this.options.typep+'" />'
						  +'<input type="hidden" name="subType" id="newFileName" value="'+this.options.subType+'" />'
						  +'<input type="hidden" name="maxSize" value="'+this.options.maxSize+'" />'
						  +'<input id="'+this.options.srcId+'Input" hidefoucs="true" name="'+this.options.fileNameBack+'" '
						  +'onchange="javascript:'+this.options.selfName+'._upload(\''+this.options.selfName+'\'); return false;" '
						  +'type="file" style="width:'+this.options.width+'px;height:'+this.options.height+'px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity: 0;opacity: 0;"/>'
						  +'</form><iframe id="'+this.options.srcId+'Frame" name="'+this.options.srcId+'Frame" style="display:none;"></iframe>'
						  +'<p id="'+this.options.srcId+'load" style="display:none;height:25px;line-height:25px;width:100%;">'
						  +'<img src="'+path+'/images/loading.gif" style="width:20px;height:20px;margin:0 auto;vertical-align:middle;" alt="上传中" title="上传中"/></p>'
						  +'<p id="'+this.options.srcId+'path" style="width:300px;overflow:hidden;text-overflow:ellipsis;white-wrap:nowrap;display:none;"><span id="'+this.options.srcId+'pathspan"> '
						  +this.options.filePath+'</span>&nbsp;&nbsp;<a style="color:#F21D1D;text-decoration:underline;" id="'+this.options.srcId+'patha" '
						  +'href="javascript:void(0)" onclick="javascript:'+this.options.selfName+'._delete(\''+this.options.selfName+'\',\''+this.options.filePath+'\')">删除文件</a></p></div>';
				$('#' + this.options.parentId).append(html);
				$('#' + this.options.parentId).css({'position':'relative'});
			}else {
	    		var html ='<div id="'+this.options.srcId+'upload" class="upload-info" style="position:absolute;left:'+srcPos.left+'px;top:'+srcPos.top+'px;height:'+this.options.height+'px;width:100%;">'
						  +'<form id="'+this.options.srcId+'form" action="'+this.options.path+'" target="'+this.options.srcId+'Frame"'
	    				  +'style="position:absolute;top:0;left:0;width:'+this.options.width+'px;height:'+this.options.height+'px;" '
	    				  +'enctype="multipart/form-data" method="post"><input type="hidden" name="type" value="'+this.options.type+'" />'
						  +'<input type="hidden" name="newFileName" id="newFileName" value="'+this.options.fileName+'" />'
						  +'<input type="hidden" name="type" id="newFileName" value="'+this.options.typep+'" />'
						  +'<input type="hidden" name="subType" id="newFileName" value="'+this.options.subType+'" />'
						  +'<input type="hidden" name="maxSize" value="'+this.options.maxSize+'" />'
						  +'<input id="'+this.options.srcId+'Input" hidefoucs="true"  name="'+this.options.fileNameBack+'" '+
						  +'onchange="javascript:'+this.options.selfName+'._upload(\''+this.options.selfName+'\'); return false;" '
						  +'type="file" style="width:'+this.options.width+'px;height:'+this.options.height+'px;filter:alpha(opacity=0);-moz-opacity:0;-khtml-opacity: 0;opacity: 0;"/>'
						  +'</form><iframe id="'+this.options.srcId+'Frame" name="'+this.options.srcId+'Frame" style="display:none;"></iframe>'
						  +'<p id="'+this.options.srcId+'load" style="display:none;height:25px;line-height:25px;width:100%;">'
						  +'<img src="'+path+'/images/loading.gif" style="width:20px;height:20px;margin:0 auto;vertical-align:middle;" alt="上传中" title="上传中"/></p>'
						  +'<p id="'+this.options.srcId+'path" style="width:300px;overflow:hidden;text-overflow:ellipsis;white-wrap:nowrap;display:none;"><span id="'+this.options.srcId+'pathspan"> '
						  +this.options.filePath+'</span>&nbsp;&nbsp;<a style="color:#F21D1D;text-decoration:underline;" id="'+this.options.srcId+'patha" '
						  +'href="javascript:void(0)" onclick="javascript:'+this.options.selfName+'._delete(\''+this.options.selfName+'\',\''+this.options.filePath+'\')">删除文件</a></p></div>';
				$('body').append(html);
			}
			if(this.options.filePath) this._endDisplay(this);
			else	this._initDisplay(this);
			
				
		},
		_initDisplay:function(self){
			document.getElementById(self.options.srcId).style.visibility='visible';
			document.getElementById(self.options.srcId+'form').style.display='block';
			document.getElementById(self.options.srcId+'load').style.display='none';
			document.getElementById(self.options.srcId+'path').style.display='none';
		},
		_endDisplay:function(self){
			if (!self.options.filePatharea) {
				document.getElementById(self.options.srcId).style.visibility='hidden';
				document.getElementById(self.options.srcId+'form').style.display='none';
				document.getElementById(self.options.srcId+'load').style.display='none';
				document.getElementById(self.options.srcId + 'path').style.display = 'block';
			}else{
				document.getElementById(self.options.filePathBtn).href='javascript:' + self.options.selfName + 
					'._delete("' + self.options.selfName + '","' + self.options.filePath + '");';
				self._initDisplay(self);
			}
		},
		_upload:function(selfName){
			if (Sys.ie) {
				upload_n +=1;
				if(upload_n == 2) return false;
			}
			var self = eval(selfName);
			if(self.loadTimer) return false;
			var filelocalPath = document.getElementById(self.options.srcId+'Input').value;
			if(!filelocalPath){
				alert('文件为空，请重新选择');
				var inputForm = document.getElementById(self.options.srcId+'form');
				$(inputForm).html(inputForm.innerHTML);
				return false;
			}
			var pattern1 = self.options.uploadType;
			if(!(pattern1.test(filelocalPath))){
				alert('文件类型不正确，请重新选择');
				var inputForm = document.getElementById(self.options.srcId+'form');
				$(inputForm).html(inputForm.innerHTML);
				return false;
			}
			if(!(self._isFileSize(document.getElementById(self.options.srcId+'Input'),self.options.maxSize))){
				alert('文件大小最大支持'+self.options.maxSize+'M，请重新选择');
				var inputForm = document.getElementById(self.options.srcId+'form');
				$(inputForm).html(inputForm.innerHTML);
				return false;
			}
			$('body',window.frames[self.options.srcId+'Frame'].document).html('');
			document.getElementById(self.options.srcId+'load').style.display="block";
			document.getElementById(self.options.srcId).style.visibility='hidden';
			self.loadTimer = window.setInterval(selfName+'._loadTest("'+selfName+'")',500);
			document.getElementById(self.options.srcId+'form').submit();
			document.getElementById(self.options.srcId+'form').style.display='none';
			upload_n = 0;
		},
		_loadTest:function(selfName){
			var self = eval(selfName);
			var loadFrame = window.frames[self.options.srcId+'Frame'];
			if(loadFrame&&loadFrame.document.readyState=='complete'){
				var responses = $('body',loadFrame.document).text();
				if (responses){
					test_count = 0;
					responses = responses.replace(/\"|\'/g,'');
					if(responses.length<300){
						if (self.options.callback) {
							self._initDisplay(self);
							self.options.callback.call(self.options,responses);
						}else 
							self._cb(selfName, responses);
					}else{
						alert(responses);
						self._initDisplay(self);
					}
					window.clearInterval(self.loadTimer);
					self.loadTimer = null;
				}else{
					test_count++;
					if(test_count>=120){
						window.clearInterval(self.loadTimer);
						self.loadTimer = null;
						responses = $('body',loadFrame.document).html();
						alert(responses);
						self._initDisplay(self);
					}
				}
			}
		},
		_cb:function(selfName,response){
			var self = eval(selfName);
			document.getElementById(self.options.targetId).value = response;
			var showPath = response;
			if(response.length>30){
				showPath = showPath.substring(0,20)+'...'+showPath.substring(showPath.length-10,showPath.length);
			}
			document.getElementById(this.options.srcId+'load').style.display='none';
			if (self.options.filePatharea) {
				document.getElementById(this.options.filePatharea).innerHTML = showPath;
				document.getElementById(this.options.filePathBtn).href = 'javascript:' + selfName + '._delete("' + selfName + '","' + showPath + '");';
				self._initDisplay(self);
			}else {
				document.getElementById(this.options.srcId+'path').style.display='block';
				document.getElementById(this.options.srcId + 'pathspan').innerHTML = showPath;
				document.getElementById(this.options.srcId + 'patha').href = 'javascript:' + selfName + '._delete("' + selfName + '","' + showPath + '");';
			}
		},
		_delete:function(selfName,filePath){
			var self = eval(selfName);
			var inputForm = document.getElementById(self.options.srcId+'form');
			$(inputForm).html(inputForm.innerHTML);
			$.ajax({
		        url: path+'/common/Upload!delete.action',
		        dataType: 'json',
		        cache: false,
		        async:true,
		        data: {'path':filePath},
		        type: "get",
		        success:function(responseData){
						document.getElementById(self.options.targetId).value='';
						if (self.options.filePatharea) {
							document.getElementById(self.options.filePatharea).innerHTML = '';
						}else{
							self._initDisplay(self);
						}
				},
				error:function(response){
					if(response.responseText.length>100)
						parent.document.write(response.responseText);
					else
						if(response.responseText) alert(response.responseText);
				}
		        
			});
		},
		_isFileSize:function(obj,maxSize){
			var fileSize = 0;
			try {
				if (Sys.ie && !obj.files) {
					var filePath = obj.value;
					var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
					
					if (!fileSystem.FileExists(filePath)) {
						return false;
					}
					var file = fileSystem.GetFile(filePath);
					fileSize = file.Size;
				}
				else {
					fileSize = obj.files[0].size;
				}
				if (fileSize == 0 || fileSize / (1024 * 1024) > maxSize) {
					return false;
				}
			}catch(e){
				
			}
			return true;
		}
	};
	w.Sys = {};
	var s,ua=navigator.userAgent.toLowerCase();
	(s = ua.match(/msie ([\d.]+)/)) ? 
			Sys.ie = s[1] : (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : (s = ua.match(/chrome\/([\d.]+)/)) ? 
			Sys.chrome = s[1] : (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : (s = ua.match(/version\/([\d.]+).*safari/)) ? 
			Sys.safari = s[1] : 0;
})(window)