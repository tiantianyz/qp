<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=path%>">
		<meta charset="utf-8">
		<meta name="Keywords" content="汽配,北京,北京汽配,北京汽配在线">
		<title>北京汽配在线</title>
		<meta http-equiv="Pragma" content="no-cache">
		<link rel="stylesheet" media="all" href="<%=path%>/css/in.style.css">
		<link rel="stylesheet" media="all" href="<%=path%>/js/ztree/zTreeStyle.css">
		<script type="text/javascript" src="<%=path %>/js/jquery/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript" src="<%=path %>/js/func.upload.js"></script>
	</head>
<body>
	<h3 class="header">修理厂信息录入</h3>
	<div class="content">
		<ul id="typeTree" class="con-left ztree"></ul>
		<div class="con-right">
			<form id="garaForm">
				<div class="one-line">
					<label>名称</label><input type="text" name=garageName class="input"/>
				</div>
				<div class="one-line">
					<label>所属区域</label><input type="text" readOnly=true name="areaName" class="input"/>
					<input type="hidden" name="areaId"/>
				</div>
				<div class="one-line">
					<label>所属区域</label>
					<select name="gtype">
						<option value="1">一类修理厂</option>
						<option value="2">二类修理厂</option>
						<option value="3">三类修理厂</option>
						<option value="4">汽配城</option>
					</select>
				</div>
				<div class="one-line">
					<label>修理厂电话</label><input type="text" name="garagePhone" class="input"/>
				</div>
				<div class="one-line">
					<label>图片</label><div id="idUploadArea1" class="upload-area"><a id="idupload1" class="ui-button" file-data="" path-data="" disabled="true">上传图片</a></div>
					<input type="hidden" id="value1" name="garageImg"/>
				</div>
				<div class="one-line">
					<label>备注</label><textarea name="garageRemark" class="textarea input"></textarea>
				</div>
				<div class="one-line btns" style="text-align:left;">
					<a href="javascript:void(0)" class="btn" onclick="javascript:return cusForm();">提交</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		var path='<%=path%>';
		$.fn.zTree.init($('#typeTree'),{
				async:{url:'<%=path%>/garage/queryAone.html',autoParam:['divisionId=divisionId'],enable:true,dataFilter:typeFilter},
				check:{enable:true,autoCheckTrigger:false,chkStyle: "checkbox",chkboxType: {'Y':'',N:''}},
				data:{keep:{isParentDefaultValue:true,parent:false,leaf:true},key:{name:'divisionName',children:'nodes'},
						simpleData:{enable:true,idKey:'divisionId',pidKey:'divisionPid',rootPid:0}},
				nodes:[],
				callback:{onCheck:typeSel}
		});
		var showCbi=function(url1,parentId,targetId){
			var url = url1,lh='',
			lh='<img src="'+url+'" class="up-end-img"/><a href="javascript:void(0)" onclick="removePic(\''+parentId+'\',\''+targetId+'\')" class="del-pic" title="删除图片"></a>'
			$('#'+parentId).prepend(lh);
			$('#'+parentId).children('.upload-info').hide();
			$('#'+targetId).val(url1);
		}
		var removePic=function(parentId,targetId,flag){
			var parentE = $('#'+parentId),url = $('#'+targetId).val();
			parentE.find('.upload-info').show();
			parentE.find('.up-end-img').remove();
			parentE.find('.del-pic').remove();
			$('#'+targetId).val('');
			//服务器删除 图片  后台接口暂缺
			if(!flag){
				$.ajax({
					url :path+'/ftpOper/delete.html',
					type : 'get',
					data:{imageUrl:url},
					cache:false,
					dataType:'json',
					success :function(responseData){
					},
					error : function(e) {
						console.log(e.responseText);
					}
				});
			}
		}
		var ucb = function(data){
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
					showCbi(dataJ.imageUrl,this.parentId,this.targetId);
				}else{
					alert(dataJ.description);
				}
			}
		}
		window.idupload1 = new UPLOAD({'srcId' : 'idupload1','targetId' : 'value1','width' : 140,'height' : 100,
			'callback' : ucb,'selfName' : 'idupload1','parentId' : 'idUploadArea1','fileNameBack':'file',typep:3
		});
		window.idupload1._init();
		function typeFilter(treeId,pnode,resData){
			var data = resData.ads;
			if(data){
				for(var i=0,len=data.length;i<len;i++){
					data[i].isParent=true;
				}
			}else{
				pnode.isParent=false;
			}
			return data;
		}
		function typeSel(e,treeId,node){
			var treeObj = $.fn.zTree.getZTreeObj(treeId),nodes = treeObj.getCheckedNodes(true),typeIds=[],typeNames=[];
			if(nodes.length>0){
				$('input[name="areaName"]').val(nodes[nodes.length-1].divisionName);
				$('input[name="areaId"]').val(nodes[nodes.length-1].divisionId);
				
			}
		}
		function cusForm(){
			var gaF = $('#garaForm'),formData = gaF.serialize();
			$.ajax({
				url :path+'/garage/create.html',
				type : 'get',
				data:formData,
				async:false,
				cache:false,
				dataType:'json',
				success :function(responseData){
					if(responseData.messageCode == '20000'){
						alert('保存成功');
						gaF.find('input[name="garageName"]').val('');
						gaF.find('input[name="garagePhone"]').val('');
						gaF.find('input[name="garageRemark"]').val('');
						removePic('idUploadArea1','value1',true);
					}else{
						alert(responseData.description);
					}
				},
				error : function(e) {
					console.log(e.responseText);
				}
			});
		}
	</script>
</body>
</html>