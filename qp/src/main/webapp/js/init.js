(function(w){
	if(!w.wx)
		var wx = {};
	wx.url={
		'typeq':path+'/type/query.html',
		'typec':path+'/type/queryc.html',
		'cusq':path+'/customer/query.html',
		'cuso':path+'/customer/queryOne.html',
		'cusT':path+'/customer/updateT.html',
		'cusm':path+'/pages/mlist.jsp',
		'garas':path+'/garage/query.html',
		'colS':path+'/customer/colS.html',
		'colR':path+'/customer/colR.html',
		'colM':path+'/customer/colM.html',
		'laudc':path+'/customer/laudc.html',
		'laudr':path+'/customer/laudr.html'
	}
	wx.config={
		appId:'wx6da52a998f50022b',
		appSecret:'fe20a1c6de3a9e2b5924f4ab3941e692',
		redirectUri:'http://www.qponl.com/wxOper/getOpenId.html'
		/*appId:'wxe63bb775563616d7',
		appSecret:'402fea1783fa4047fee0a45c49729ddf',
		redirectUri:'http://192.168.6.100:8080/wxOper/getOpenId.html'*/
	}
	wx.init=function(){
		var imgs=[{id:1,name:'one',url:'javascript:void(0)',img:path+'/images/1.jpg'},{id:2,name:'two',img:'images/2.jpg',url:'javascript:void(0)'}],
			setting={};
		if(types) wx.initTypes(types,'typeLists');
		$('#typeLists').on('click','a',this.overC);
		new wx.sh({renderId:'ads',data:imgs});
	}
	wx.initi=function(){
		var all = this.getArgs('allParmas'),notice = $('.notice-one'),left=0;
		this.ajaxData(this.url.typeq,all,wx.initTypes1);
		if(notice.length>0){
			window.noticeTimer = window.setInterval(function(){
				left = parseInt(notice.css('left'),10);
				left = left?left:0;
				if(left<-600) left=460;
				left -= 1; 
				notice.css({left:left});
			},30);
		}
	}
	wx.initTypes1 =function(responseData){
		var typeData = responseData.data,type=responseData.type,dataT = responseData.data,imgs=responseData.typeImgs,tid=responseData.typeId;
		if(typeData){
			var i=0,len=dataT.length,j=0,lenj=0,ha=[],onet=null,all = this.getArgs('allParmas'),onec=null;
			$('#qtitle').html('北京汽配在线---'+responseData.typeName);
			for(;i<len;i++){
				one = dataT[i];
				onec = one.children;
				onet = one.types;
				ha.push('<li><h4><a id="');
				ha.push(onet.typesId);
				ha.push('" href="javascript:void(0)">');
				ha.push(onet.typesName);
				ha.push('</a><p class="show-t fr"><i class="la-i"></i>浏览(');
				ha.push(onet.typesTimes);
				ha.push(')</p></h4><div class="type-items">');
				if(onec){
					j=0;
					lenj=onec.length;
					for(;j<lenj;j++){
						ha.push('<a onclick="javascript:return wx.toper(');
						ha.push(onec[j].typesId);
						ha.push(');" href="');
						ha.push('?typesPid=');
						ha.push(onec[j].typesId);
						ha.push('" title="');
						ha.push(onec[j].typesName);
						ha.push('">');
						if(tid==1){
							ha.push('<i class="c-logo c-');
							ha.push(onec[j].typesId);
							ha.push('"></i>');
						}
						ha.push(onec[j].typesName);
						ha.push('</a>');
					}
				}
				ha.push('<div class="clear"></div></div></li>');
			}
			if(tid==1) $('#typeLists').addClass('c-items'); 
			$('#typeLists').html(ha.join(''));
		}
		if(imgs){
			var sflag = false;
			for(var im=0;im<imgs.length;im++){
				if(imgs[im].typeImgAddr.indexOf('ad')>-1)
				 sflag=true;
			}
			
			if(sflag) new wx.sh({renderId:'ads',data:imgs});
			else $('#ads').hide();
		}
		else{
			$('#ads').hide();
		}
		$('#footer').show();
	}
	wx.toper=function(typeId){
		var flag;
		this.ajaxData(this.url.typec,{typesPid:typeId},function(responseData){
			if(responseData.messageCode == '20000'){
				flag = true;
			}else{
				if(responseData){
					flag = false;
					window.location.href=responseData;
				}else flag = true;
			}
		},'get',true);
		return flag;
	}
	wx.initm=function(){
		var all = this.getArgs('allParmas');
			w.mscroll = new IScroll('#mc', {useTransition: true,topOffset: 0,hScrollbar:false, vScrollbar:true,probeType:3,preventDefault:false});
		w.setTimeout(function () {document.getElementById('mc').style.left = '0'; }, 800);
		document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
		all['openId']=openId;
		this.ajaxData(this.url.cusq,all,this.mc);
		$('#mlist').on('click','a',wx.addT);
	}
	wx.initg=function(){
		w.mscroll = new IScroll('#mc', {useTransition: true,topOffset: 0,hScrollbar:false, vScrollbar:true,probeType:3,preventDefault:false});
		w.setTimeout(function () {document.getElementById('mc').style.left = '0'; }, 800);
		document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);	
		this.ajaxData(this.url.garas,null,this.gd);
		$('#mc').height($('body').height()-20);
		$('#mc').on('click','.img-a',this.imgScale);
	}
	wx.imgScale=function(){
		var url = $(this).attr('src-data'),
			html='<div class="img-win">'+
			'<div class="overlay"></div><a href="javascript:void(0)" class="del-pic"></a>';
		if(url){
			html+='<img src="'+url+'"/></div>';
			$('body').append(html);
			$('.img-win').on('click',wx.removeO);
		}
	}
	wx.removeO=function(e){
		if($(e.target).hasClass('del-pic')||e.target.tagName.toLowerCase()=='img')
			$('.img-win').remove();
	}
	wx.gd=function(resData){
		var mdata = resData.garage,i=0,len=0,ha=[],one=null;
		if(mdata){
			len=mdata.length;
			for(;i<len;i++){
				one = mdata[i];
				ha.push('<li class="clearfix"><h3><a href="javascript:void(0)">');
				ha.push(one.garageName);
				ha.push('</a></h3>');
				if(one.garageImg){
					ha.push('<a class="img-a" src-data="');
					ha.push(one.garageImg);
					ha.push('" href="javascirpt:void(0)"><img class="gas-img" src="');
					ha.push(path);
					ha.push(one.garageImg);
					ha.push('"/></a>');
				}
				ha.push('<p>区域：');
				ha.push(one.areaName);
				ha.push('</p><p>类别：');
				ha.push(gtypes[one.gtype]);
				ha.push('</p><p>电话：');
				ha.push(one.garagePhone?one.garagePhone:'xxxx');
				ha.push('</p><div class="clear"></div></li>');
			}
		}
		$('#mlist').append(ha.join(''));
		$('#mlist').attr('cp-data',resData.pageInfo.pageNum+1);
		w.mscroll.refresh();
		if(w.mscroll) wx.pageOper(resData.pageInfo,function(){
			var nextnum = $('#mlist').attr('cp-data');
			wx.ajaxData(wx.url.garas,{'pageInfo.currentPage':nextnum},wx.gd);
		});
	}
	wx.initmd=function(){
		var all = this.getArgs('allParmas');
		this.ajaxData(this.url.cuso,all,this.md);
		$('#md').on('click','a',wx.addT);
	}
	wx.addCol=function(obj,cusId){
		cusId = parseInt(cusId,10);
		if(!cusId||!openId){
			alert('参数缺失,请稍后重试');
		}
		this.ajaxData(this.url.colS,{openId:openId,cusId:cusId},function(){
			wx.removeColN(obj,cusId);
		});
	}
	wx.addLaud=function(obj,cusId){
		cusId = parseInt(cusId,10);
		if(!cusId||!openId){
			alert('参数缺失,请稍后重试');
		}
		this.ajaxData(this.url.laudc,{openId:openId,cusId:cusId},function(){
			wx.removeLaudN(obj,cusId);
		});
	}
	wx.removeCol=function(obj,cusId){
		cusId = parseInt(cusId,10);
		if(!cusId||!openId) alert('参数缺失,请稍后重试');
		this.ajaxData(this.url.colR,{openId:openId,cusId:cusId},function(){
				wx.addColN(obj,cusId);
		});
	}
	wx.removeLaud=function(obj,cusId){
		cusId = parseInt(cusId,10);
		if(!cusId||!openId) alert('参数缺失,请稍后重试');
		this.ajaxData(this.url.laudr,{openId:openId,cusId:cusId},function(){
				wx.addLaudN(obj,cusId);
		});
	}
	wx.removeColN=function(obj,cusId){
		obj=$(obj);
		obj.html('<i class="col-i"></i>取消收藏');
		obj.addClass('has-col');
		obj.attr('onclick','wx.removeCol(this,\''+cusId+'\')');
	}
	wx.removeLaudN=function(obj,cusId){
		obj=$(obj);
		obj.html('<i class="dz-i dz-i-n"></i>取消赞');
		obj.addClass('has-col');
		obj.attr('onclick','wx.removeLaud(this,\''+cusId+'\')');
	}
	wx.addColN=function(obj,cusId){
		obj=$(obj);
		obj.html('<i class="col-i col-i-n"></i>收藏');
		obj.removeClass('has-col');
		obj.attr('onclick','wx.addCol(this,\''+cusId+'\')');
	}
	wx.addLaudN=function(obj,cusId){
		obj=$(obj);
		obj.html('<i class="dz-i"></i>赞');
		obj.removeClass('has-col');
		obj.attr('onclick','wx.addLaud(this,\''+cusId+'\')');
	}
	wx.md=function(resData){
		var customer = resData.customer;
		if(customer){
			if(customer.cusPhone1)
				customer.cusPhone1=customer.cusPhone1.length>10?customer.cusPhone1:'010-'+customer.cusPhone1;
			if(customer.cusPhone2)
				customer.cusPhone2=customer.cusPhone2.length>10?customer.cusPhone2:'010-'+customer.cusPhone2;
			wx.replaceReg(customer);
			$('#mtitle').html(customer.cusName+'---北京汽配在线');
			if(customer.imgs){
				var imgh=[];
				for(var i=0,len=customer.imgs.length;i<len;i++){
					imgh.push('<img src="');
					imgh.push(path);
					imgh.push(customer.imgs[i].imgsAddr);
					imgh.push('" alt="');
					imgh.push(customer.cusName);
					imgh.push('" title="');
					imgh.push(customer.cusName);
					imgh.push('"/>');
				}
				$('#imgs').html(imgh.join(''));
				$('.imgs-t').show();
			}
			if(resData.isCol) wx.removeColN($('#colId')[0],customer.cusId);
			if(resData.isLaud) wx.removeLaudN($('#dzId')[0],customer.cusId);
		}
		$('#footer').show();
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
	wx.pageNext=function(){
		var nextnum = $('#mlist').attr('cp-data'),typesId=$('#mlist').attr('type-data'),params = {typesId:typesId,'pageInfo.currentPage':nextnum};
		try{
			params['openId']=openId;
		}catch(e){
		}
		wx.ajaxData(wx.url.cusq,params,wx.mc);
	}
	wx.mc=function(resData){
		var mdata = resData.data,type=resData.type,value=resData.value,i=0,len=0,ha=[],one=null,imgs=resData.typeImgs;
		if(mdata){
			$('#qtitle').html('北京汽配在线---'+value);
			len=mdata.length;
			for(;i<len;i++){
				one = mdata[i];
				ha.push('<li><h3><a href="md.jsp?cusId=');
				ha.push(one.cusId);
				ha.push('&typesId=');
				ha.push(type);
				ha.push('">');
				ha.push(one.cusName);
				ha.push('</a><a class="one-tel" cus-data="');
				ha.push(one.cusId);
				ha.push('" href="tel:4008190789,');
				ha.push(one.cusPhone);
				ha.push('">免费拨号</a></h3><p class="oper-a">');
				if(one.openId){
					ha.push('<a href="javascript:void(0)" onclick="javascript:wx.removeCol(this,\'');
					ha.push(one.cusId);
					ha.push('\')" class="show-t has-col fl"><i class="col-i"></i>取消收藏</a>');
				}else{
					ha.push('<a href="javascript:void(0)" onclick="javascript:wx.addCol(this,\'');
					ha.push(one.cusId);
					ha.push('\')" class="show-t fl"><i class="col-i col-i-n"></i>收藏</a>');
				}
				if(one.lop){
					ha.push('<a href="javascript:void(0)" onclick="javascript:wx.removeLaud(this,\'');
					ha.push(one.cusId);
					ha.push('\')" class="show-t has-col"><i class="dz-i dz-i-n"></i>取消赞');
					ha.push('</a>');
				}else{
					ha.push('<a href="javascript:void(0)" onclick="javascript:wx.addLaud(this,\'');
					ha.push(one.cusId);
					ha.push('\');" class="show-t"><i class="dz-i"></i>赞');
					ha.push('</a>');
				}
				ha.push('<a href="tel:4008190789,');
				ha.push(one.cusPhone);
				ha.push('" class="show-t fr" style="color:#333" cus-data="');
				ha.push(one.cusId);
				ha.push('"><img class="tel-img" src="');
				ha.push(path);
				ha.push('/images/tel.gif"/>拨打');
				ha.push(one.cusTimes);
				ha.push('次</a></p>');
				if(one.cusHeadImg){
					ha.push('<a href="md.jsp?cusId=');
					ha.push(one.cusId);
					ha.push('&typesId=');
					ha.push(type);
					ha.push('">')
					ha.push('<img src="');
					ha.push(path);
					ha.push(one.cusHeadImg);
					ha.push('" class="cus-img"/></a>')
				}
				ha.push('<div class="ml-l ');
				if(one.cusHeadImg) ha.push('ml-hi');				
				ha.push('"><p><label>主营：</label><span>');
				if(one.cusRemark)
					ha.push(one.cusRemark);
				else
					ha.push(one.cusScope);
				ha.push('</span></p><p><label>电话：</label><span><a cus-data="');
				ha.push(one.cusId);
				ha.push('" href="tel:4008190789,');
				ha.push(one.cusPhone);
				ha.push('">4008190789,');
				ha.push(one.cusPhone);
				ha.push('</a>　<a cus-data="');
				ha.push(one.cusId);
				ha.push('" href="tel:');
				ha.push(one.cusPhone1&&one.cusPhone1.length>10?'':'010');
				ha.push(one.cusPhone1);
				ha.push('">');
				ha.push(one.cusPhone1&&one.cusPhone1.length>10?'':'010-');
				ha.push(one.cusPhone1);
				ha.push('</a>　<a cus-data="');
				ha.push(one.cusId);
				ha.push('" href="tel:');
				ha.push(one.cusPhone2&&one.cusPhone2.length>10?'':'010');
				ha.push(one.cusPhone2);
				ha.push('">');
				ha.push(one.cusPhone2&&one.cusPhone2.length>10?'':'010-');
				ha.push(one.cusPhone2);
				ha.push('</a></span></p><p><label>地址：</label><span>');
				ha.push(one.cusAddr);
				ha.push('</span></p></div><div class="clear yellow-bg">公告：部分手机拨打400免费电话无人接听时，需人工输入分机号加“#”即可拨通！！！</div></li>');
			}
		}
		$('#mlist').append(ha.join(''));
		$('#mlist').attr('cp-data',resData.pageInfo.pageNum+1);
		$('#mlist').attr('type-data',resData.type);
		if(resData.pageInfo.pageNum==1){
			if($('#ads').length>0){
				if(imgs){
					var sflag = false;
					for(var im=0;im<imgs.length;im++){
						if(imgs[im].typeImgAddr.indexOf('ad')>-1)
						 sflag=true;
					}
					if(sflag){
						new wx.sh({renderId:'ads',data:imgs});	
					}else{
						$('#ads').hide();
					}
				}
				else{
					$('#ads').hide();
				}
			}
			$('#mc').height($('body').height()-60);
			$('#footer').show();
		}
		w.mscroll.refresh();
		if(w.mscroll) wx.pageOper(resData.pageInfo,wx.pageNext);
	}
	wx.pageOper=function(pageInfo,cb){
		if(pageInfo.totalPages==pageInfo.pageNum){
				w.mscroll.off('refresh');
				w.mscroll.off('scroll');
				w.mscroll.off('scrollEnd');
				var pullUpEl =$('#pullUp');
				pullUpEl.hide();
			}else if(pageInfo.pageNum==1){
				w.mscroll.on('refresh',function () {
					var pullUpEl =$('#pullUp');
					pullUpEl.hide();
					pullUpEl[0].className = '';
					pullUpEl.find('.pullUpLabel').html('上拉加载更多...');
				});
				w.mscroll.on('scroll',function () {
					var pullUpEl =$('#pullUp');
					pullUpEl.show();
					if (this.y < (this.maxScrollY - 10) && !pullUpEl.hasClass('flip')) {
						pullUpEl[0].className = 'flip';
						pullUpEl.find('.pullUpLabel').html('释放查看更多...');
					}
				});
				w.mscroll.on('scrollEnd',function () {
					var pullUpEl =$('#pullUp');
					if (pullUpEl.hasClass('flip')) {
						pullUpEl[0].className = 'loading';
						pullUpEl.find('.pullUpLabel').html('加载中...');
						if(cb) cb();
					}
				});
			}
	}
	wx.addT=function(e){
		var cusId = $(this).attr('cus-data');
		if(cusId) wx.ajaxData(wx.url.cusT,{cusId:cusId});
	}
	wx.overC=function(){
		var that = $(this),content=that.next('ul'),height = content.height(),hdata = content.attr('height-data'),href=that.attr('href');
		if(href!='javascript:void(0)') return false;
		if(height){
			content.attr('height-data',height);
			content.animate({height:0},500,'linear');
		}else{
			content.attr('height-data',0);
			content.animate({height:hdata},500,'linear');
		}
	}
	wx.initTypes =function(typeData,rid){
		if(typeData){
			var ha = this.findC(typeData);
			if(ha) $('#'+rid).html(ha.join(''));
		}
	}
	wx.findC=function(nodes){
		var i=0,len=nodes.length,onec=null,ha=[];
		for(;i<len;i++){
			one=nodes[i];
			onec=one.children;
			ha.push('<li class="level');
			ha.push(one.level);
			ha.push('"><a id="');
			ha.push(one.id);
			ha.push('" href="javascript:void(0)">');
			ha.push(one.name);
			ha.push('</a>');
			if(onec){
				ha.push('<ul class="type-items">');
				var  cp=arguments.callee(onec);
				ha = ha.concat(cp);
				ha.push('<div class="clear"></div></ul>');
				
			}
			ha.push('</li>');
		}
		return ha;
	}
	wx.sh=function(options){
		this.autoTimer=null;
		this.options={
			renderId:null,
			data:null,
			sp:3000,
			startX:-1,
			endX:0,
			isauto:true,
			ule:null,
			cb:null,
			nid:true,
		}
		for(var p in options){
			this.options[p]=options[p];
		}
		this.init();
	}
	wx.sh.prototype={
		init:function(){
			var that=this,i=0,ha=[],one=null,obj=$('#'+this.options.renderId);
			if(!this.options.data){
				wx.alertWin('未找到数据');
				return false;
			}
			if(obj.length<1){
				wx.alertWin('未找到渲染的对象');
				return false;
			}
			len=this.options.data.length;
			ha.push('<ul class="sp-list" style="width:');
			ha.push(480*len);
			ha.push('px;">');
			if(len){
				if(this.options.nid){
					var random=Math.floor(Math.random()*len), first=this.options.data.splice(random==3?2:random,1);
					this.options.data.unshift(first[0]);
				}
				for(;i<len;i++){
					one=this.options.data[i];
					ha.push('<li><a href="');
					if(one.cusId){
						ha.push(path);
						ha.push('/pages/md.jsp?cusId=');
						ha.push(one.cusId);
						ha.push('&typesId=');
						ha.push(one.typeId);
						ha.push('" cus-data="');
						ha.push(one.cusId);
						ha.push('">');
					}else
						ha.push('tel:010-57462327">');
					ha.push('<img class="sh-img" src="');
					ha.push(path);
					ha.push(one.typeImgAddr);
					ha.push('"/></a></li>');
				}
			}
			ha.push('<li class="li-clear"></li></ul><p class="sh-t">');
			i=0;
			for(;i<len;i++){
				ha.push('<a href="javascript:void(0)" class="sh-p ');
				if(i==0) ha.push('sh-p-on');
				ha.push('" idx-data="');
				ha.push(i);
				ha.push('"></a>');
			}
			ha.push('</p>');
			obj.html(ha.join(''));
			that.options.ule = obj.find('.sp-list');
			one = that.options.ule[0];
			if(this.options.cb) $(one).on('click','a',this.options.cb);
			obj.on('click','.sh-p',function(){
				that.showIm(this);
			});
			one.addEventListener('touchstart',function(e){
				that.options.startX=e.touches[0].screenX;
				that.clearSwit();
			},false);
			one.addEventListener('touchend',function(e){
				that.spend();
			},false);
			one.addEventListener('touchmove',function(e){
				that.spmove(e);
			},false);
			that.autoSwit();
		},
		spend:function(){
			var that=this,obj=that.options.ule,endx=parseInt(obj.css('left'),10),endn=0,isn=obj.attr('data-direct');
			that.options.startX=-1;
			endx=endx?endx:0;
			endx = Math.abs(endx);
			endn = endx/480;
			console.log(endn);
			console.log(isn);
			if(isn=='false') endn=endn%480>80?Math.floor(endn):Math.ceil(endn);
			else endn=endn%480>80?Math.ceil(endn):Math.floor(endn);
			if(endn>2) endn=2;
			if(endn<0) endn=0;
			console.log(endn);
			var one=$('#'+this.options.renderId).find('a[idx-data="'+endn+'"]');
			that.showIm(one);
			window.setTimeout(function(){
				that.autoSwit();
			},200);
		},
		spmove:function(e){
			var that=this,obj=that.options.ule,leftx=parseInt(obj.css('left'),10),endx=e.touches[0].screenX-that.options.startX,leftx=leftx?leftx:0;
			that.options.startX=e.touches[0].screenX;
			if(that.autoTimer) that.clearSwit();
			if(Math.abs(endx)>10) e.preventDefault();
			obj.css({'left':leftx+endx});
			obj.attr('data-direct',endx>0?true:false);
		},
		autoSwit:function(){
			var that=this,obj=$('#'+this.options.renderId),one=null;
			if(!that.options.isauto) return false;
			if(that.autoTimer) return false;
			that.autoTimer=window.setInterval(function(){
				var onp=obj.find('.sh-p-on'),len=obj.find('.sh-p').length,idx=onp.attr('idx-data');
				if(typeof idx !='undefined'){
					idx=parseInt(idx,10);
					if(idx==(len-1)) idx=0;
					else idx++;
					one=obj.find('a[idx-data="'+idx+'"]');
					that.showIm(one);
				}
			},that.options.sp);
		},
		clearSwit:function(){
			if(!this.autoTimer) return false;
			window.clearInterval(this.autoTimer);
			this.autoTimer=null;
		},
		showIm:function(obj){
			obj = $(obj);
			var idx=obj.attr('idx-data'),objp=$('#'+this.options.renderId),obju=objp.find('.sp-list');
			if(typeof idx == 'undefined') return false;
			objp.find('.sh-p-on').removeClass('sh-p-on');
			obj.addClass('sh-p-on');
			obju.animate({left:'-'+(480*idx)},100,'linear');
		}
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
	wx.getArgs=function(name){
		var location = w.location,searchs = location.search;
	    if (!searchs) 
	        return {};
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
	wx.codeOper = function(){
		window.localStorage.setItem('redirect_uri',window.location.href);
		var uri='appid='+wx.config.appId+'&redirect_uri='+encodeURIComponent(wx.config.redirectUri)+'&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect';
		window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?'+uri;
		
	}
	wx.initml=function(){
		this.ajaxData(this.url.colM,{openId:openId},function(resData){
			if(resData.data){
				var i=0,len=resData.data.length,hl=[],one=null;
				for(;i<len;i++){
					one = resData.data[i];
					hl.push('<li><a class="name-l" href="');
					hl.push(path);
					hl.push('/pages/md.jsp?cusId=');
					hl.push(one.cusId);
					hl.push('">');
					hl.push(one.cusName);
					hl.push('</a><a href="javascript:void(0)" onclick="javascript:wx.removeCol(this,\'');
					hl.push(one.cusId);
					hl.push('\')" class="show-t has-col fr"><i class="col-i"></i>取消收藏</a>');
				}
				$('#mlist').html(hl.join(''));
			}
		});
	}
	wx.navOper=function(){
		var obj = $(this),navObj = obj.children('.nav-c');
		if(navObj&&navObj.length>0){
			var opacity = navObj.css('opacity');
			opacity = parseInt(opacity,10);
			if(!opacity){
				navObj.show();
				navObj.animate({'opacity':1},1000,function(){
					navObj.css({'border-width':1});
				});
			}else{
				navObj.animate({'opacity':0},1000,function(){
					navObj.css({'border-width':0,'display':'none'});
				});
			}
		}
	}
	w.wx = wx;
})(window);
(function(w){
	var cna = $('a[title="站长统计"]');
	wx.cnTimer = window.setInterval(function(){
		if(cna.length>0){
			cna.remove();
			if(wx.cnTimer){
				window.clearInterval(wx.cnTimer);
				wx.cnTimer=null;
			}
		}
	},50);
	$('.nav').on('click','.first',wx.navOper);
})(this);
