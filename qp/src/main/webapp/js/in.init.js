(function(w){
	if(!w.wx)
		var wx = {};
	wx.URL={
		'maxphone':path+'/customer/findMaxPhone.html',
		'cusc':path+'/customer/createOne.html',
		'typeO':path+'/type/queryTone.html',
		'typesAll':path+'/type/queryAll.html',
		'typeSt':path+'/type/stickCus.html',
		'typeImgs':path+'/type/getTimgs.html',
		'typeImgC':path+'/type/timgsC.html',
		'cuso':path+'/customer/queryOne.html',
		'qcp':path+'/customer/queryP.html',
		'qdel':path+'/customer/deleteCus.html'
	}
	wx.cusInit=function(){
		var params = this.getArgs('allParmas'),cusInfo=null,cusIds=null;
		this.uploadin(1,4);
		if(params){
			wx.ajaxData(this.URL.cuso,params,function(resData){
				cusInfo = resData;
				if(cusInfo.customer){
					$('.input').each(function(){
						$(this).val(cusInfo.customer[$(this).attr('name')]);
					});
					$('.input[name="cusScopeName"]').val('');
					$('.input[name="cusScope"]').val(cusInfo.type);
					if(cusInfo.customer.imgs){
						var iconA=document.getElementById('iconBa');
						for(var i=0,len=cusInfo.customer.imgs.length;i<len;i++){
							wx.iconAdd.call(iconA,i);
							wx.showCbi(cusInfo.customer.imgs[i].imgsAddr,'idUploadAreaa'+i,'idValuea'+i);
						}
					}
					if(cusInfo.customer.cusHeadImg) wx.showCbi(cusInfo.customer.cusHeadImg,'idUploadArea1','idValue1');
				}
			},null,true);
		}else{
			wx.ajaxData(wx.URL.maxphone,null,function(responseData){
				$('input[name="cusPhone"]').val(responseData.phone);
			});
			this.iconAdd.call(document.getElementById('iconBa'));
		}
		wx.ajaxData(wx.URL.typesAll,null,function(resData){
			var znodes=wx.typeTtree(resData.oneData);
			$.fn.zTree.init($('#typeTree'),{
					/*async:{url:this.URL.typeO,autoParam:['typesId=TypesPid'],enable:true,dataFilter:this.typeFilter},*/
					check:{enable:true,autoCheckTrigger:false,chkStyle: "checkbox",chkboxType: {'Y':'',N:''}},
					data:{key:{name:'typesName'},
							simpleData:{enable:true,idKey:'typesId',pIdKey:'typesPid'}},
					callback:{onCheck:this.typeSel}
			},znodes);
		},null,true);
		if(cusInfo&&cusInfo.type){
			cusIds = cusInfo.type.split(',');
			var typeZt = $.fn.zTree.getZTreeObj("typeTree"),selNode=null;
			for(var i=0,len=cusIds.length;i<len;i++){
				 selNode = typeZt.getNodeByParam('typesId', cusIds[i], null);
				 if(selNode) typeZt.checkNode(selNode,true,false,true);
			}
		}
		$('#cusSubmit').bind('click',this.cusForm);
		$('#iconBa').bind('click',this.iconAdd);
	}
	wx.cusIns=function(){
		$('#queryForm').attr('action',this.URL.qcp);
		$('#queryForm').attr('oper-data','cusInR');
		$('#queryBtn').bind('click',this.qci);
		this.qci();
		$('#resultBody').on('click','.del-cus',this.cusDelete);
		$('#resultBody').on('click','.up-cus',this.cusUp);
		wx.ajaxData(wx.URL.typesAll,null,function(resData){
			var znodes=wx.typeTtree(resData.oneData);
			$.fn.zTree.init($('#typeTree'),{
					check:{enable:true,autoCheckTrigger:false,chkStyle: "radio",radioType :'all',chkboxType: {'Y':'',N:''}},
					data:{key:{name:'typesName'},
							simpleData:{enable:true,idKey:'typesId',pIdKey:'typesPid'}},
					callback:{onCheck:this.insTypeSel}
			},znodes);
		},null,true);
		if(tpi){
			$('#iconBa').bind('click',this.addTypeImgs);
			$('.upload-right').on('click','.t-sel-btn',this.selOperCus);
			$('.upload-right').on('click','.submit-btn',this.typeImgUpdate);
		}
	}
	wx.typeImgUpdate=function(){
		var obj=$(this),pe=obj.parent(),
			typeImgAddr = pe.prev('input[name="typeImgAddr"]').val(),
			cusId = pe.find('input[name="cusId"]').val(),
			typeImgId = pe.find('input[name="typeImgId"]').val(),
			typeId=$.fn.zTree.getZTreeObj("typeTree").getCheckedNodes(true)[0].typesId;
		if(!typeImgAddr){
			alert('请上传图片');
			return false;
		}
		if(!cusId){
			alert('请选择商户');
			return false;
		}
		wx.ajaxData(wx.URL.typeImgC,{typeImgAddr:typeImgAddr,cusId:cusId,typeImgId:typeImgId,typeId:typeId},function(resData){
			if(resData.messageCode=='20000'){
				alert('保存成功');
			}else{
				alert(resData.description);
			}
		});
	}
	wx.selOperCus=function(){
		var obj=$(this);
		$('.sel-on-btn').removeClass('sel-on-btn');
		obj.addClass('sel-on-btn');
	}
	wx.cusUp=function(){
		var obj=$(this),cusId=obj.attr('id-data'),typeId=$('input[name="typesId"]').val(),cp=0;
		if(!typeId||!cusId){
			alert('参数缺失');
			return false;
		}
		wx.ajaxData(wx.URL.typeSt,{cusId:cusId,typesId:typeId},function(resData){
			if(resData.messageCode=='20000'){
				cp=$('#pages').children('.page-on').attr('item-data');
				obj = obj.parent().parent();
				if(cp==1){
					obj.animate({height:0},500,function(){
						obj.parent().prepend(obj);
						obj.remove();
					});
				}else{
					obj.animate({height:0},500,function(){
						obj.remove();
					});
				}
			}else{
				alert(resData.description);
			}
		});
	}
	wx.insTypeSel=function(e,treeId,obj){
		var typeId = obj.typesId;
		if(tpi){
			$('.upload-right').html('');
			wx.ajaxData(wx.URL.typeImgs,{typesId:typeId},function(resData){
				
				if(resData.typeImgs){
					for(var i=0,len=resData.typeImgs.length;i<len;i++){
						wx.addTypeImgs(resData.typeImgs[i]);
					}
				}
			});
		}else{
			$('input[name="typesName"]').val(obj.typesName);
			$('input[name="typesId"]').val(obj.typesId);
		}
	}
	wx.addTypeImgs=function(obj){
		var iconA= document.getElementById('iconBa'),idx=wx.iconAdd.call(iconA);
		if(obj.typeImgAddr) wx.showCbi(obj.typeImgAddr,'idUploadAreaa'+idx,'idValuea'+idx);
		if(!obj) obj={};
		$('.upload-right').append('<p class="t-name-oper"><input type="text" name="cusName" value="'+(obj.cusName?obj.cusName:'')+'" readOnly="true" class="input"/>'+
			'<input type="hidden" value="'+(obj.cusId?obj.cusId:'')+'" name="cusId"/><input type="hidden" value="'+(obj.typeImgId?obj.typeImgId:'')+'" name="typeImgId"/><a href="javascript:void(0)" class="btn t-sel-btn">选择</a><a href="javascript:void(0)" class="btn submit-btn">提交</a></p>');
	}
	wx.cusDelete=function(){
		var obj=$(this),cusId=$(this).attr('id-data');
		if(!cusId) return false;
		wx.ajaxData(wx.URL.qdel,{cusId:cusId},function(resData){
			if(resData.messageCode=='20000'){
				obj = obj.parent().parent();
				obj.animate({height:0},500,function(){
					obj.remove();
				});
			}else{
				alert(resData.description);
			}
		});
	}
	wx.cusInR=function(resData){
		if(resData){
			var hl='',i=0,len=resData.length,one=null,ha=[];
			for(;i<len;i++){
				one = resData[i];
				ha.push('<tr><td>');
				ha.push(one.cusName);
				ha.push('</td><td>');
				ha.push(one.cusPhone);
				ha.push('</td><td>')
				if(one.cusHeadImg){
					ha.push('<img src="');
					ha.push(one.cusHeadImg);
					ha.push('" class="in-head-img"/>');
				}
				ha.push('</td><td>');
				ha.push(new Date(one.cusDate).Format('yyyy-MM-dd hh:mm:ss'));
				ha.push('</td>');
				if(!tpi){
					ha.push('<td><a class="href-a" href="');
					ha.push(path);
					ha.push('cusInput.jsp?cusId=');
					ha.push(one.cusId);
					ha.push('&cusTimes=1">修改</a><a href="javascript:void(0)" class="href-a del-cus" id-data="');
					ha.push(one.cusId);
					ha.push('">删除</a><a href="javascript:void(0)" class="href-a up-cus" id-data="');
					ha.push(one.cusId);
					ha.push('">置顶</a></td>');
				}else{
					ha.push('<td><a href="javascript:void(0)" onclick="wx.selCusT(');
					ha.push(one.cusId);
					ha.push(',\'');
					ha.push(one.cusName);
					ha.push('\')" class="href-a">选择</a></td>');
				}
				ha.push('</tr>');
			}
			$('#resultBody').html(ha.join(''));
		}
	}
	wx.selCusT=function(cusId,cusName){
		if($('.sel-on-btn').length<=0){
			alert('请选择目标广告位');
			return false;
		}
		var pe = $('.sel-on-btn').parent();
		pe.find('input[name="cusId"]').val(cusId);
		pe.find('.input[name="cusName"]').val(cusName);
	}
	wx.qci=function(){
		var qf=$('#queryForm'),params = qf.serialize(),url=qf.attr('action'),oper=qf.attr('oper-data');
		new wx.Pages({rdoper:wx[oper],url:url,params:wx.sertoJson(params)});
	}
	wx.iconAdd=function(e,inx){
		var th=$(this),name=th.attr('name-data'),uploadp=th.parent().parent(),rendp=uploadp.find('.upload-right'),uploads=uploadp.find('.upload-area'),idx=uploads.length,idx=idx++,idx =inx?inx:idx,
			type=th.attr('type-data'),
			hl='<div id="idUploadAreaa'+idx+'" class="upload-area"><a id="iduploada'+idx+'" class="ui-button" file-data="" path-data="" disabled="true">上传图片</a></div><input id="idValuea'+idx+'" name="'+(name?name:'prodTripList.tripPicList.tripPicUrl')+'" value="" type="hidden"/>';
		rendp.append(hl);
		w['upa'+idx] = new UPLOAD({'srcId':'iduploada'+idx,'targetId':'idValuea'+idx,'width' : 140,'height' : 100,
				'callback':wx.ucb,'selfName' : 'upa'+idx,'parentId':'idUploadAreaa'+idx,'fileNameBack':'file',typep:type
			});
		w['upa'+idx]._init();
		return idx;
	}
	wx.typeTtree=function(data){
		if(!data)
			return [];
		if(!nodes) nodes=[];
		var nodes = [], hash = {}, id = 'typesId', pid = 'typesPid', children = 'children', i = 0,len = data.length;  
		for(; i < len; i++){
			hash[data[i][id]] = data[i];
			data[i].isParent=true;
		}
		i=0;
		for(;i<len;i++){  
		    var child = data[i],node = hash[child[pid]];  
		    if(node){
		        !node[children] && (node[children] = []);  
		        node[children].push(child);  
		    }else{  
		      	nodes.push(child);  
		    }
		}
		console.log(nodes);
		return nodes;  
	}
	wx.typeFilter=function(treeId,pnode,resData){
		var data = resData.oneData;
		if(data){
			for(var i=0,len=data.length;i<len;i++){
				data[i].isParent=true;
			}
		}else{
			pnode.isParent=false;
		}
		return data;
	}
	wx.typeSel=function (e,treeId,node){
		var treeObj = $.fn.zTree.getZTreeObj(treeId),nodes = treeObj.getCheckedNodes(true),typeIds=[],typeNames=[];
		for(var i=0,len=nodes.length;i<len;i++){
			typeIds.push(nodes[i].typesId);
			typeNames.push(nodes[i].typesName);
		}
		$('textarea[name="cusScopeName"]').val(typeNames.join(','));
		$('input[name="cusScope"]').val(typeIds.join(','));
	}
	wx.cusForm=function(){
		var cusImgsh=$('input[name="cusImgs.imgsAddr"]'),formData = null,cusImgs=[];
		if(cusImgsh&&cusImgsh.length>0){
			for(var i=0,len=cusImgsh.length;i<len;i++){
				cusImgs.push('cusImgs['+i+'].imgsAddr='+cusImgsh[i].value);
			}
		}
		cusImgsh.attr('disabled',true);
		formData=decodeURIComponent($('#cusForm').serialize(),true);
		formData+='&'+cusImgs.join('&');
		wx.ajaxData(wx.URL.cusc,formData,function(responseData){
			/*var cusp = $('input[name="cusPhone"]');
			cusp.val(parseInt(cusp.val(),10)+1);
			cusImgsh.attr('disabled',false);*/
			alert('保存成功');
			window.location.reload();
		},post);
	}
	wx.ajaxData=function(uri,registData,cb,type,async){
		var atype = 'get';
		if(type) atype=type;
		$.ajax({
			url : uri,
			type : atype,
			data:registData,
			async:!async,
			cache:false,
			dataType:'json',
		//	contentType:'application/json',
			success :function(responseData){
				if(responseData.messageCode == '20000'){
					if(cb) cb.call(w.wx,responseData,responseData.pageInfo);
				}else if(responseData.messageCode == '20010'){//重定向
					if(cb) cb.call(w.wx,responseData.description);
					else window.location.href=responseData.description;
				}
			},
			error : function(e) {
				console.log(e.responseText);
			}
		});
	}
	wx.uploadin = function(idx,type){
		var ele = document.getElementById('idupload'+idx);
		if(!ele) return false;
		w['up'+idx] = new UPLOAD({'srcId' : 'idupload'+idx,'targetId' : 'idValue'+idx,'width' : 140,'height' : 100,
				'callback' : this.ucb,'selfName' : 'up'+idx,'parentId' : 'idUploadArea'+idx,'fileNameBack':'file',typep:type
			});
		w['up'+idx]._init();
	}
	wx.ucb = function(data){
		data = data.replace(/\{/g,'').replace(/\}/g,'')
		var items = data.split(','),dataJ={},item1s=null,oname=null;
		if(items.length==2){
			item1s = items[0].split(':');
			oname = item1s.shift();
			dataJ[oname] = item1s.join(':');
			item1s = items[1].split(':');
			oname = item1s.shift();
			dataJ[oname] = item1s.join('');
			if(dataJ.messageCode==20000){
				wx.showCbi(dataJ.imageUrl,this.parentId,this.targetId);
			}else{
				alert(dataJ.description);
			}
		}
	}
	wx.showCbi=function(url1,parentId,targetId){
		var url = url1,lh='',
		lh='<img src="'+url+'" class="up-end-img"/><a href="javascript:void(0)" onclick="wx.removePic(\''+parentId+'\',\''+targetId+'\')" class="del-pic" title="删除图片"></a>'
		$('#'+parentId).prepend(lh);
		$('#'+parentId).children('.upload-info').hide();
		$('#'+targetId).val(url1);
	}
	wx.removePic=function(parentId,targetId){
		var parentE = $('#'+parentId),url = $('#'+targetId).val();
		parentE.find('.upload-info').show();
		parentE.find('.up-end-img').remove();
		parentE.find('.del-pic').remove();
		$('#'+targetId).val('');
		//服务器删除 图片  后台接口暂缺
		this.ajaxData(path+'/ftpOper/delete.html',{imageUrl:url});
	}
	wx.getArgs=function(name){
		var location = w.location,searchs = location.search;
	    if (!searchs) 
	        return false;
		var 
		searchs = w.decodeURIComponent(searchs);
	    var args = new Object(),query = searchs.substring(1),pairs = query.split("&"),argname='',value='',pos=-1;
	    for (var i = 0; i < pairs.length; i++) {
	        pos = pairs[i].indexOf('=');
	        if (pos == -1) 
	            continue;
	        argname = pairs[i].substring(0, pos);
	        value = pairs[i].substring(pos + 1);
	        value = decodeURIComponent(value);
			args[argname] = value;
	    }
	    if (name == 'allParmas') 
	        return args;
	    return args[name]; // Return the object
	}
	wx.replaceReg=function(data){
		if(!data) return false;
		var reg = null,j=0,value='';
		$('.reg-rep').each(function(i){
			var obj=$(this),hl = obj.html(),p=obj.attr('reg-data'),pa=p.split(','),reg1='';
			for(j=0;j<pa.length;j++){
				reg1= pa[j].replace(/\./g,'\\.');
				reg=new RegExp('#\\('+reg1+'\\)','g');
				value = data[pa[j]]?data[pa[j]]:'';
				hl = hl.replace(reg,value);
				reg=null;
			}
			obj.html(hl);
			obj.removeAttr('reg-data');
		});
		$('.reg-rep').removeClass('reg-rep');
	}
	wx.Pages=function(options){
		this.options={
			pageid:'pages',
			tid:'topPage',
			params:null,
			url:'',
			isrd:false,
			rdoper:null,
			cp:1,
			tp:0,
			perp:10
		}
		for(var p in options){
			this.options[p]=options[p];
		}
		if(!this.options.params) this.options.params={};
		this.options.params.pageInfo={currentPage:this.options.cp,pageNum:this.options.perp};
		this.pqi();
	}
	wx.Pages.prototype={
		pqi:function(){
			var that=this,url= this.options.url,params=this.options.params,pin=params.pageInfo;
			if(pin){
				for(var p in pin){
					if(p!='currentPage'){
						delete pin[p];
					}
				}
				pin.pageNum=this.options.perp;
			}
			$.ajax({url : path+url,type : 'get',data:wx.jsonToSer(params),async:true,cache:false,dataType:'json',
				success :function(responseData){
					if(responseData.messageCode == '20000'){
						if(that.options.rdoper) that.options.rdoper.call(that,responseData.data);
						that.options.params.pageInfo = responseData.pageInfo;
						if(that.options.isrd) that.pageCoper();
						else {
							that.pageInit();
							that.options.isrd=true;
						}
					}else{
						if(responseData.messageCode == 43002) {
							wx.loginWin(1);
						} else if(responseData.messageCode == 42016) {
							wx.loginWin();
						}
					}
				},
				error : function(e) {
					console.log(url);
				}
			});
		},
		pageInit:function(){
			var that=this,pid=that.options.pageid,tid=that.options.tid,oper=that.options.qoper,hArr=null,pd=$('#'+pid),pin=that.options.params.pageInfo;
			if(!pin) return false;
			if(!pid){
				wx.alertWin('未找到分页元素');
				return false;
			}
			hArr=['<a href="javascript:void(0)" class="pre-btn-p"><i class="angle-i enable-i-l disable-i-l"></i>上一页</a>'];
			var  spa=[];
			for(var i=1;i<=pin.totalPages;i++){
				if(pin.totalPages<11){
					spa.push(i);
				}else {
					if(pin.totalPages>10&&(i>3||i<(pin.totalPages-3)))
					{
						if(i==pin.pageNum){
							spa.push('...');
							spa.push(i-1);
							spa.push(i);
							spa.push(i+1);
							spa.push('...');
						}else continue;
					}else{
						span.push(i);
					}
				}
			}
			for(var i=1;i<=pin.totalPages;i++){
					hArr.push('<a href="javascript:void(0)" item-data="');
					hArr.push(i);
					hArr.push('" class="');
					if(i==pin.pageNum) hArr.push('page-on');
					hArr.push('">');
					hArr.push(i);
					hArr.push('</a>');
			}
			hArr.push('<a href="javascript:void(0)" class="pre-btn-p next-btn-p">下一页<i class="angle-i ');
			if(pin.totalPages==pin.pageNum) hArr.push('disable-i-r');
			else hArr.push('enable-i-r');
			hArr.push('"></i></a>');
			pd.html(hArr.join(''));
			if(tid){
				hArr = '共<i class="t-num">'+pin.totalRows+'</i>个产品<i>'+pin.pageNum+'/'+pin.totalPages+'</i><a href="javascript:void(0)" class="pre-btn-t"></a><a href="javascript:void(0)" class="pre-btn-t next-btn-t"></a>';
				$('#'+tid).html(hArr);
				$('#'+tid).on('click','a',function(){
					var operObj = null;
					if($(this).hasClass('next-btn-t'))
						operObj = pd.find('.next-btn-p')[0];
					else 
						operObj = pd.find('.pre-btn-p')[0];
					that.pageOper(operObj);
				})
			}
			pd.off('click');
			pd.on('click','a',function(){
				that.pageOper(this);
			});
		},
		pageOper:function(obj){
			var obj = $(obj),tp=this.options.params.pageInfo.totalPages,cp=this.options.params.pageInfo.pageNum;
			if(obj.hasClass('page-on')) return false;
			if(obj.hasClass('next-btn-p')){
				if(obj.find('.disable-i-r').length>0) return false;
				if(cp<tp) cp++;
			}else if(obj.hasClass('pre-btn-p')){
				if(obj.find('.disable-i-l').length>0) return false;
				if(cp>1) cp--;
			}else{
				cp = obj.attr('item-data');
			}
			this.options.params.pageInfo.currentPage=cp;
			this.pqi();
		},
		pageCoper:function(){
			var options = this.options,po=$('#'+options.pageid),pin=options.params.pageInfo;
			po.find('.page-on').removeClass('page-on');
			po.find('a[item-data="'+pin.pageNum+'"]').addClass('page-on');
			po.find('.disable-i-l').removeClass('disable-i-l');
			po.find('.disable-i-r').removeClass('disable-i-r');
			po.children('.pre-btn-p').each(function(){
				obj = $(this);
				if(obj.hasClass('next-btn-p')){
					objc=obj.children('.enable-i-r');
					if(objc.hasClass('disable-i-r')) objc.removeClass('disable-i-r');
				    if(pin.pageNum==pin.totalPages) objc.addClass('disable-i-r');
				}else{
					objc=obj.children('.enable-i-l');
					if(objc.hasClass('disable-i-l')) objc.removeClass('disable-i-l');
				    if(pin.pageNum==1) objc.addClass('disable-i-l');
				}
			});
			if(options.tid){
				var tnum = $('#'+options.tid).find('i')[1];
				$(tnum).html(pin.pageNum+'/'+pin.totalPages);
			}
		}
	}
	wx.sertoJson=function(s){
		if(!s) return {};
		var sa = s.split('&'),rst={},rst1=[],sai=null,said=null,
			combi=function(ps,pv){
				//ps 属性信息数组列表 pv 属性值
				if(!ps||ps.length<1) return {};
				var tmp2={},one = ps[0];
				if(ps.length==1){
					 tmp2[one] = pv;
				}else{
				 	ps.shift();
				 	if(one.indexOf('List')>-1) tmp2[one]=[arguments.callee(ps,pv)];
					else tmp2[one]=arguments.callee(ps,pv);
				}
				return tmp2;
			},
			combi1=function(rst,one){
				var tmp3=null;
				for(var pi in one){
					tmp3 = rst[pi];
					if(typeof tmp3 =='undefined'){
						rst[pi] = one[pi];
					}else if(tmp3 instanceof Array){
						var tmp4=null;
						for(var i=0,tlen=tmp3.length;i<tlen;i++){
							tmp4 = arguments.callee(tmp3[i],one[pi][0]);
							if(i==(tlen-1)&&tmp4&&tmp4.isNewi){
								tmp3.push(tmp4);
							} 
							delete tmp4.isNewi;
						}
					}else if(typeof tmp3 == 'object'){
						rst[pi]=arguments.callee(rst[pi],one[pi]);
					}else{
						one.isNewi = true;
						return one;
					}
				}
				return rst;
			}
		for(var i=0,len=sa.length;i<len;i++){
			sai = sa[i].split('='),said = sai[0].split('.');
			if(sai.length>2){
				var values = sai.splice(1,(sai.length-1));
				sai.push(values);
			}
			rst1.push(combi(said,sai[1]));
		}
		for(i=0,len=rst1.length;i<len;i++){
			combi1(rst,rst1[i]);
			console.log(rst);
		}
		return rst;
	}
	wx.jsonToSer = function(jn,spo,ia,io){
		var str=[],sp='&',
			jni=function(one,p){
				if(!one) return false;
				if(!p) p='';
				var str1=[],isA = one instanceof Array;
				for(var po in one){
					if(isA){
						str1 = str1.concat(arguments.callee(one[po],p+'['+po+'].')); 
					}else if(one[po] instanceof Object){
						if(one[po] instanceof Array) str1 = str1.concat(arguments.callee(one[po],p+po)); 
						else str1 = str1.concat(arguments.callee(one[po],p+po+'.')); 
					}else{
						if(ia){
							var oneb={};
							oneb[p+po]=one[po];
							str1.push(oneb);
						}else str1.push(p+po+'='+one[po]);
					}
				}
				return str1;
			};
		if(spo) sp=spo;
		str = str.concat(jni(jn));
		if(ia){
			var tarObj = {}
			for(var i=0,len=str.length;i<len;i++){
				var obj1=str[i];
				for(var pi in obj1 ){
					tarObj[pi]=obj1[pi];
				}
			}
			return tarObj;
		}else return str.join(sp);
	}
	w.wx = wx;
})(window)
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}